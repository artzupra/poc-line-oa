# ใช้ Node.js เวอร์ชัน 18 (สามารถเปลี่ยนเวอร์ชันได้)
FROM node:18-alpine

# กำหนด working directory ใน container
WORKDIR /app

# คัดลอก package.json และ package-lock.json เข้า container
COPY package*.json ./

# ติดตั้ง dependencies
RUN npm install

# คัดลอกไฟล์ทั้งหมดเข้า container
COPY . .

# ระบุ port ที่ container จะใช้
EXPOSE 3000

# คำสั่งเริ่มรันแอป
CMD ["node", "webhook.js"]
