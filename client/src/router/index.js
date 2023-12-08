import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue';
import UserView from '@/views/UserView.vue';
import VoteView from '@/views/VoteView.vue';
import AddView from '@/views/AddView.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView
        },
        {
            path: '/user',
            name: 'user',
            component: UserView
        },
        {
            path: '/vote/:id',
            name: 'vote',
            component: VoteView
        },
        {
            path: '/add',
            name: 'add',
            component: AddView
        }
    ]
})

export default router
