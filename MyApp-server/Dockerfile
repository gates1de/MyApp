FROM java:8

ADD build/libs/myapp-0.0.1-SNAPSHOT.jar /opt/tomcat8/webapps/myapp-0.0.1-SNAPSHOT.jar

WORKDIR /opt/tomcat8/webapps

EXPOSE 8080

CMD ["java", "-jar", "myapp-0.0.1-SNAPSHOT.jar"]
