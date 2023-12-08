<template>
    <el-form ref="formRef" :model="user" :rules="rules" size="large" status-icon hide-required-asterisk>
        <el-form-item prop="username">
            <el-input :validate-event="false" v-model="user.username" placeholder="username" />
        </el-form-item>
        <el-form-item prop="password">
            <el-input :validate-event="false" v-model="user.password" placeholder="password" show-password />
        </el-form-item>

        <el-form-item>
            <el-button @click="login" style="margin: auto; width: 100%;" type="primary" plain>
                Login
            </el-button>
        </el-form-item>

        <el-row justify="space-between">
            <el-text type="danger">{{ user.errmsg }}</el-text>
            <el-link type="primary" :underline="false" @click="$emit('changeState')">
                register
            </el-link>
        </el-row>
    </el-form>
</template>

<script setup>
import { reactive, ref } from "vue";
import axios from "../utils/axios";
import { useStore } from "../stores/user";

const store = useStore();

const user = reactive({});
const formRef = ref();
const rules = reactive({
    username: [
        { required: true, message: 'Please input username' }
    ],
    password: [
        { required: true, message: 'Please input password' }
    ]
});

async function login() {
    await formRef.value.validate((valid) => {
        if (valid) {
            axios.post('/login', {
                username: user.username,
                password: user.password
            }).then((response) => {
                if (~response.data) {
                    store.login = true;
                    store.uid = response.data.uid;
                    store.headImg = response.data.headImg;
                } else
                    user.errmsg = 'user does not exist';
            });
        }
    });
}
</script>