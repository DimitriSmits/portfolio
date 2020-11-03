import Vue from 'vue'
import Vuex from 'vuex'
import axios from '../services/axios-auth'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
      tokenId: null,
      userId: null,
      user: null
  },
  mutations: {
      authUser (state, userData) {
          state.idToken = userData.token
          state.userId = userData.userId
      },
     },
  actions: {
      login ({commit}, authData) {
          axios.post('/verifyPassword?key=AIzaSyAPQIJy-yu1UJTFOEGjesyXme-_OzkZnaM',{
              email: authData.email,
              password: authData.password,
              returnSecureToken: true      })
              .then(res => {   
                   console.log(res)
          })
           .catch(error => console.log(error))
      },
  }
})