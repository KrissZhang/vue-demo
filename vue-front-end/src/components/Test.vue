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
                  key: 'id',
                  sortable: true
              },
              {
                  title: '键',
                  key: 'key',
                  sortable: true
              },
              {
                  title: '值',
                  key: 'value',
                  sortable: true
              },
              {
                  title: '描述',
                  key: 'desc',
                  sortable: true
              }
          ];

          //列表数据
          this.tableData = [
              {
                  id: 1,
                  key: 'key1',
                  value: 'value1',
                  desc: 'key1-value1'
              },{
                  id: 2,
                  key: 'key2',
                  value: 'value2',
                  desc: 'key2-value2'
              }
          ];
        },
        methods:{
            //删除选中列表数据
            remove(e){
                var deleteList = this.$refs.selection.getSelection();
                if(deleteList == undefined || deleteList == null || deleteList.length < 1){
                    this.$Message.warning('未选择删除项！！！');
                }else{
                    //TODO
                    alert(deleteList.length);
                }
            },
            //显示单条数据详情
            details(e){
                var detailsList = this.$refs.selection.getSelection();
                if(detailsList == undefined || detailsList == null || detailsList.length < 1){
                    this.$Message.warning('未选择详情！！！');
                }else{
                    //TODO
                    alert(detailsList.length);
                }
            }
        }
    }
</script>

<style scoped>

</style>
