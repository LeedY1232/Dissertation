import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import * as echarts from 'echarts'
import axios from 'axios'
import VueAxios from 'vue-axios'

import { Message } from 'element-ui'
// 挂载到$message上
Vue.prototype.$message = Message

Vue.config.productionTip = false
Vue.use(ElementUI)

Vue.use(VueAxios, axios)
Vue.config.productionTip = false


axios.defaults.headers.get['Content-Type'] = 'application/json';

new Vue({
  el: "#app",
  router,
  echarts,
  render: h => h(App),
}).$mount('#app')
