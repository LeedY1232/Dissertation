<template>
  <div>
    <title-bar />
    <el-divider></el-divider>
    <el-container id="total">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i>疾病</template>
            <el-tree
              :data="letters"
              :props="defaultProps"
              @node-click="handleNodeClick"
            >
            </el-tree>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>药物</template>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title"><i class="el-icon-menu"></i>症状</template>
          </el-submenu>

          <el-submenu index="4">
            <template slot="title"><i class="el-icon-menu"></i>诊疗</template>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <search-box id="box" @sendWq="getWq" :input="select"> </search-box>
        </el-header>
        <el-main>
          <div id="forcegraph">
            <canvas></canvas>
          </div>
        </el-main>
      </el-container>
    </el-container>
    <el-footer>
      <p style="text-align: center; margin: 50px">@Copyrights</p>
    </el-footer>
  </div>
</template>



<script>
import TitleBar from "../components/TitleBar.vue";
import SearchBox from "../components/SearchBox.vue";
import * as echarts from "echarts";
import $ from "jQuery";
import axios from "axios";

export default {
  name: "Mekg",
  components: {
    TitleBar,
    SearchBox,
  },
  data() {
    return {
      list: [],
      select:"",
      myChart: "",
      letters: [
        { label: "A", children: [] },
        { label: "B", children: [] },
        { label: "C", children: [] },
        { label: "D", children: [] },
        { label: "E", children: [] },
        { label: "F", children: [] },
        { label: "G", children: [] },
        { label: "H", children: [] },
        { label: "I", children: [] },
        { label: "J", children: [] },
        { label: "K", children: [] },
        { label: "L", children: [] },
        { label: "M", children: [] },
        { label: "N", children: [] },
        { label: "O", children: [] },
        { label: "P", children: [] },
        { label: "Q", children: [] },
        { label: "R", children: [] },
        { label: "S", children: [] },
        { label: "T", children: [] },
        { label: "U", children: [] },
        { label: "V", children: [] },
        { label: "W", children: [] },
        { label: "X", children: [] },
        { label: "Y", children: [] },
        { label: "Z", children: [] },
        { label: "#", children: [] }
      ],
      defaultProps: {
        label: "label",
        children: "children",
      },
    };
  },
  props: {},
  mounted() {
    this.createForceGraph();
    this.getMenuList();
  },
  methods: {
    handleNodeClick(data) {
      console.log(data.label);
      
      if(data.children==undefined){
        this.select = data.label;
      var a=[data.label,1]
      this.getWq(a);
      }
    },
    getWq(wq) {
      this.list = wq;
      console.log(this.list);
      this.myChart.dispose();
      this.createForceGraph();
    },
    createForceGraph() {
      let that = this;
      var term;
      if (that.list[0] == undefined) {
        term = {
          wq: "败血症",
          type: 1,
        };
      } else {
        term = {
          wq: that.list[0],
          type: String(that.list[1]),
        };
      }
      console.log(term);
      $(document).ready(function () {
        var chartDom = document.getElementById("forcegraph");
        that.myChart = echarts.init(chartDom);
        var option;
        //that.myChart.showLoading();
        axios({
          url: "http://localhost:9090/index/search",
          method: "POST",
          headers: { "Content-Type": "application/json" },
          data: JSON.stringify(term),
        }).then(function (res) {
          //that.myChart.hideLoading();
          var graph = res.data;
          if (res.data.nodes[0] != undefined) {
            that.$message.success("查询成功！");
          } else {
            that.$message.warning("暂无数据！");
          }

          for(var x = 0;x<graph.nodes.length;x++){
            for(var y = 0;y<graph.nodes.length;y++){
              if(graph.nodes[x].id == graph.nodes[y].id&&x!=y){
                graph.nodes.splice(y,1);
              }
            }
          }


          console.log(graph.nodes);

          console.log(graph.links);
          graph.nodes.forEach(function (node) {
            //完成结点大小展示
            node.label = {
              show: (node.symbolSize = 20),
            };
          });
          option = {
            title: {
              text: term["wq"] + "部分图谱",
              //subtext: "Default layout",
              top: "top",
              left: "left",
            },
            tooltip: {},
            /*legend: [
                {
                  // selectedMode: 'single',
                  data: graph.categories.map(function (a) {
                    return a.name;
                  }),
                },
              ],*/
            series: [
              {
                name: "部分图谱",
                type: "graph",
                layout: "force",
                data: graph.nodes,
                links: graph.links,
                //categories: graph.categories,
                roam: false,
                label: {
                  position: "right",
                },
                force: {
                  repulsion: 500,
                },
              },
            ],
          };
          that.myChart.setOption(option);
        });
      });
    },

    getMenuList() {
      let that = this;
      axios({
        url: "http://localhost:9090/list",
        method: "POST",
        dataType: "json", 
        headers: { "Content-Type": "application/json" },
      }).then(function (res) {
        console.log(res.data['A']);
        for(let i = 0;i<27;i++){
          that.letters[i].children = res.data[that.letters[i].label]
        }
        

      });
    },
  },
};
</script>


<style scoped type="type/css">
#total {
  height: 1000px;
  width: 1200px;
  border: 1px solid #eee;
  margin: auto;
  padding: auto;
}

#box {
  position: relative;
  padding: auto;
}

#forcegraph {
  margin: 0 auto;
  padding: 50px;
  width: 800px;
  height: 800px;
}
</style>