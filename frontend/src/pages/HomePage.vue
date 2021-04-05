<template>
    <div>
        <title-bar/> 
             <el-divider></el-divider>
        <search-box></search-box>

        <div id='canvas1st'>
            <canvas></canvas>
        </div>

    </div>
    
</template>

<script>
import TitleBar from '../components/TitleBar.vue'
import SearchBox from '../components/SearchBox.vue'

export default{
    name:'HomePage',
    components:{
        TitleBar,
        SearchBox
    },
    
}
</script>

<style scoped type="type/css">


</style>

