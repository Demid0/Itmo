<script>
  export default {
    props: ['variable', 'from', 'to', 'r'],
    methods: {
      push: function (number) {
        document.getElementById(this.variable).value = number
        if (this.r !== undefined) {
          this.r.length = 0
          this.r.push(number)
        }
      }
    }
  }
</script>

<template>
  <div>
  <label>{{variable}}</label><br/>
  <input type="button" v-for="n in to - from + 1" v-on:click="push(n + from - 1)" v-bind:value="n + from - 1">
  <input type="hidden" v-bind:id="variable"/>
  </div>
</template>

<style>

</style>