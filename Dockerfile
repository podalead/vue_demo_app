FROM oadsd AS builder
RUN ./gradlew build

FROM openjdk:8-jdk-alpine AS runner
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY --from=builder ${JAR_FILE} app.jar
CMD ["java","-jar","/app.jar"]