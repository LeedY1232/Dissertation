<template>
  <div>
    <title-bar />
    <el-divider></el-divider>

    <div id="input">
      <el-tag>医学知识问答</el-tag>
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

      <el-input
        id="input2nd"
        type="textarea"
        :autosize="{ minRows: 9, maxRows: 14 }"
        placeholder=""
        v-model="text2"
      ></el-input>
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
      text2: "",
    };
  },
  methods: {
    help() {
      this.$alert(
        "请输入您想查询的问题，可以查询的疾病涵盖内科、外科、儿科、妇产科、神经科、消化内科、血液病等多个科室领域，可以查询的内容包括但不限于临床表现、诊断依据、病因、检查方式、预防手段等。",
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