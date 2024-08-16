## CodeDrop - Sàn thương mại mua bán mã nguồn

Ứng dụng này được thiết kế để tạo ra một nền tảng giao dịch mã nguồn uy tín. Nơi kết nối giữa người mua và người bán thông qua các giao dịch đơn giản, tiện lợi, nhanh chóng và an toàn, mang lại trải nghiệm hiệu quả vượt trên cả mong đợi.

© 2024 SRTeam.

### Frontend
> Link: **_https://github.com/duyplus/CodeDropApp_**

### Danh mục

#### 1. Tính năng chính:
  - Client
    + Đăng ký, đăng nhập tài khoản
    + Quên mật khẩu, đổi mật khẩu, thông tin tài khoản
    + Tìm kiếm mã nguồn theo bộ lọc
    + Đăng bán hoặc mua mã nguồn
    + Bình luận, đánh giá và yêu thích mã nguồn
    + Nạp tiền bằng cách quét mã QR ngân hàng hoặc ví điện tử
    + Gửi yêu cầu rút tiền theo thông tin ngân hàng của tài khoản
    + Lịch sử giao dịch và doanh thu
  - Administrator
    + Quản lý mã nguồn, người dùng, danh mục, bình luận, đánh giá,..
    + Quản lý huỷ và duyệt mã nguồn
    + Quản lý hóa đơn chi tiết, thanh toán
    + Quản lý kiểm toán và chốt lệnh rút tiền
    + Quản lý thống kê doanh thu

#### 2. Công nghệ sử dụng:
  - Java Core, Spring Boot, Spring Security, Spring Data JPA
  - Apache Tomcat, MSSQL Server

#### 3. Môi trường phát triển:
  - IntelliJ IDEA
  - Microsoft SQL Server

#### 4. Công cụ hỗ trợ:
  - Project Lombok
  - JPA Buddy
  - Postman, Swagger
  - Git

### CRUD RESTful APIs

| Methods | Urls            | Status Code      | Actions                  |
|---------|-----------------|------------------|--------------------------|
| GET     | /api/(name)     | 200 (OK)         | Retrieve all (name)      |
| POST    | /api/(name)     | 201 (Created)    | Create a new (name)      |
| GET     | /api/(name)/:id | 200 (OK)         | Retrieve a (name) by :id |
| PUT     | /api/(name)/:id | 200 (OK)         | Update a (name) by :id   |
| DELETE  | /api/(name)/:id | 204 (No Content) | Delete a (name) by :id   ||

### License
[![License: MIT](https://img.shields.io/github/license/duyplus/CodeDrop.svg?color=yellow)](LICENSE)
