plugins {
    application
    distribution
}

application {
    mainClassName = "com.contrastsecurity.HelloWorld"
}

tasks.jar {
    manifest {
        attributes ("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}