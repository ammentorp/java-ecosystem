plugins {
    war
}

dependencies {
    implementation("javax.servlet:javax.servlet-api:3.0.1")
}

repositories {
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11
    targetCompatibility = org.gradle.api.JavaVersion.VERSION_11
}

tasks.war {
    manifest {
        attributes("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}
