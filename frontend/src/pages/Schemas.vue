<template>
  <div>
    <title-bar />
    <el-divider></el-divider>

    <div id="input">
      <el-tag>描述框架</el-tag>
      <el-input
        id="input1st"
        type="textarea"
        :autosize="{ minRows: 4, maxRows: 8 }"
        placeholder="请输入内容"
        v-model="text1"
      ></el-input>
      <el-row id="buttonrow">
        <el-button type="primary" id="help" size="small" round @click="help"
          >帮助</el-button
        >
        <el-button type="primary" id="submit" size="small" round
          >提交</el-button
        >
      </el-row>

      <canvas> </canvas>
    </div>
  </div>
</template>



<script>
import TitleBar from "../components/TitleBar.vue";

export default {
  name: "MedicalSeg",
  components: {
    TitleBar,
  },
  data() {
    return {
      text1: "",
    };
  },
  methods: {
    help() {
      this.$alert(
        "输入疾病、药物、症状、诊疗技术及设备（治疗）等相关医学实体名称，展示其schema描述体系。",
        "帮助",
        {
          confrimButtonText: "确定",
        }
      );
    },
  },
};
</script>


<style scoped type='type/css'>
#input {
  width: 800px;
  margin: 80px auto 10px;
  padding: 10px auto;
  position: relative;
}

#buttonrow {
  text-align: right;
  margin: 20px auto 5px;
  padding: 5px auto;
}

#input2nd {
  margin: 0 auto;
}
</style>