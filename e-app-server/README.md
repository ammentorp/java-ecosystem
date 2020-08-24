# e-app-server
Must use Java 11

## Defining an API endpoint using Servlet spec
This API endpoint should be accessible at the path `/ping` which responds 
to HTTP requests of type GET. The difference between this servlet application 
and the previous one (RESTful) is how they are deployed. The RESTful application
was run using our gradle wrapper, whereas this application will be deployed using Docker.

In this application we will only use one class, mark it as a `@WebServlet`,
and override HTTPServlet's `doGet` method. We want to set the `@WebServlet`
URL pattern as our path `/ping`.


## Build the WAR task to build the WAR file. 
Inspect the contents of that file. How does it differ from a JAR?

Unpacked WAR has 2 subclasses:

`extracted
    |-- META-INF
            |-- MANIFEST.MF
    |-- WEB-INF
            |-- classes (contains com.contrastsecurity package and classes)
            |-- lib (contains all library deps)`
            
            
## Create a Dockerfile to build a docker image based on the Tomcat base image 
## with your WAR file set to auto-deploy. 
### What is Tomcat & what does it provide? 
Tomcat is an open source implementation of the Java Servlet among other JavaEE's.
Tomcat is a servlet and JSP container. A Java servlet encapsulates code and 
business logic and defines how requests and responses should be handled in a 
Java server. JSP is a server-side view rendering technology. As the developer, 
you write the servlet or JSP page, then let Tomcat handle the routing.

https://www.infoworld.com/article/3510460/what-is-apache-tomcat-the-original-java-servlet-container.html


## Building your Dockerfile
The FROM instruction initializes a new build stage and sets the Base Image for 
subsequent instructions.

The COPY instruction copies new files or directories from <src> and adds them 
to the filesystem of the container at the path <dest>.

## Build the Image
The build is run by the Docker daemon, not by the CLI. It downloads any images that are 
necessary and also executes the commands specified in the Dockerfile.

In the below command, the Dockerfile we created earlier is used (Docker daemon looks 
for Dockerfile specified by the current directory using a dot) and the newly built 
image is tagged e-app-server.

`docker build -t e-app-server .`

To verify `e-app-server` image is build and ready to be used, run the command: `docker image ls`

## Run the Container

`docker run -rm -d -p 8080:8080 <image-name>`

Now go to `http://localhost:8080/ping` and check it works. 

## Docker Image vs Container
### Image
Docker images are static, meaning they don't change. Once you’ve made one, 
you can delete it, but you can’t modify it. If you need a new version of 
the snapshot, you create an entirely new image. Images are easily sha red between
machines.

### Container
Docker containers more or less an instance of an image. Each container runs separately,
and you can modify the container while it's running. Containers aren't meant to be shared.
Each Docker container on your computer is isolated and independent of one another.