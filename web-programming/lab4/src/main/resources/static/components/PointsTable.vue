<template>
  <table>
    <tr><td>№</td><td>X</td><td>Y</td><td>R</td><td>Result</td><td>Time</td></tr>
    <point-row v-for="point in points" :key="point.id" :point="point"/></table>
</template>

<script type="module">
 import Vue from "vue";
 import PointRow from "./PointRow.vue";

 export default {
    components: {
      PointRow
    },
    props: ['points'],
    created() {
      let pointAPI = Vue.resource("/main");
      pointAPI.get().then( result =>
          result.json().then( data =>
              data.forEach( point =>
                  this.points.push(point)
              )
          )
      )
    }
  }
</script>

<style>

</style>