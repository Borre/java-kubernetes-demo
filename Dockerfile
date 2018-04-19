FROM opensuse:latest

WORKDIR /app

ADD . /app

RUN zypper -n in java-1_8_0-openjdk java-1_8_0-openjdk-devel

ENV JAVA_HOME /usr/lib64/jvm/jre/

RUN ./gradlew clean

RUN ./gradlew jarGenerator

EXPOSE 8080

CMD ["java", "-jar", "/app/build/libs/app-0.1.jar"]