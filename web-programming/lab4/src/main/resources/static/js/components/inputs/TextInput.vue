<script>
  export default {
    props: ['variable', 'length']
  }
</script>

<template>
  <div>
    <label>{{ variable.replaceAll("_", " ") }}</label><br/>
    <input type="text" v-bind:id="variable" :maxlength="length"/>
  </div>
</template>

<style>

</style>