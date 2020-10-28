import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import 'material-design-icons-iconfont/dist/material-design-icons.css';
import store from './router/store'
import axios from 'axios'


Vue.use( axios);

Vue.config.productionTip = false

new Vue({
  router,
  axios,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
