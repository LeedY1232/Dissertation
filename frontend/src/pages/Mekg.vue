<template>
    <div>
    <title-bar/>
    <el-divider></el-divider>
    <el-container id ='total' >
        <el-aside width="200px" style="background-color: rgb(238,241,246)">
            <el-menu>
                <el-submenu index = "1">
                    <template slot="title"><i class='el-icon-menu'></i>疾病</template>
                        <el-submenu index ="1-1">
                            <template slot='title'>百种常见病</template>
                        </el-submenu>
                        <el-submenu index ="1-2">
                            <template slot='title'>儿科常见病</template>
                        </el-submenu>
                        <el-submenu index ="1-3">
                            <template slot='title'>其他常见病</template>
                        </el-submenu>
                        <el-submenu index ="1-4">
                            <template slot='title'>其他病</template>
                        </el-submenu>
                </el-submenu>

                <el-submenu index = "2">
                    <template slot="title"><i class='el-icon-menu'></i>药物</template>
                        <el-submenu index ="2-1">
                            <template slot='title'>中成药</template>
                        </el-submenu>
                        <el-submenu index ="2-2">
                            <template slot='title'>中草药</template>
                        </el-submenu>
                        <el-submenu index ="2-3">
                            <template slot='title'>西药</template>
                        </el-submenu>
                </el-submenu>

                <el-submenu index = "3">
                    <template slot="title"><i class='el-icon-menu'></i>症状</template>
                    <el-select>
                        <el-option  v-for='letter in alph' :key='letter.label' :value='letter.value'>
                           
                        </el-option>
                    </el-select>
                </el-submenu>

                <el-submenu index = "4">
                    <template slot="title"><i class='el-icon-menu'></i>诊疗</template>
                        <el-submenu index ="4-1">
                            <template slot='title'>检查诊疗技术</template>
                        </el-submenu>
                
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-container>
            <el-header>
            <search-box id = 'box'>
            </search-box>
            </el-header>
            <el-main>
                <p>hello,Mekg!</p>
                <canvas></canvas>

            </el-main>
            
            
        </el-container>




    </el-container>                 
    <el-footer>


        <p style="text-align:center; margin:50px">@Copyrights</p>
    </el-footer>

    </div>
</template>



<script>
import TitleBar from '../components/TitleBar.vue'
import SearchBox from '../components/SearchBox.vue'


export default{
    name:'Mekg',
    components:{
        TitleBar,SearchBox
    },
    data(){
        return{
            letter:[{label:'选项一',value:'A'},{label:'选项二',value:'B'}]
        }
    }
    
}


</script>


<style scoped type="type/css">
#total{
    height: 500px; 
    width :1200px;
    border: 1px solid #eee;
    margin:auto;
    padding:auto;
}


#box{
    position:relative;
    padding:auto;
}

</style>