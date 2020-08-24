plugins {
    application
}

application {
    mainClassName = "com.contrastsecurity.HelloWorld"
    applicationDefaultJvmArgs = listOf("-javaagent:../f-agent/build/libs/f-agent.jar")
}

tasks.jar {
    manifest {
        attributes ("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}