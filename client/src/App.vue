<template>
    <el-container>
        <el-header>
            <NavBar />
        </el-header>
        <el-main>
            <el-row justify="center">
                <el-col :span="16">
                    <el-card>
                        <router-view></router-view>
                    </el-card>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script setup>
import NavBar from './components/NavBar.vue';
</script>