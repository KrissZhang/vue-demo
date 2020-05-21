import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import StatInCome from '@/components/StatInCome'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/StatInCome',
      name: 'StatInCome',
      component: StatInCome
    }
  ]
})
