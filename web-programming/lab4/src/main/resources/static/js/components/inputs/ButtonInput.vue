<script>
  export default {
    props: ['variable', 'from', 'to', 'r'],
    methods: {
      push: function (number) {
        document.getElementById(this.variable).value = number;
        if (this.r !== undefined) {
          this.r.length = 0;
          this.r.push(number);
        }
      }
    }
  }
</script>

<template>
  <div>
    <div class="label-div">
      <label>Input {{variable}}</label><br/>
    </div>
    <input class="button" type="button" v-for="n in to - from + 1" v-on:click="push(n + from - 1)" v-bind:value="n + from - 1">
    <input type="hidden" v-bind:id="variable" value="NaN"/>
  </div>
</template>

<style scoped>
  .label-div {
    margin-top: 20px;
    margin-bottom: 10px;
  }
  label {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 150%;
    text-decoration: none;
    padding: 5px;
  }
  .button {
    width: 36px;
  }
</style>