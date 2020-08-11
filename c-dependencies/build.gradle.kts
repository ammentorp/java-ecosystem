plugins {
    application
}

application {
    mainClassName = "com.contrastsecurity.HelloWorld"
}

dependencies {
//    api("org.apache.commons:commons-text:1.9")
    implementation("org.apache.commons:commons-text:1.8")
}

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        attributes ("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}