<script>
  export default {
    props: ['variable', 'length', 'secret']
  }
</script>

<template>
  <div v-if="secret">
    <div class="label-div">
      <label>{{ variable.replaceAll("_", " ") }}</label><br/>
    </div>
    <input type="password" v-bind:id="variable" :maxlength="length"/>
  </div>
  <div v-else>
    <div class="label-div">
      <label>{{ variable.replaceAll("_", " ") }}</label><br/>
    </div>
    <input type="text" v-bind:id="variable" :maxlength="length"/>
  </div>
</template>

<style scoped>
  .label-div {
    margin-top: 20px;
  }
  label {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 150%;
    text-decoration: none;
    padding: 5px;
  }
  input {
    border-radius: 10px;
    border: 2px var(--primary) dotted;
    color: var(--primary);
    font-size: 150%;
    padding: 5px;
    margin-top: 15px;
  }

</style>