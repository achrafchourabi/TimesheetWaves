FROM mcr.microsoft.com/windows/nanoserver:1903
ADD target/Timesheet-spring-boot-5.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8083