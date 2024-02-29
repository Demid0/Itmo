<script>
import PointTableRow from "./PointTableRow.vue";
import axios from "axios";
import {store} from "../../../store";

export default {
    components: { PointTableRow },
    props: ['points'],
    methods: {
      clear() {
        axios.delete('/controller', {
          headers: { 'Authorization': "Bearer " + store.getters.getToken }
        }).then(result => {
          if (result.status === 200) this.$emit('clear');
          else {
            this.$emit('err', ['Something went wrong']);
          }
        }).catch(error => { this.$emit('err', error.response.data.message)});
      },
      deletePoint(id) { this.$emit('deleteById', id); }
    }
  }
</script>

<template>
  <div>
    <div class="table_header">
      <h1>Previous results</h1>
      <input class="button" type="button" value="Clear" @click="clear"/>
    </div>
    <div class="table_body">
      <table>
        <tr>
          <td class="td-text">X</td>
          <td class="td-text">Y</td>
          <td class="td-text">R</td>
          <td class="td-text">Result</td>
          <td class="td-time">Time</td>
          <td></td>
        </tr>
        <point-table-row
            v-for="point in points"
            :point="point"
            :points="points"
            @delete="deletePoint"
        />
      </table>
    </div>
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
    width: 530px;
    overflow-x: auto;
  }
  .table_body {
    width: max-content;
    height: 180px;
    overflow-x: scroll;
    border: 2px var(--primary) solid;
    background-color: var(--button-background-hover);
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