# c-depedencies

## Executing a Multi-Project Build
First, ensure you have added an import statement for your new project
to your `settings.gradle.kts`. To check the list of projects in the 
`java-ecosystem` build, run `gradle -q projects`.
This will output:

`To see a list of the tasks of a project, run gradle <project-path>:tasks`

and to run the `c-dependencies` project run:

`./gradlew c-dependencies:run`
 
from the projects root directory.
 
Alternately, you can run Gradle wrapper tasks from inside the `c-dependencies`
directory as such: `.././gradlew <task>`.
 
## Java Program using Apache's commons-text Lib
Modify the program to use a third-party dependency such as Apache’s 
commons-text library. Use one of their APIs in your main method. If you
notice, there are two types of dependencies to choose from: API or 
Implementation. For this use case, we will use an implementation dependency.

### Implementation vs API Dependency
Dependencies appearing in the `api` configurations will be transitively 
exposed to consumers of the library, and as such will appear on 
the compile classpath of consumers. Dependencies found in the `implementation` 
configuration will, on the other hand, not be exposed to consumers, and 
therefore not leak into the consumers' compile classpath. When given the choice,
always prefer `implementation` over `api`.


## Using an Implementation Dependency and Running the Application
To use an implementation dependency, declare the dependence in your
 `build.gradle.kts` as such:
 
 `dependencies {
      implementation("org.apache.commons:commons-text:1.8")
  }`
  
 and add `import <your_dep>;` to your main file.
 In this case: `import org.apache.commons.text.WordUtils;`
 
Compile and run this code.

### run Task
Notice the run task creates a build folder like it did in b-gradle-application.
Inside this build folder we see `classes`, `generated`, and `tmp` dirs.

### distTar Task
After running distTar command we see it creates a distributions dir 
(where tarball is located) along with `libs`, `scripts` sub directories.
 

## Running JAR File & Errors
Next run the JAR file that’s in `c-dependencies/build/libs`.

JAR cmd:
`java -jar build/libs/c-dependencies.jar `

When running the JAR file, you will get a `NoClassDefFoundError` for the 
specified class used in your main method, this means the main thread is 
unable to find this particular class. In the case of a 
`NoClassDefFoundError`, the problematic class was present during compile 
time but not available during runtime.

To resolve this error, we must specify the classpath, which is the path to
a directory or list of the directories which is used by `ClassLoaders`
to find and load class in Java program.

`CLASSPATH` is an environment variable used by the JVM to locate user-defined
classes. You can also choose to set the classpath in your `java` command by
specifying the path to each jar file as such:

`java -cp path/to/file1.jar:path/to/file2.jar:path/to/file2.jar com.contrastsecurity.HelloWorld`

NOTE: the path to your jar files should be the path to the JAR files resulting
from unpacking your tarball located in `c-dependencies/build/distributions`.

## Uber JAR
An uber jar, also known as a fat JAR or JAR with dependencies, is a JAR file 
that contains not only a Java program, but embeds its dependencies as well. 
This means that the JAR functions as an "all-in-one" distribution of the 
software, without needing any other Java code. The advantage is that you 
can distribute your uber-jar and not care at all whether or not 
dependencies are installed at the destination, as your uber-jar actually 
has no dependencies. An Uber JAR is a JAR that contains both our package 
and all its dependencies in one single JAR file.