<template>
  <el-descriptions title="个人信息" border>
    <template #extra>
      <el-button v-if="isModify" @click="ModifyInfo" type="warning">提交修改</el-button>
      <el-button type="primary" @click="changeModify">修改个人信息</el-button>
    </template>
    <el-descriptions-item label="Username:">
      <InfoInput :is-modify="isModify" v-model="infoTmp.name" />
    </el-descriptions-item>
    <el-descriptions-item label="Email:">
      <InfoInput :is-modify="isModify" v-model="infoTmp.email" />
    </el-descriptions-item>
    <el-descriptions-item label="Place:">
      <InfoInput :is-modify="isModify" v-model="infoTmp.location" />
    </el-descriptions-item>
    <el-descriptions-item label="Gender:">
      <InfoInput :is-modify="isModify" v-model="infoTmp.gender" />
    </el-descriptions-item>
    <el-descriptions-item label="个人简介:">
      <InfoInput :is-modify="isModify" v-model="infoTmp.brief" />
    </el-descriptions-item>
  </el-descriptions>

  <el-tabs stretch type="card">
    <el-descriptions title="我创建的投票"> </el-descriptions>
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
  </el-tabs>
</template>

<script setup>
import { ref } from 'vue';
import axios from "@/utils/axios.js";
import { useRouter } from 'vue-router';
import { useStore } from '../stores/user';
import InfoInput from '../components/InfoInput.vue';

const router = useRouter();
const store = useStore();

const isModify = ref(false);
const info = ref({}), infoTmp = ref({});
const votes = ref([]);

function to_detail(id) {
  router.push({
    name: 'vote',
    params: { id }
  })
}

function changeModify() {
  isModify.value = !isModify.value;
  infoTmp.value = { ...info.value };
}

function ModifyInfo() {
  axios.post('/updateUser', {
    uid: store.uid,
    ...infoTmp.value
  }, {
    headers: { 'Content-Type': 'application/json' }
  }).then(response => {
    info.value = infoTmp.value;
    changeModify();
  });
}

axios('/loadUser/' + store.uid).then(response => {
  votes.value = response.data.votes;

  delete response.data.votes;
  info.value = response.data;
  infoTmp.value = { ...info.value };
});
</script>
