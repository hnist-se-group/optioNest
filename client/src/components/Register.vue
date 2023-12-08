<template>
    <el-form ref="formRef" :model="user" :rules="rules" size="large" status-icon hide-required-asterisk>
        <el-form-item prop="username">
            <el-input :validate-event="false" v-model="user.username" placeholder="username" />
        </el-form-item>
        <el-form-item prop="password">
            <el-input :validate-event="false" v-model="user.password" placeholder="password" show-password />
        </el-form-item>
        <el-form-item prop="confirm">
            <el-input :validate-event="false" v-model="user.confirm" placeholder="confirm" show-password />
        </el-form-item>

        <el-form-item>
            <el-button @click="register" style="margin: auto; width: 100%;" type="primary" plain>
                register
            </el-button>
        </el-form-item>

        <el-row justify="space-between">
            <el-text type="danger">{{ user.err }}</el-text>
            <el-link type="primary" :underline="false" @click="$emit('changeState')">
                login
            </el-link>
        </el-row>
    </el-form>
</template>

<script setup>
import { reactive, ref } from "vue";
import axios from "../utils/axios";

const emit = defineEmits(['changeState']);

const user = reactive({});
const formRef = ref();

const confirmValidate = (rule, value, callback) => {
    if (value == undefined || value === '') {
        callback(new Error('Please input password again'))
    } else if (value !== user.password) {
        callback(new Error("Two inputs don't match!"))
    } else {
        callback()
    }
}
const rules = reactive({
    username: [
        { required: true, message: 'Please input username' }
    ],
    password: [
        { required: true, message: 'Please input password' }
    ],
    confirm: [
        { validator: confirmValidate }
    ]
});

async function register() {
    await formRef.value.validate((valid) => {
        if (valid) {
            axios.post('/register', {
                username: user.username,
                password: user.password
            }).then((response) => {
                if (response.data)
                    emit('changeState');
                else
                    user.errmsg = 'username already exists';
            });
        }
    });
}
</script>