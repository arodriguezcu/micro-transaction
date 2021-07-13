FROM openjdk:8-alpine
COPY "./target/transaction-service-0.0.1-SNAPSHOT.jar" "apptransaction-service.jar"
EXPOSE 8093
ENTRYPOINT ["java","-jar","apptransaction-service.jar"]