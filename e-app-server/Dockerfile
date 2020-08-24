FROM tomcat
COPY e-app-server/build/libs/e-app-server.war /usr/local/tomcat/webapps/ROOT.war
COPY f-agent/build/libs/f-agent.jar /usr/local/
ENV CATALINA_OPTS="-javaagent:/usr/local/f-agent.jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005"