<script>
import axios from "axios";
import ButtonInput from "./ButtonInput.vue";
import TextInput from "./TextInput.vue";

export default {
    components: {TextInput, ButtonInput},
    props: ['points', 'r'],
    methods: {
      send: function () {
        let res = {
          x: document.getElementById("x").value,
          y: document.getElementById("y").value,
          r: document.getElementById("r").value
        }
        axios.post('/controller/hash_to_init', res).then(result => {
          if(result.status === 200) this.points.push(result.data)
          document.getElementById("x").value = 0
          document.getElementById("y").value = ''
          document.getElementById("r").value = 0
        })
      }
    }
  }
</script>

<template>
  <div>
    <button-input variable="x" :from="-4" :to="4"/>
    <text-input variable="y"/>
    <button-input variable="r" :from="1" :to="4" :r="r"/>
    <input type="submit" value="Save" v-on:click="send">
  </div>
</template>

<style>

</style>