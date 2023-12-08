<template>
    <el-page-header @back="goBack">
    </el-page-header>
    <el-space direction="vertical" fill size="large" style="width: 100%; margin-bottom: 10px;">
        <el-row justify="center">
            <h1>{{ vote.title }}</h1>
        </el-row>
        <el-row justify="center">
            <el-col :span="2">
                <el-statistic class="center" title="浏览量" :value="vote.pv" />
            </el-col>
            <el-col :span="2">
                <el-statistic class="center" title="投票数" :value="vote.num" />
            </el-col>
        </el-row>
        <el-row justify="center">
            <el-col :span="6">
                <el-text tag="b">开始时间：</el-text>
                <el-tag>{{ vote.stime }}</el-tag>
            </el-col>
            <el-col :span="6">
                <el-text tag="b">结束时间：</el-text>
                <el-tag>{{ vote.etime }}</el-tag>
            </el-col>
        </el-row>
        <el-row justify="center">
            <el-collapse>
                <el-collapse-item title="投票描述">
                    <el-text>
                        {{ vote.content }}
                    </el-text>
                </el-collapse-item>
            </el-collapse>
        </el-row>
    </el-space>

    <el-space direction="vertical" fill size="large" style="width: 100%;">
        <el-card v-for="option in vote.options">
            <el-row>
                <el-col :span="14" class="col-center">
                    <el-text>
                        {{ option.name }}
                    </el-text>
                </el-col>
                <el-col :span="6" class="col-center">
                    <el-progress text-inside striped show-text :stroke-width="20"
                                 :percentage="Math.round(option.num / vote.num * 100)" />
                </el-col>
                <el-col :span="2" class="col-center">
                    <el-text>{{ option.num + '/' + vote.num }}</el-text>
                </el-col>
                <el-col :span="1">
                    <el-button v-if="vote.state == -1" type="primary" size="large" plain
                               @click="submit_vote(option)">投票</el-button>
                    <el-button v-else type="primary" size="large" :plain="vote.state != option.oid" disabled>
                        {{ vote.state != option.oid ? '投票' : '已选择' }}
                    </el-button>
                </el-col>
            </el-row>
        </el-card>
    </el-space>
</template>

<script setup>
import { ref } from 'vue';
import axios from "@/utils/axios.js";
import { useRoute, useRouter } from 'vue-router';
import { useStore } from '../stores/user';

const route = useRoute();
const router = useRouter();
const store = useStore();

const vote = ref({});

function submit_vote(option) {
    axios('/voting', {
        params: {
            uid: store.uid,
            id: vote.value.id,
            oid: option.oid
        }
    });
    vote.value.num++;
    option.num++;
    vote.value.state = option.oid;
}

function goBack() {
    router.back();
}

axios('/getDetailInfo', { params: { uid: store.uid, id: Number(route.params.id) } }).then(response => {
    vote.value = response.data;
});

</script>

<style scoped>
.center {
    text-align: center;
}

.col-center {
    margin: auto 0;
}
</style>