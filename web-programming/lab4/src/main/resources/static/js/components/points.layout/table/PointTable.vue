<script>
import PointTableRow from "./PointTableRow.vue";
import axios from "axios";
import {store} from "../../../store";

export default {
    components: {PointTableRow},
    props: ['points'],
    created() {
      axios.get('/controller', {
        headers: { 'Authorization': "Bearer " + store.getters.getToken }
      }).then(result => {
        if (result.status === 200) {
          result.data.forEach(point => this.points.push(point));
        } else {
          console.log("/point_table error");
        }
      })
    },
    methods: {
      clear() {
        axios.delete('/controller', {
          headers: { 'Authorization': "Bearer " + store.getters.getToken }
        }).then(result => {
          if (result.status === 200) this.points.length = 0;
          else {
            console.log("/point_table error");
          }
        })
      }
    }
  }
</script>

<template>
  <div>
    <div>Previous results</div>
    <input type="button" value="clear" v-on:click="clear"/>
    <table>
      <tr><td>X</td><td>Y</td><td>R</td><td>Result</td><td>Time</td></tr>
      <point-table-row v-for="point in points" :point="point"/>
    </table>
  </div>
</template>

<style>

</style>