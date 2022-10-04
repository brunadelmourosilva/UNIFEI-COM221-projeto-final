FROM maven:3.8.6-openjdk-11

WORKDIR /app

COPY . /app

RUN mvn clean install

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]