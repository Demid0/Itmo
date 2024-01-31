<script>
import axios from "axios";
import ButtonInput from "./ButtonInput.vue";
import TextInput from "./TextInput.vue";
import {validate} from "@babel/core/lib/config/validation/options";
import ErrorSpace from "./ErrorSpace.vue";

export default {
  components: {ErrorSpace, TextInput, ButtonInput},
  props: ['points', 'r'],
  data() {
    return {
      errors: []
    }
  },
  methods: {
    send: function () {
      if (this.validateForm()) {
        let res = {
          x: document.getElementById("x").value,
          y: document.getElementById("y").value,
          r: document.getElementById("r").value
        }
        axios.post('/controller/hash_to_init', res).then(result => {
          if (result.status === 200) this.points.push(result.data)
          document.getElementById("x").value = NaN
          document.getElementById("y").value = ''
          document.getElementById("r").value = NaN
        })
      }
    },
    validateForm: function () {
      let x = document.getElementById("x").value
      let y = document.getElementById("y").value
      let r = document.getElementById("r").value
      this.errors.length = 0
      if (x === null || isNaN(x)) this.errors.push("x is required")
      if (y === null || y === '') this.errors.push("y is required")
      else if (!(-5 <= parseFloat(y) && parseFloat(y) <= 5)) this.errors.push("y is not between -5 and 5")
      if (r === null || isNaN(r)) this.errors.push("r is required")
      return this.errors.length === 0;
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
    <error-space :errors="errors"/>
  </div>
</template>

<style>

</style>