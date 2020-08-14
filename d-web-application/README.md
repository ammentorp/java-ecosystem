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

Next, we will create 2 new classes: 
* `TestApplication.java`
* `JerseyEndpoint.java` (our API endpoint accessible at the path `/ping`)

`TestApplication` extends `javax.ws.rs.core.Application`. This way allows a 
portable way to configuring resources and providers in a JAX-RS web service.
This class calls `JerseyEndpoint`. This `Application` class is JAX-RS config 
class.

`JerseyEndpoint` is where we will insert our `GET` and `PATH` HTTP requests. 
Inside this class we also want to use one of the static methods to create
a Response instance using a ResponseBuilder.

Now that we have these 2 new classes, we want our driver, `HelloWorld`, to 
build this application and deploy our endpoint to an embedded HTTP server.
In this case, we used Grizzly. An embedded HTTP server is a component of a 
software system that implements the HTTP protocol. Other examples of embedded 
HTTP servers include Jetty, Tomcat, etc. To deploy `JerseyEndpoint` we will
be using the Jersey implementation of JAX-RS.

Import the following project dependencies:
* `implementation("org.glassfish.jersey.containers:jersey-container-servlet-core:2.26")`
* `implementation("org.glassfish.jersey.inject" , "jersey-hk2", "2.31")`
* `runtimeOnly("org.glassfish.jaxb", "jaxb-runtime", "2.3.2")`

Notice the last dependency is used only at runtime.

We now want our `HelloWorld` class to extend `ResourceConfig`, which is the resource
configuration for our web application. Create a `final ResourceConfig` instance of our
application, `TestApplication`. Next, create an HttpServer instance of Grizzly to our
`localhost:8080` using a UriBuilder. Run the web application on your machine and send 
it an HTTP request to http://localhost:8080/ping to make sure it works.
