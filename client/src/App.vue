<template>
    <el-container v-if="!store.login">
        <el-main>
            <LoginView />
        </el-main>
    </el-container>

    <el-container v-else>
        <el-header>
            <NavBar />
        </el-header>
        <el-main>

            <el-row justify="center">
                <el-col :span="16">
                    <el-card>
                        <Suspense>
                        <router-view v-slot="{ Component }">
                            <keep-alive include="HomeView">
                                    <component :is="Component" />
                                </keep-alive>
                            </router-view>
                        </Suspense>
                    </el-card>
                </el-col>
            </el-row>
            
        </el-main>
    </el-container>
</template>

<script setup>
import LoginView from '@/views/LoginView.vue';
import NavBar from '@/components/NavBar.vue';
import { useStore } from '@/stores/user';

const store = useStore();
</script>