<script>
  export default {
    props: ['variable']
  }
</script>

<template>
  <div>
    <label>{{variable}}</label><br/>
    <input type="text" v-bind:id="variable"/>
  </div>
</template>

<style>

</style>