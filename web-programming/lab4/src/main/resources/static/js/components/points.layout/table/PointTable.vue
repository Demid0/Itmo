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
    <div class="table_header">
      <h1>Previous results</h1>
      <input class="button" type="button" value="Clear" v-on:click="clear"/>
    </div>
    <table>
      <tr>
        <td class="td-text">X</td>
        <td class="td-text">Y</td>
        <td class="td-text">R</td>
        <td class="td-text">Result</td>
        <td class="td-time">Time</td>
        <td></td>
      </tr>
      <point-table-row v-for="point in points" :point="point" :points="points"/>
    </table>
  </div>
</template>

<style scoped>
  .table_header {
    width: max-content;
    display: flex;
    align-content: center;
    justify-content: center;
    margin-bottom: 10px;
  }
  h1 {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 200%;
    margin-right: 10px;
  }
  table {
    border-collapse: collapse;
    border: 2px var(--primary) solid;
  }
  tr, .td-text, .td-time {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 120%;
    background-color: var(--button-background);
    width: 50px;
    border: 2px var(--primary) solid;
    text-align: center;
    padding: 5px;
  }
  .td-time {
    width: max-content;
    padding: 5px;
  }
</style>