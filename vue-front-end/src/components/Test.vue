<template>
    <div id="test">
      <Layout>
        <Content :style="{padding: '24px', background: '#fff'}">
          <Icon type="ios-search" size="20" />&nbsp;&nbsp;<span style="font-size: 20px">查询条件</span>
          <br />
          键：<Input v-model="inputKey" placeholder="" size="default" style="width: 250px;padding: 20px;" />
          值：<Input v-model="inputValue" placeholder="" size="default" style="width: 250px;padding: 20px;" />
          <br />
          <hr />
          <div style="padding: 10px;text-align:right;">
            <Button @click="details" style="float: right;margin: 10px;" size="default" type="info">详情</Button>
            <Button @click="remove" style="float: right;margin: 10px;" size="default" type="error">删除</Button>
          </div>
        </Content>
        <Content :style="{padding: '24px', background: '#fff'}">
          <Table height="500" size="default" border stripe ref="selection" :columns="tableColumns" :data="tableData"></Table>
        </Content>
      </Layout>
    </div>
</template>

<script>
    export default {
        name: "Test",
        data () {
          return {
              //筛选键
              inputKey: '',
              //筛选值
              inputValue: '',
              //列表表头
              tableColumns: [],
              //列表数据
              tableData: []
          }
        },
        mounted() {
          //列表表头
          this.tableColumns = [
              {
                  type: 'selection',
                  width: 60,
                  align: 'center'
              },
              {
                  title: 'ID',
                  key: 'id'
              },
              {
                  title: '键',
                  key: 'key'
              },
              {
                  title: '值',
                  key: 'value'
              },
              {
                  title: '描述',
                  key: 'desc'
              }
          ];

          //加载列表数据
          this.axios.get('http://localhost:8080/vue/test/testPage',{
              params:{
                  pageNum: 0,
                  pageSize: 10,
                  paramJson: ''
              }
          }).then(function(res){
              this.tableData = res.data;
          }.bind(this)).catch(function(err){
              if(err.response) {
                  this.$Message.error(err.response);
              }
          }.bind(this));
        },
        methods:{
            //删除选中列表数据
            remove(event){
                var deleteList = this.$refs.selection.getSelection();
                if(deleteList == undefined || deleteList == null || deleteList.length < 1){
                    this.$Message.warning('未选择删除项！！！');
                }else if(deleteList.length > 1){
                    this.$Message.warning('不允许批量删除！！！');
                }else{
                    this.$Message.info('准备删除ID：' + deleteList.getRangeAt(0));
                }
            },
            //显示单条数据详情
            details(event){
                var detailsList = this.$refs.selection.getSelection();
                if(detailsList == undefined || detailsList == null || detailsList.length < 1){
                    this.$Message.warning('未选择详情！！！');
                }else if(detailsList.length > 1){
                    this.$Message.warning('不允许多选查看详情！！！');
                }else{
                    this.$Message.info('准备查看详情ID：' + detailsList.getRangeAt(0));
                }
            }
        }
    }
</script>

<style scoped>

</style>
