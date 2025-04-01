const express = require('express');
const mongoose = require('mongoose');
const app = express();
const port = 3000;

app.use(express.json());

// Kết nối MongoDB
mongoose.connect('mongodb://mongo:27017/mydb', {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(() => {
    console.log('Connected to MongoDB');
}).catch(err => {
    console.error('Failed to connect to MongoDB', err);
});

// API mẫu đơn giản
app.get('/', (req, res) => {
    res.send('Hello World from Node.js app!');
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});