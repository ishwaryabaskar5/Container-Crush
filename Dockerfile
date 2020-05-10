FROM openjdk:1.8

ADD ./target/product-0.0.1-SNAPSHOT.jar /usr/src/product-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar","product-0.0.1-SNAPSHOT.jar"]