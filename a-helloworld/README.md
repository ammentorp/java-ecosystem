# a-helloworld
In this subdirectory is a `HelloWorld.java` with a main 
that prints out `"Hello World"` to `stdout` when compiled and run.

Following, the class from the default package is moved to a package called 
com.contrastsecurity. Because java uses file system directories to store 
packages, any `.java` files that are defined as part of com.contrastsecurity
package must be stored in a com/contrastsecurity subdirectory in order to 
compile and run this again.

This compiled Java code is then packaged into a JAR file. A JAR (Java Archive) 
file is a package file format used to combine many Java class files 
and associated resources into one file. This file then has the ability to distribute
application software/libs on the Java platform.
## Creating a JAR File
`jar cf jarfilename inputfiles`
## Viewing a JAR File
`jar tf jarfilename`
## Runnning a JAR File
### Without Manifest File
This will run with your pre-defined manifest file
`java -cp jarfilename classpath`
In this case:
`java -cp HelloWorld.jar com.contrastsecurity.HelloWorld`
### With Manifest File
`java -jar jarfilename`

### Important Notes
When creating your JAR file, a default manifest is created. Instructions above indicate
how to run your JAR file with and without a manifest. Adding a manifest to your 
JAR file gives the user more control over what the jar command generates. 
In com.contrastsecurity package, an `example_manifest.txt` was created. 
In this file, a Main-Class attribute was added. This text file serves our 
applications entry point.
