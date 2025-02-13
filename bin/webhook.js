const express = require('express');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

app.post('/webhook', (req, res) => {
    const events = req.body.events;
    
    if (!events) {
        return res.sendStatus(400);
    }

    events.forEach(event => {
        if (event.source && event.source.type === 'group') {
            const groupId = event.source.groupId;
            console.log(`🔹 Group ID: ${groupId}`);

            // (ตัวอย่าง) ส่ง Group ID กลับไปยังกลุ่ม
            // replyMessage(event.replyToken, `Group ID ของคุณคือ: ${groupId}`);
        }
    });

    res.sendStatus(200);
});

// Function ส่งข้อความกลับไปที่ Line
// async function replyMessage(replyToken, message) {
//     const axios = require('axios');
//     const LINE_ACCESS_TOKEN = 'YOUR_LINE_CHANNEL_ACCESS_TOKEN';  // ใส่ Token ที่ได้จาก Line

//     await axios.post('https://api.line.me/v2/bot/message/reply', {
//         replyToken: replyToken,
//         messages: [{ type: 'text', text: message }]
//     }, {
//         headers: {
//             'Content-Type': 'application/json',
//             'Authorization': `Bearer ${LINE_ACCESS_TOKEN}`
//         }
//     });
// }

// Start Server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`🚀 Webhook running on port ${PORT}`));
