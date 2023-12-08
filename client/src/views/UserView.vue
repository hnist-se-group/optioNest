<template>
  <el-descriptions title="个人信息">
    <el-descriptions-item label="Username:">{{ userInfo.name }}</el-descriptions-item>
    <el-descriptions-item label="Email:">{{ userInfo.email }}</el-descriptions-item>
    <el-descriptions-item label="Place:">{{ userInfo.location }}</el-descriptions-item>
    <el-descriptions-item label="Gender:">
      <el-tag size="small">{{ userInfo.gender }}</el-tag>
    </el-descriptions-item>
    <el-descriptions-item label="个人简介:">{{ userInfo.brief }}</el-descriptions-item>
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

const router = useRouter();
const store = useStore();

const userInfo = ref({});
let votes = ref([]);
axios('/loadUser/' + store.uid).then(response => {
  userInfo.value = response.data;
  votes.value = userInfo.value.votes;
});

function to_detail(id) {
  router.push({
    name: 'vote',
    params: { id }
  })
}
</script>
