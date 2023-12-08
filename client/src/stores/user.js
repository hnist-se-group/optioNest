import { defineStore } from 'pinia'

export const useStore = defineStore('user', {
  state() {
    return {
      login: true,
      uid: 0,
    }
  }
})
