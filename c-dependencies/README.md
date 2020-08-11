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
 commons-text library. Use one of their APIs in your main method.
 
 --> using an implementation dependency, not an API dependency. What's the difference?
 How do i use this implementation dep?