# Sử dụng image python làm base
FROM python:3.9-slim

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép tệp requirements.txt vào container
COPY requirements.txt /app/

# Cài đặt các thư viện Python cần thiết
RUN pip install --no-cache-dir -r requirements.txt

# Sao chép mã nguồn ứng dụng vào container
COPY . /app/

# Mở cổng 5000 để Flask có thể chạy
EXPOSE 5000

# Chạy ứng dụng Flask khi container bắt đầu
CMD ["python", "app.py"]
