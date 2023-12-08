<template>
    <el-row justify="center" style="margin-top: 25%; translate: 0 -50%;">
        <el-col :span="6">
            <el-card>
                <Login v-if="isLogin" @change-state="changeState" />
                <Register v-else @change-state="changeState" />
            </el-card>
        </el-col>
    </el-row>
</template>

<script setup>
import { ref } from "vue";
import Login from "@/components/Login.vue";
import Register from '@/components/Register.vue';
const isLogin = ref(true);

function changeState() {
    isLogin.value = !isLogin.value;
}
</script>