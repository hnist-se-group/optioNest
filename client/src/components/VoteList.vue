<template>
    <el-space direction="vertical" fill style="width: 100%">
        <el-card v-for="vote in votes" :key="vote.id" @click="to_detail(vote.id)">
            <h3>
                {{ vote.title }}
            </h3>
            <el-text line-clamp="2">
                {{ vote.content }}
            </el-text>
        </el-card>
    </el-space>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from '@/utils/axios';

const router = useRouter();
const props = defineProps(['url']);

let votes = ref([]);
axios(props.url).then(response => votes.value = response.data);

function to_detail(id) {
    router.push({
        name: 'vote',
        params: { id }
    })
}

</script>