<template>
    <el-tabs model-value="latest" stretch type="card">
        <el-tab-pane label="最近" name="latest">
            <VoteList url="/getVotes" />
        </el-tab-pane>
        <el-tab-pane label="最热" name="second">Config</el-tab-pane>
    </el-tabs>
</template>

<script setup>
import VoteList from '../components/VoteList.vue';
</script>