<template>
  <div id="app" class="layout">
    <Layout>
      <!-- Header -->
      <Header class="header-cls">
        <Menu mode="horizontal" active-name="home">
          <div class="layout-nav">
            <MenuItem name="home" to="/">
              <Icon type="ios-home"></Icon>
              首页
            </MenuItem>
            <MenuItem name="msgbox">
              <Icon type="ios-chatbubbles"></Icon>
              消息
            </MenuItem>
          </div>
        </Menu>
      </Header>
      <!-- 全部内容 -->
      <Layout :style="{padding: '0 50px'}">
        <!-- 导航面包屑 -->
        <Breadcrumb :style="{margin: '16px 0'}">
          <BreadcrumbItem>首页</BreadcrumbItem>
          <BreadcrumbItem>统计</BreadcrumbItem>
          <BreadcrumbItem>收入统计</BreadcrumbItem>
        </Breadcrumb>
        <!-- Content -->
        <Content :style="{padding: '24px 0', minHeight: '280px', background: '#fff'}">
          <Layout>
            <!-- 导航侧边栏 -->
            <Sider hide-trigger :style="{background: '#fff'}">
              <Menu active-name="statistical-income" theme="light" width="auto" :open-names="['statistical']" :accordion="true" @on-open-change="" @on-select="">
                <Submenu name="statistical">
                  <template slot="title">
                    <Icon type="ios-stats"></Icon>
                    统计
                  </template>
                  <MenuItem name="statistical-income" to="/StatInCome">
                    收入统计
                  </MenuItem>
                  <MenuItem name="statistical-spending">
                    支出统计
                  </MenuItem>
                </Submenu>
                <Submenu name="settings">
                  <template slot="title">
                    <Icon type="ios-settings"></Icon>
                    设置
                  </template>
                  <MenuItem name="settings-personal">
                    个人设置
                  </MenuItem>
                  <MenuItem name="settings-system">
                    系统设置
                  </MenuItem>
                </Submenu>
              </Menu>
            </Sider>
            <!-- 主内容区 -->
            <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
              <router-view/>
            </Content>
          </Layout>
        </Content>
      </Layout>
      <!-- Footer -->
      <Footer class="layout-footer-center">2020 &copy; Zp</Footer>
    </Layout>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {

    }
  },
  methods:{

  }
}
</script>

<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  .layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
  }
  .layout-nav{
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
  }
  .layout-footer-center{
    text-align: center;
  }
  .header-cls{
    background-color: white;
  }
</style>
