# b-gradle-application

## Initializing a Gradle Wrapper
The Gradle Wrapper allows developers in your team the ability to run the same
version of Gradle and guarantees they all can all run Gradle builds.
To run Gradle simple run `gradle wrapper` in your command line. This now allows you to
run any Gradle task in your project using the `gradlew` shell script or bat file found
in the projects root directory. With build tools like Gradle, IDE's can easily 
synchronize project settings and running tasks.

When the Gradle Wrapper runs, it performs the following actions:
* Parses args passed to `gradlew`
* Installs the correct Gradle version
* Invokes Gradle to run specified tasks

What the Gradle Wrapper does not do is execute your tasks. The
wrapper eliminates the need for developers to manage distributions
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
Before anything, you should copy and paste the "Hello World" Java program
from `a-helloworld` directory in the correct location under `b-gradle-application`.
To do this, we must create a `com.contrastsecurity` package in our gradle application
directory. This dir path will look like: `src/main/java/com.contrastsecurity`. This
path is necessary for Gradle to recognize your project as a Gradle application.

Next, create a `b-gradle-application/build.gradle.kts` file to host the various 
plugins we will use in this project. The first plugin is `application` 
which indicates the entrypoint/main method of the project. Within `application`
your main class should be defined. Either way works:
* `mainClassName = "com.contrastsecurity.HelloWorld"` 
* `mainClass.set("com.contrastsecurity.HelloWorld")`


After setting the main class, you will run `./gradlew run` which will create
a `/build` directory within b-gradle-application directory. When using the 
application plugin's `run` task, the project runs/starts as a JVM application.
This `/build` dir should contain several sub directories. Alternately we can run 
the command: `./gradlew build` in the command line from the root dir (this 
is where your gradle wrapper should be located). This Gradle task assembles 
and tests your project. It also creates a `build/` directory in your cwd if
one is not already present. The `/build` directory of this project into 
which Gradle generates all build artifacts.

When running this program using the application plugin's `disTar`
(a distribution task) task, the application bundles the project as a 
distribution. This task depends on: jar, startScripts and it creates 
a full distribution TAR archive including runtime libraries and OS 
specific scripts. These distribution plugins facilitate building archives 
that serve as distributions of the project. Distribution archives typically 
contain the executable application and other supporting files, such as 
documentation.

Next, we want to unpack the tarball located in `build/distributions` and
direct the output into a new directory within `/build` called `output`.
You must first create this directory before running your tar command.

To unpack run: 

`tar zxvf b-gradle-application/build/distributions/b-gradle-application.tar -C b-gradle-application/build/output`

Within `build/output/b-gradle-application` we now see `/bin` and `/lib` dirs.
There is a shell script located in our `/bin` dir, which we can run your 
application `b-gradle-application` (for MacOS users) or 
`b-gradle-application.bat` (for Windows users) as an executable.

To run this script, enter in your command line:

`./b-gradle-application/build/output/b-gradle-application/bin/b-gradle-application`

Notice there is a JAR file in `b-gradle-application/build/libs`. When run using
`java -jar ...`, this will run your project as a Gradle application.
We obtain the same result as we do when running the shell script.

Unpack this JAR file using by first creating a `build/jar-output` sub 
directory and navigate to the new directory. Unpack the JAR file: 

`jar -xvf ../libs/b-gradle-application.jar`

In this JAR file we see there are two subdirectories:
1. com (contains contrast/HelloWorld.class)
1. META-INF (contains your manifest)


### If your build or run does fails & cannot find or load main class
If this happens, we must explicitly set the entrypoint. In our
`b-gradle-application/build.gradle.kts` file, add:

`tasks.jar {
    manifest {
        attributes ("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
}`