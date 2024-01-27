<template>
  <div>
  <button v-for="n in 9" @click="bang(n - 5 )">{{ n - 5 }}</button>
  </div>
</template>

<script type="module">
  export default {
    props: ['name'],
    methods: {
      bang: function(value) {
        document.getElementById(this.name).value = value
      }
    }
  }
</script>

<style>

</style>
