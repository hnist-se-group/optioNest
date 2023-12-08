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
        <el-row justify="center">
            <el-pagination :page-count="pageCount" v-model:current-page="curPage" layout="prev, pager, next" background />
        </el-row>
    </el-space>
</template>

<script setup>
import { ref, watch } from 'vue';
import { useRouter } from 'vue-router';
import axios from '@/utils/axios';

const router = useRouter();
const props = defineProps(['url']);

const votes = ref([]);
const pageCount = ref(0);
const curPage = ref(1);

function to_detail(id) {
    router.push({
        name: 'vote',
        params: { id }
    })
}

watch(curPage, (newValue) => {
    axios(props.url + '/' + newValue).then(response => votes.value = response.data);
}, { immediate: true });

await axios('/allPages').then(response => pageCount.value = response.data.allPages);

</script>