import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)

export default new Vuex.Store({
  state: {
      userid: null,
      coachid:null,
      user: null,
      session: [],
  },
  getters:{
    session(state){
      return state.session
    },
  },
  mutations: {
      updateUserid (state, message) {
        state.userid = message
      },
      setSession(state,session){
        state.session = session;
      },
      logoutUser(state){
       state.userid = null
      },
      updateCoachid(state, message){
      state.coachid = message
      },
      logoutCoach(state){
        state.coachid = null
      }
     },
     
  actions: {
      
  },
})