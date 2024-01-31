<script>
import PointTableRow from "./PointTableRow.vue";
import axios from "axios";

export default {
    components: {PointTableRow},
    props: ['points'],
    created() {
      axios.get('/controller/hash_to_init').then(result => {
        result.data.forEach(point => this.points.push(point))
      })
    },
    methods: {
      clear() {
        axios.delete('/controller/hash_to_init').then(result => {
          if (result.status === 200) this.points.length = 0
        })
      }
    }
  }
</script>

<template>
  <div>
    <div>Результаты предыдущих проверок</div>
    <input type="button" value="clear" v-on:click="clear"/>
    <table>
      <tr><td>X</td><td>Y</td><td>R</td><td>Result</td><td>Time</td></tr>
      <point-table-row v-for="point in points" :point="point"/>
    </table>
  </div>
</template>

<style>

</style>