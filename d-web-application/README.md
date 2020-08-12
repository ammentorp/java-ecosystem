# d-web-application

## Executing a Multi-Project Build
First, ensure you have added an import statement for your new project
to your `settings.gradle.kts`. To check the list of projects in the 
`java-ecosystem` build, run `gradle -q projects`.
This will output:

`To see a list of the tasks of a project, run gradle <project-path>:tasks`

and to run the `d-web-application` project run:

`./gradlew d-web-application:run`
 
from the projects root directory.
 
Alternately, you can run Gradle wrapper tasks from inside the `d-web-application`
directory as such: `.././gradlew <task>`.
 
## Jakarta RESTful Web Services (JAX-RS)

### REST Architecture
REST stands for REpresentational State Transfer. REST is web standards based architecture and uses 
HTTP Protocol. It revolves around resource where every component is a resource and a resource is 
accessed by a common interface using HTTP standard methods. REST was first introduced by Roy 
Fielding in 2000.

In REST architecture, a REST Server simply provides access to resources and REST client 
accesses and modifies the resources. Here each resource is identified by URIs/ global 
IDs. REST uses various representation to represent a resource like text, JSON, XML. 
JSON is the most popular one.

Web services based on REST Architecture are known as RESTful web services. 
These webservices uses HTTP methods to implement the concept of REST architecture.
A RESTful web service usually defines a URI, Uniform Resource Identifier a 
service, provides resource representation such as JSON and set of HTTP Methods.

#### HTTP methods
The following four HTTP methods are commonly used in REST based architecture.

* `GET` − Provides read-only access to a resource.

* `POST` − Used to create a new resource.

* `DELETE` − Used to remove a resource.

* `PUT` − Used to update a existing resource or create a new resource


## Using the JAX-RS Specification
Use the JAX-RS specification to define an API endpoint accessible at the 
path `/ping` which responds to HTTP requests of type `GET`. 
Do this by first adding your API dependency to `build.gradle.kts` as such:

`dependencies {
     implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
 }`
 
 Next, import the necessary classes in `HelloWorld.java`. 

       import javax.ws.rs.ApplicationPath;
       import javax.ws.rs.GET;
       import javax.ws.rs.Path;
Add the necessary annotations to method headers.

For Jersey installation, add the following line in the project dependency
section:

`implementation("org.glassfish.jersey.containers:jersey-container-servlet-core:2.26")`

### Using the Jersey Implementation of JAX-RS
Use the Jersey implementation of JAX-RS to deploy that endpoint to an embedded 
HTTP server in your program. An embedded HTTP server is a component of a 
software system that implements the HTTP protocol.

