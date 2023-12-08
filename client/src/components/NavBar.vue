<template>
    <el-menu router default-active="/" mode="horizontal" style="margin: 0 10% 10px 10%;">
        <h3>optioNest</h3>
        <el-menu-item index="/">首页</el-menu-item>


        <div style="margin-left: auto;"></div>
        <el-menu-item index="/add">创建投票</el-menu-item>
        <el-menu-item index="/user">
            <el-avatar>
                <img src="@/assets/kyaru.jpg">
            </el-avatar>
        </el-menu-item>
    </el-menu>
</template>

<script setup>
</script>