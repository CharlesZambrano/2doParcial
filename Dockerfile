# docker build -t charles .
# docker-compose down
# docker-compose up -d --build

FROM eclipse-temurin:21-jre-alpine
COPY build/libs/charles-0.0.1-SNAPSHOT.jar /app/charles-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/charles-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
RUN apk --update --no-cache add curl
HEALTHCHECK --interval=1m --timeout=30s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1
LABEL version="0.1" \
    description="SECON PARTIAL TEST"
