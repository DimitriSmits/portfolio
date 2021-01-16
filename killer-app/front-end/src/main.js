import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import vuetify from './plugins/vuetify';
import 'material-design-icons-iconfont/dist/material-design-icons.css';
import store from './store/store'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.config.productionTip = false
Vue.use(VueAxios, axios);



new Vue({
  el:'#app',
  router,
  axios,
  VueAxios,
  store,
  vuetify,

  render: h => h(App)
}).$mount('#app')
