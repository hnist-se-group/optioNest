<template>
    <el-row justify="center">
        <el-col :span="12">
            <el-tabs type="border-card">
                <el-tab-pane label="最近" name="latest">
                    <Items />
                </el-tab-pane>
                <el-tab-pane label="最热" name="second">Config</el-tab-pane>
            </el-tabs>
        </el-col>
    </el-row>
</template>

<script setup>
import Items from '../component/Items.vue';
</script>