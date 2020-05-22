import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import MsgBox from '@/components/MsgBox'
import SettingPersonal from '@/components/SettingPersonal'
import SettingSystem from '@/components/SettingSystem'
import Test from '@/components/Test'
import StatInCome from '@/components/StatInCome'
import StatSpending from '@/components/StatSpending'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/msgbox',
      name: 'MsgBox',
      component: MsgBox
    },
    {
      path: '/settingpersonal',
      name: 'SettingPersonal',
      component: SettingPersonal
    },
    {
      path: '/settingsystem',
      name: 'SettingSystem',
      component: SettingSystem
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/statincome',
      name: 'StatInCome',
      component: StatInCome
    },
    {
      path: '/statspending',
      name: 'StatSpending',
      component: StatSpending
    }
  ]
})
