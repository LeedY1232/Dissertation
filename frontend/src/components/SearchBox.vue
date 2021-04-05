<template>
    <div>
         <el-row class="inputbox">
        <el-input  v-model="input" :placeholder="holder" class="input-with-select">
        <el-select v-model="select" slot="prepend" placeholder="疾病">
            <el-option label="疾病" value='1'></el-option>
            <el-option label="药物" value='2'></el-option>
            <el-option label="症状" value='3'></el-option>
            <el-option label="诊疗" value='4'></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        </el-row>
    </div>

</template>


<script>

export default{
    name:'SearchBox',
    data(){
        return {
            input:'',
            select:'',
            holder:'请输入疾病名称'
        }
    },
   
    methods:{
        changeSearchLabel(){
           
        }
    },
    watch:{
        select:function(){
             if(this.select=== '1'){
            this.holder='请输入疾病名称'
            }else if(this.select==='2'){
              this.holder='请输入药物名称'
            }else if(this.select==='3'){
                this.holder='请输入症状名称'
            }else if(this.select==='4'){
                this.holder='请输入诊疗名称'
            }

        }
    }
}

</script>

<style scoped type="type/css">

.el-select {
    width: 100px;
  }

.inputbox{
    width:500px;
    margin: 28px auto;
}


</style>