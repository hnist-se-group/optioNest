<template>
    <el-row justify="center" style="margin-top: 25%; translate: 0 -50%;">
        <el-col :span="6">
            <el-card>
                <el-form ref="form_ref" :model="user" :rules="rules" size="large" status-icon hide-required-asterisk>
                    <el-form-item prop="username" label="username">
                        <el-input :validate-event="false" v-model="user.username" />
                    </el-form-item>
                    <el-form-item prop="password" label="password">
                        <el-input :validate-event="false" v-model="user.password" show-password />
                    </el-form-item>
                    <el-form-item>
                        <el-button @click="login" style="margin: auto;" type="primary" plain>Login</el-button>
                    </el-form-item>

                    <el-row justify="end">
                        <el-text type="primary" @click="">Primary</el-text>
                    </el-row>
                </el-form>
            </el-card>
        </el-col>
    </el-row>
</template>

<script setup>
import { reactive, ref } from "vue";
import axios from "../utils/axios";
import { useStore } from "../stores/user";

const store = useStore();

const user = reactive({});
const form_ref = ref();
const rules = reactive({
    username: [
        { required: true, message: 'username is empty', trigger: 'blur' }
    ],
    password: [
        { required: true, message: 'password is empty', trigger: 'blur' }
    ]
});

async function login() {
    await form_ref.value.validate((valid) => {
        if (valid) {
            axios.post('/login', {
                username: user.username,
                password: user.password
            }).then((response) => {
                store.login = true;
                store.uid = response.data;
            });
        }
    });
}
</script>