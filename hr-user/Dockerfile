FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-user-1.0.0.jar hr-user.jar
ENTRYPOINT ["java","-jar","/hr-user.jar"]