<template>
    <el-header >
    
    <label>中文医学知识图谱</label>
    <el-row :gutter="20" class="buttonfloat" >
            
            
            <el-button size="small" type="primary" @click='index' plain>
                首页
            </el-button>
            &nbsp;&nbsp;
            <el-dropdown>
                <el-button size="small" type="primary"  plain>
                    知识图谱
                </el-button>
                <el-dropdown-menu>
                    <el-dropdown-item @click.native ='goForMekg'>知识图谱</el-dropdown-item>
                    <el-dropdown-item>多视图</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            
            &nbsp;
            <el-dropdown>
                <el-button size="small" type="primary" plain>
                    构建工具
                </el-button>
                <el-dropdown-menu>
                <el-dropdown-item @click.native='goForMedicalSeg'>医学分词</el-dropdown-item>
                <el-dropdown-item @click.native='goForMedicalNer'>实体识别</el-dropdown-item>
                <el-dropdown-item @click.native='goForRelation'>关系抽取</el-dropdown-item>
                <el-dropdown-item @click.native='goForSchemas'>描述框架</el-dropdown-item>
                <el-dropdown-item>标注平台</el-dropdown-item>
                <el-dropdown-item>标注规范</el-dropdown-item>
            </el-dropdown-menu>
            </el-dropdown>
            &nbsp;
            <el-dropdown>
                <el-button size="small" type="primary"  plain>
                    示范应用
                </el-button>
                <el-dropdown-menu>
                    <el-dropdown-item @click.native='goForMekQa'>医学知识问答</el-dropdown-item>
                    <el-dropdown-item>妇儿健康宣教</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            &nbsp;
            <el-dropdown>
            <el-button size="small" type="primary"  plain>
                使用说明
            </el-button>
            </el-dropdown>
            &nbsp;
            <el-dropdown>
            <el-button size="small" type="primary"  plain>
                关于我们
            </el-button>
            </el-dropdown>
        </el-row>

    </el-header>
    
</template>


<script>
export default {
  name: 'TitleBar',
  props: {
  },
  created(){

  },
  methods:{
    index(){
        this.$router.push({
            name:'Index'
        })
    },
    
    goForMekg(){
        this.$router.push({
            name:'Mekg'
        })
    },

    goForMedicalNer(){
        this.$router.push({
            name:'MedicalNer'
        })
    },

    goForMedicalSeg(){
        this.$router.push({
            name:'MedicalSeg'
        })
    },
    goForMekQa(){
        this.$router.push({
            name:'MekQa'
        })
    },
    goForRelation(){
        this.$router.push({
            name:'Relation'
        })
    },
    goForSchemas(){
        this.$router.push({
            name:'Schemas'
        })
    },
  }


}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>



.el-header{
    width:950px;
    margin:0 auto;
    padding:24px auto;
    position:flex;
}

.el-label{
    margin:20px auto;
    padding:10px auto;
}

.buttonfloat{
    position:relative;
    text-align:right;
}
</style>
