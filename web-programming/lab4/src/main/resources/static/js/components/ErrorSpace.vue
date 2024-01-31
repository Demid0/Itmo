<script>
  export default {
    props: ['errors']
  }
</script>

<template>
  <p v-if="errors.length">
    <b>Пожалуйста исправьте указанные ошибки:</b>
    <ul>
      <li v-for="error in errors">{{ error }}</li>
    </ul>
  </p>
</template>

<style>

</style>