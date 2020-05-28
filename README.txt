Ý tưởng ban đầu:
server cung cấp dịch vụ chat
client sau khi bật lên sẽ tự động kết nối với server
mỗi lần gửi tin client đảm bảo gửi cả ip và port của ng nhận
có thể là danh sách người nhận
server sẽ nhận các tin từ client gửi đến và gửi lại đến client đích phù hợp
như vậy nếu quá nhiều người trong mạng cùng gửi tin server sẽ gặp phải tình trạng quá tải
để các client có thể gửi hoặc nhận được các tin nhắn liên tiếp thì phải có luồng in và luồng out chạy riêng biệt
====
tôi dùng NetBeans IDE để tạo project này
