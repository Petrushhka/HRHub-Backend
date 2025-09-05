## 1단계: Build
#FROM eclipse-temurin:17-jdk-jammy AS build
#WORKDIR /app
#
## Gradle 캐시 최적화: 빈 settings/build 파일 먼저 복사 → 의존성 캐시
#COPY gradlew ./
#COPY gradle gradle
#COPY settings.gradle ./
#COPY build.gradle ./
## 있으면 복사
#COPY gradle.properties* ./
#RUN chmod +x ./gradlew
#
## 의존성만 먼저 당겨서 캐시
#RUN ./gradlew --no-daemon dependencies || true
#
## 소스 복사 후 빌드
#COPY src src
#RUN ./gradlew --no-daemon clean build -x test
## 2단계: 실행 (Distroless)
#FROM gcr.io/distroless/java17-debian11
#
#WORKDIR /app
#COPY --from=build /app/build/libs/*.jar app.jar
#
## 컨테이너 내부 포트 (문서화용)
#EXPOSE 8080
#
## 타임존/메모리/JIT 안정화 등 JVM 옵션 (Zeabur 환경변수로 덮어쓸 수 있게)
#ENV JAVA_TOOL_OPTIONS="-Duser.timezone=Asia/Seoul -Dfile.encoding=UTF-8"
#
## Spring Boot 기본 포트는 8080 (Zeabur가 포트 매핑)
#ENV SERVER_PORT=8080
#
## 실행 (distroless는 쉘 없음 → exec 형식)
#ENTRYPOINT [ "java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/app.jar" ]
#
