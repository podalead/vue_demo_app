FROM gradle:6.2-jdk11 AS builder
COPY . .

RUN apt-get update -y \
  && apt-get install -y curl \
  && curl -sL https://deb.nodesource.com/setup_8.x | bash - \
  && apt-get install -y nodejs \
  && curl -L https://www.npmjs.com/install.sh | sh

RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add - \
  && echo "deb https://dl.yarnpkg.com/debian/ stable main" >> /etc/apt/sources.list.d/yarn.list \
  && apt-get update -y \
  && apt-get install -y yarn

RUN ./gradlew build


FROM openjdk:13-jdk-alpine AS runner

RUN addgroup -S spring \
    && adduser -S spring -G spring

RUN mkdir -p ./logs \
    && chown spring:spring ./logs \
    && chmod 764 ./logs

USER spring:spring

ARG BUILDER_HOME=/home/gradle
ARG JAR_FILE=${BUILDER_HOME}/build/libs/*.jar
COPY --from=builder ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]