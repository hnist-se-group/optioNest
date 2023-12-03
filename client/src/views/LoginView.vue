<template>
    <el-row justify="center" style="margin-top: 25%; translate: 0 -50%;">
        <el-col :span="6">
            <el-card>
                <el-form :model="user" :rules="rules" size="large" status-icon hide-required-asterisk>
                    <el-form-item prop="username" label="username">
                        <el-input :validate-event="false" v-model="user.username" />
                    </el-form-item>
                    <el-form-item prop="password" label="password">
                        <el-input :validate-event="false" v-model="user.password" show-password />
                    </el-form-item>
                    <el-row justify="center">
                        <el-form-item>
                            <el-button type="primary" plain>Login</el-button>
                        </el-form-item>
                    </el-row>
                </el-form>
            </el-card>
        </el-col>
    </el-row>
</template>

<script setup>
import { reactive } from "vue";

const user = reactive({});
const rules = reactive({
    username: [
        { required: true, message: 'username is empty', trigger: 'blur' }
    ],
    password: [
        { required: true, message: 'password is empty', trigger: 'blur' }
    ]
});
</script>