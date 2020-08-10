# b-gradle-application

## Initializing a Gradle Wrapper
The Gradle Wrapper allows developers in your team the ability to run the same
version of Gradle and guarantees they all can all run Gradle builds.
To run Gradle simple run `gradle wrapper` in your command line. This now allows you to
run any Gradle task in your project using the `gradlew` shell script or bat file found
in this projects root directory.

When the Gradle Wrapper is run, it performs the following actions:
* Parses args passed to `gradlew`
* Installs the correct Gradle version
* Invokes Gradle to run specified tasks

What the Gradle Wrapper does not do is execute your tasks. The
wrapper is used to eliminate the need for developers to manage distributions
themselves.

## Advantages of Gradle and Important Features
### High Performance
Avoids unnecessary work by only running the tasks needed because inputs or
outputs have changed. Can also decrease amount of work done by using a build cache
in order to reuse task outputs from previous runs. 

### JVM Foundation
Runs on JVM with a JDK installed in order to use. This makes it easy to run Gradle
on different platforms.

### IDE Support
Several major IDE's allow you to import Gradle builds and interact with them.


What new functionality does your IDE provide when you use build tools like Gradle?