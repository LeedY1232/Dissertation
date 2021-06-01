<template>
  <div id="app">
    <router-view v-show="msg" />
  </div>
</template>

<script>


export default {
  name: 'App',
  provide(){
    return{
      reload: this.reload
    }
  },
  data(){
    return{
      msg: true
    }
  },
  methods:{
    reload(){
      this.msg = false;
      this.$nextTick(function(){
        this.msg = true
      }

      )
    }
  }
}
</script>

<style>

</style>
