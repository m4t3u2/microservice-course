FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-payroll-1.0.0.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","/hr-payroll.jar"]