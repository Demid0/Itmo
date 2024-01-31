<script>
  export default {
    props: ['variable']
  }
</script>

<template>
  <div>
    <label>{{variable}}</label><br/>
    <input type="text" v-bind:id="variable" maxlength="7"/>
  </div>
</template>

<style>

</style>