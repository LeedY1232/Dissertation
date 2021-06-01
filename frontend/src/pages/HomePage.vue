<template>
  <div>
    <title-bar />
    <el-divider></el-divider>
    <search-box @sendWq = 'getWq'></search-box>

    <div id="painting">
      <canvas>
      </canvas>
    </div>
  </div>
</template>


<script>
import TitleBar from "../components/TitleBar.vue";
import SearchBox from "../components/SearchBox.vue";
import * as echarts from "echarts";
import $ from "jQuery";
import axios from 'axios'

export default {
  inject:['reload'],
  name: "HomePage",
  data(){
    return {
      list:[]
    }
  },
  components: {
    TitleBar,
    SearchBox,
  },

  mounted() {
    this.createpainter();
  },

  methods: {
    getWq(wq){
      this.list = wq
     
    },
    createpainter() {
      $(document).ready(function () {                                           //等待dom元素加载完成后，再初始化mychart
        var chartDom = document.getElementById("painting");
        var myChart = echarts.init(chartDom);
        var option;
        //myChart.showLoading();
        axios({
          url:"http://localhost:8083/hello.json",
          method:'GET',
          headers:{'Content-Type' : 'application/json'},
        }).then(function (res) {
            //myChart.hideLoading();
          var graph = res.data
         console.log(res.data.links)



            graph.nodes.forEach(function (node) {   //完成结点大小展示
              node.label = {
                show: node.symbolSize = 20,
              };
            });
          
            option = {
              title: {
                text: "部分图谱",
                subtext: "Circular layout",
                top: "bottom",
                left: "right",
              },
              tooltip: {},
              /*legend: [
                {
                  data: graph.categories.map(function (a) {
                    return a.name;
                  }),
                },
              ],*/
              animationDurationUpdate: 1500,
              animationEasingUpdate: "quinticInOut",
              series: [
                {
                  name: "部分图谱",   //底部名字
                  type: "graph",
                  layout: "circular",
                  circular: {
                    rotateLabel: true,
                  },
                  data: graph.nodes,
                  links: graph.links,
                  //categories: graph.categories,
                  roam: false,    //暂时禁用鼠标对图谱的影响，仅生效点击事件完成链接上的转换
                  label: {
                    position: "right",
                    formatter: "{b}",
                  },
                  lineStyle: {
                    color: "source",
                    curveness: 0.36,
                  },
                },
              ],
            };

            myChart.setOption(option);
          }
        );
      });
      
    },
  },
};
</script>

<style scoped type="type/css">
#painting {
  margin: 0 auto;
  padding: 50px;
  width: 800px;
  height: 800px;
}
</style>

