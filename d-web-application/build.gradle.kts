plugins {
    application
}

application {
    mainClassName = "com.contrastsecurity.HelloWorld"
}

dependencies {
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("org.glassfish.jersey.inject" , "jersey-hk2", "2.31")
    runtimeOnly("org.glassfish.jaxb", "jaxb-runtime", "2.3.2")

    // For Grizzly
//    implementation("org.glassfish.jersey.containers:jersey-container-grizzly2-http:2.26")

    // For Jetty
    implementation("org.glassfish.jersey.containers:jersey-container-jetty-http:2.26")

}

repositories {
    mavenCentral()
    jcenter()
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}
