FROM openjdk:11-jdk-slim-buster AS builder
COPY . .

RUN apt-get update \
  && apt-get install -y curl \
  && curl -sL https://deb.nodesource.com/setup_9.x | bash - \
  && apt-get install -y nodejs \
  && curl -L https://www.npmjs.com/install.sh | sh

RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add - \
  && echo "deb https://dl.yarnpkg.com/debian/ stable main" >> /etc/apt/sources.list.d/yarn.list \
  && apt-get update \
  && apt-get install yarn

RUN ./gradlew build

FROM openjdk:13-jdk-alpine AS runner
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY --from=builder ${JAR_FILE} app.jar
CMD ["java","-jar","/app.jar"]