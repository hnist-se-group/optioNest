import axios from "axios";

export default axios.create({
    baseURL: "http://127.0.0.1:4523/m1/3722788-0-default",
    headers: {
        'Content-Type': 'multipart/form-data'
    }
});