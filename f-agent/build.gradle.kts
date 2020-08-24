plugins {
    java
}

dependencies {
    implementation("org.ow2.asm:asm:8.0.1")
    implementation("org.ow2.asm", "asm-commons", "8.0.1")

}

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        attributes("Premain-Class" to "com.contrastsecurity.HelloWorldAgent")
        attributes("Can-Redefine-Classes" to true)
    }
    from({
        configurations.runtimeClasspath.get().filter{
            it.name.endsWith("jar")
        }.map{ zipTree(it) }
    })
}