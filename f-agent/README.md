# f-agent

Must be running on Java v11

## Creating a Java Agent
This first step is to create a Java Agent that does nothing. Initially, we want
to set the entrypoint. The manifest of the agent jar file must contain a 
`Premain-Class` attribute, which is the name of the agent class. The agent class
must implement a `public static premain()` similar to the main application
entrypoint. Further, we want to set `Can-Redefine-Classes` to true in our
manifest. Next, use `Instrumentation` to register a `ClassFileTransformer` either
in the same class as `premain` or in a new class. Attach the agent to one
of the programs written in a previous step using a remote debugger to ensure
it works.

## Setting up Remote Debugger in IntelliJ
1. Click "Edit configuration" button
1. Click `+` button in top left corner of resulting window
1. Create "remote" configuration which listens to localhost 5005
1. Give helpful name like "agent"

## Using the Remote Debugger
An example command with a remote debugger attached is:

`java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 -javaagent:path/to/file.jar -cp b-gradle-application/build/libs/b-gradle-application.jar com.contrastsecurity.HelloWorld`

Where `com.contrastsecurity.HelloWorld` holds the main method of `b-gradle-application` program

Note `suspend=y` will suspend the JVM until you attach the remote debugger

## ASM
ASM is an all-purpose Java bytecode manipulation and analysis framework. 
It can be used to modify existing classes or to dynamically generate classes, 
directly in binary form. ASM provides some common bytecode transformations 
and analysis algorithms from which custom complex transformations and code 
analysis tools can be built. ASM offers similar functionality as other Java 
bytecode frameworks, but is focused on performance. Because it was designed and 
implemented to be as small and as fast as possible, it is well suited for use in 
dynamic system.

In this project we will use ASM to transform the bytecode of the `main` method
in `com.contrastsecurity.HelloWorld` to add an instruction to print out an 
extra message defined in our agent. To do this we will update our 
`com.contrastsecurity.HelloWorldClassFileTransformer` to 

## What is an uber-JAR and why should we use it?
An uber-JAR, also known as a fat JAR or JAR with dependencies, is a JAR file 
that contains not only a Java program, but embeds its dependencies as well. 
This means that the JAR functions as an "all-in-one" distribution of the 
software, without needing any other Java code. The advantage is that you 
can distribute your uber-JAR and not care at all whether or not 
dependencies are installed at the destination, as your uber-jar actually 
has no dependencies. An Uber JAR is a JAR that contains both our package 
and all its dependencies in one single JAR file.

There are three common methods for constructing an uber-JAR:
1. Unshaded: unpack all JAR files, then repack into a single JAR
1. Shaded: same as unshaded + renaming packages of all deps
1. JAR of JARS: final JAR file contains the other JAR files embedded within

For the purpose of this project we will use JAR of JARs.
First, run the `java` command without attaching the remote debugger
from above and notice what happens. We get a `ClassNotFoundException`. This can
be fixed by making use of the uber-JAR design pattern. To do this we will edit
the `tasks.jar` attribute in our build file. Within this attribute we will add
the following:

`from({
         configurations.runtimeClasspath.get().filter{
             it.name.endsWith("jar")
         }.map{ zipTree(it) }
     })`
     
This is necessary in making the fat jar because the basic JAR generated
in `build/libs` doesn't include all the dependencies you need in order to run
your project.

Now, we are able to successfully attach our agent to `b-gradle-application` and
run it on `com.contrastsecurity.HelloWorld` by again running the command:

`java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 -javaagent:path/to/file.jar -cp b-gradle-application/build/libs/b-gradle-application.jar com.contrastsecurity.HelloWorld`