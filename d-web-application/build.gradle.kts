plugins {
    application
}

application {
    mainClassName = "com.contrastsecurity.HelloWorld"
}

dependencies {
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("org.glassfish.jersey.core:jersey-client:2.28")
}

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}