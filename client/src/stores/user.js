import { defineStore } from 'pinia'

export const useStore = defineStore('user', {
  state() {
    return {
      login: false,
      uid: 0,
      headImg: ''
    }
  }
})
