FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-worker-1.0.0.jar hr-worker.jar
ENTRYPOINT ["java","-jar","/hr-worker.jar"]