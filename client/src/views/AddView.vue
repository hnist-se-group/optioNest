<template>
    <el-row justify="center">
        <h1>创建投票</h1>
    </el-row>
    <el-row justify="center">
        <el-col :span="14">

            <el-form ref="formRef" :model="vote" :rules="rules" label-width="50px" hide-required-asterisk>
                <el-form-item label="标题" prop="title">
                    <el-input v-model="vote.title" :validate-event="false" />
                </el-form-item>
                <el-form-item label="描述" prop="content">
                    <el-input v-model="vote.content" type="textarea" :validate-event="false"
                              :autosize="{ minRows: 2, maxRows: 4 }" />
                </el-form-item>
                <el-form-item label="时间" prop="time">
                    <el-date-picker v-model="vote.time" type="datetimerange" :validate-event="false"
                                    start-placeholder="起始时间" end-placeholder="结束时间" format="YYYY-MM-DD HH:mm:ss"
                                    date-format="YYYY/MM/DD ddd" time-format="A hh:mm:ss" />
                </el-form-item>
                <el-form-item v-for="(option, idx) in vote.options" :key="idx" :label="'选项' + idx" :prop="['options', idx, 'name']"
                              :rules="{
                                  required: true,
                                  message: '请输入选项',
                              }">
                    <el-input v-model="option.name" :validate-event="false">
                        <template v-if="idx > 1" #append>
                            <el-button @click="delOption(idx)">删除选项</el-button>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-button @click="addVote" type="primary" plain>创建投票</el-button>
                    <el-button @click="addOption">添加选项</el-button>
                </el-form-item>
            </el-form>

        </el-col>
    </el-row>
</template>

<script setup>
import { reactive, ref } from 'vue';
import axios from '../utils/axios';
import { useStore } from '../stores/user';

const stroe = useStore();
const formRef = ref();

const rules = reactive({
    title: [{ required: true, message: '请输入标题' }],
    content: [{ required: true, message: '请输入描述' }],
    time: [{ required: true, message: '请选择时间' }],
});

const vote = reactive({
    options: [{}, {}]
});

function addOption() {
    vote.options.push({});
}

function delOption(idx) {
    vote.options.splice(idx, 1);
}

function addVote() {
    formRef.value.validate((valid) => {
        if (valid) {
            axios.post('/addVote', {
                uid: stroe.uid,
                title: vote.title,
                content: vote.content,
                stime: vote.time[0],
                etime: vote.time[1],
                options: vote.options
            }, {
                headers: { 'Content-Type': 'application/json' }
            }).then(() => {
                formRef.value.resetFields();
            })
        }
    });
}
</script>