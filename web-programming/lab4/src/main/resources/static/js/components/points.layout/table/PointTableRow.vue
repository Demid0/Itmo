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
    <td>{{point.x}}</td>
    <td>{{point.y}}</td>
    <td>{{point.r}}</td>
    <td>{{point.result}}</td>
    <td>{{point.time}}</td>
    <td><button v-on:click="deletePoint(point.id)">X</button></td>
  </tr>
</template>

<style>

</style>