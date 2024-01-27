<template>
  <tr>
    <td v-for="value in point">{{ value }}</td>
  </tr>
</template>

<script type="module">
  export default {
    props: ['point']
  }
</script>

<style>

</style>