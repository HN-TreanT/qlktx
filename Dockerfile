# Sử dụng OpenJDK 17 làm base image
FROM openjdk:21-slim

# Thiết lập thư mục làm việc
WORKDIR /app

#Thêm gói cài đặt cho font chữ export excel
RUN apt-get update && apt-get install -y fontconfig libfreetype6
# Sao chép tệp pom.xml vào thư mục hiện tại
# Cài đặt Maven
RUN apt-get update && \
    apt-get install -y maven
COPY pom.xml .

# Sao chép toàn bộ mã nguồn vào thư mục hiện tại
COPY src src

# Chạy ứng dụng Spring Boot bằng Maven
CMD ["mvn", "spring-boot:run"]
