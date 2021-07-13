FROM openjdk:8-alpine
COPY "./target/micro-transaction-0.0.1-SNAPSHOT.jar" "appmicro-transaction.jar"
EXPOSE 8093
ENTRYPOINT ["java","-jar","appmicro-transaction.jar"]