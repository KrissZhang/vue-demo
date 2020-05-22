// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ViewUI from 'view-design'
import axios from 'axios'
import qs from 'qs'
import 'view-design/dist/styles/iview.css'

Vue.config.productionTip = false
Vue.prototype.axios = axios
Vue.prototype.qs = qs
Vue.use(ViewUI, {
  transfer: true,
  size: 'large',
  capture: false,
  select: {
    arrow: 'md-arrow-dropdown',
    arrowSize: 20
  }
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
