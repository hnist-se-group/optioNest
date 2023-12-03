<template>
    <el-space fill :size="0" :v-infinite-scroll="$emit('load')" infinite-scroll-immediate>
        <el-card v-for="item in items">
            <template #header>
                {{ item.title }}
            </template>
            {{ item.description }}

        </el-card>
    </el-space>
</template>
  
<script setup>
import { reactive } from 'vue';

const items = reactive([
    {
        title: "111",
        description: "111"
    },
    {
        title: "222",
        description: "222"
    }
]);
</script>