plugins {
    application
}

application {
    mainClassName = "com.contrastsecurity.HelloWorld"
    applicationDefaultJvmArgs = listOf(/*"-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005",*/ "-javaagent:../f-agent/build/libs/f-agent.jar")
}

dependencies {
    implementation("org.apache.commons:commons-text:1.8")
}

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}