# Sử dụng image Node.js chính thức từ Docker Hub
FROM node:16

# Tạo thư mục làm việc trong container
WORKDIR /app

# Sao chép package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt các phụ thuộc
RUN npm install

# Sao chép mã nguồn vào container
COPY . .

# Mở cổng 3000 cho ứng dụng
EXPOSE 3000

# Lệnh để chạy ứng dụng
CMD ["node", "app.js"]
