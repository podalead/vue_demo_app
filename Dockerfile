FROM gradle:8.3.0-jdk17-jammy AS builder

MAINTAINER "poda@cloudninja.com.ua"

COPY . .

RUN apt-get update -y \
  && apt-get install -y curl \
  && curl -sL https://deb.nodesource.com/setup_18.x | bash - \
  && apt-get install -y nodejs \
  && curl -L https://www.npmjs.com/install.sh | sh

RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add - \
  && echo "deb https://dl.yarnpkg.com/debian/ stable main" >> /etc/apt/sources.list.d/yarn.list \
  && apt-get update -y \
  && apt-get install -y yarn

RUN gradle clean build


FROM eclipse-temurin:17-jre-jammy AS runner

ARG user=spring
ARG group=spring

RUN adduser --system --group ${user}

RUN mkdir -p ./logs \
    && chown ${user}:${group} ./logs \
    && chmod 764 ./logs

ENV SPRING_PROFILES_ACTIVE="dev"
ENV H2_URL="jdbc:h2:mem:test"

USER spring:spring

USER ${user}:${group}

ARG JAR_FILE="/home/gradle/build/libs/app-*.jar"

COPY --from=builder ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
