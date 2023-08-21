FROM openjdk:17-oracle

EXPOSE 8098:8098

COPY target/spring-money-transfer-service-0.0.1-SNAPSHOT.jar mymtsapp.jar

ENTRYPOINT ["java","-jar","/mymtsapp.jar"]