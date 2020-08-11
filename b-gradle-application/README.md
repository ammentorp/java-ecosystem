# b-gradle-application

## Initializing a Gradle Wrapper
The Gradle Wrapper allows developers in your team the ability to run the same
version of Gradle and guarantees they all can all run Gradle builds.
To run Gradle simple run `gradle wrapper` in your command line. This now allows you to
run any Gradle task in your project using the `gradlew` shell script or bat file found
in this projects root directory. With build tools like Gradle, IDE's can easily 
synchronize project settings and running tasks.

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


## Compiling and Executing with Gradle
First, a `b-gradle-application/build.gradle.kts` file is created to host the various 
plugins we will use in this project. The first plugin is called `application` 
which indicates the entrypoint/main method of the project. The second extension
is `distribution` which will be used to creates a single distribution in 
the distributions container extension named `main`.
This separate build file for b-gradle-application directory is created because
if you have it in the root then it will attempt to use those build settings for 
every directory in the wrapper.

The task at hand here is to compile the program. To do so type the command 
`gradle build` in the command line. This Gradle task assembles and tests
your project. It creates a `build/` directory in your cwd. The build directory
of this project into which Gradle generates all build artifacts.

When running this program using the application plugin's `run` task, the
project is run/started as a JVM application.

When running this program using the application plugin's `disTar`
(a distribution task) task, the application bundles the project as a 
distribution. This task depends on: jar, startScripts and it creates 
a full distribution TAR archive including runtime libraries and OS 
specific scripts.
These distribution plugins facilitate building archives that serve as 
distributions of the project. Distribution archives typically contain the 
executable application and other supporting files, such as documentation.

Usage
how to run gradle app from the tarball