<script>
  import {store} from "../../store";

  export default {
    computed: {
      store() {
        return store;
      }
    },
    props: ['errors', 'padding']
  }
</script>

<template>
  <p v-show="errors.length">
    <b>Error:</b>
    <ul>
      <li v-for="error in errors">{{ error.concat(errors[errors.length - 1] === error ? "" : ",")}}</li>
    </ul>
  </p>
</template>

<style scoped>
  p {
    padding: 10px;
    border-radius: 10px;
  }
  * {
    color: var(--red);
  }
  b, ul, li {
    padding: 3px;
    display: inline;
    font-size: 114%;
  }
</style>