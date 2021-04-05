<template>
  <div>
    <el-collapse-transition>
      <HomePage />
    </el-collapse-transition>
  </div>
</template>

<script>
import HomePage from '@/pages/HomePage.vue'
export default {
  name: 'Index',
  components: {
    HomePage
  }
}
</script>

<style scoped type="type/css">



</style>