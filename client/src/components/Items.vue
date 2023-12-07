<template>
    <el-space direction="vertical" fill style="width: 100%" :v-infinite-scroll="$emit('load')" infinite-scroll-immediate>
        <el-card v-for="item in items">
            <h3>
                {{ item.title }}
            </h3>
            <el-text line-clamp="2">
                {{ item.content }}
            </el-text>
        </el-card>
    </el-space>
</template>
  
<script setup>
import { reactive } from 'vue';

const items = reactive([
    {
        title: "你玩原神吗",
        content: "你说的对，但是《原神》是由米哈游自主研发的一款全新开放世界冒险游戏。游戏发生在一个被称作「提瓦特」的幻想世界，在这里，被神选中的人将被授予「神之眼」，导引元素之力。你将扮演一位名为「旅行者」的神秘角色，在自由的旅行中邂逅性格各异、能力独特的同伴们，和他们一起击败强敌，找回失散的亲人——同时，逐步发掘「原神」的真相。"
    },
    {
        title: "222",
        content: "222"
    }
]);
</script>