<script>
  export default {
    props: ['point']
  }
</script>

<template>
  <tr>
  <td>{{point.x}}</td>
  <td>{{point.y}}</td>
  <td>{{point.r}}</td>
  <td>{{point.result}}</td>
  <td>{{point.time}}</td>
  </tr>
</template>

<style>

</style>