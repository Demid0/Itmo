<script>
  import axios from "axios";
  import {store} from "../../../store";

  export default {
    props: ['point', 'points'],
    methods: {
      deletePoint(id) {
        axios.delete('/controller/' + id, {
          headers: { 'Authorization': "Bearer " + store.getters.getToken }
        }).then(result => {
          if (result.status === 200) {
            axios.get('/controller', {
              headers: { 'Authorization': "Bearer " + store.getters.getToken }
            }).then(result => {
              if (result.status === 200) {
                this.points.length = 0;
                result.data.forEach(point => this.points.push(point));
              } else {
                console.log("/point_table error");
              }
            });
          }
          else {
            console.log("/point_table error");
          }
        });
      }
    }
  }
</script>

<template>
  <tr>
    <td class="td-text">{{point.x}}</td>
    <td class="td-text">{{point.y}}</td>
    <td class="td-text">{{point.r}}</td>
    <td class="td-text">{{point.result}}</td>
    <td class="td-time">{{point.time}}</td>
    <td class="td-button" v-on:click="deletePoint(point.id)">X</td>
  </tr>
</template>

<style scoped>
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
  .td-button {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 120%;
    width: 30px;
  }
  .td-button:hover {
    background-color: var(--button-background-hover);
  }
</style>