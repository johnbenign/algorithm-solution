FROM openjdk:11-jre-slim
WORKDIR /app
COPY XorSubArray.jar /app/XorSubArray.jar
CMD ["java", "-jar", "XorSubArray.jar"]