<script>
import axios from "axios";
import ButtonInput from "../inputs/ButtonInput.vue";
import TextInput from "../inputs/TextInput.vue";
import ErrorSpace from "../errors/ErrorSpace.vue";
import {store} from "../../store";
import {displayErrors} from "../../displayErrors";

export default {
  components: {ErrorSpace, TextInput, ButtonInput},
  props: ['points', 'errors', 'r'],
  methods: {
    send() {
      if (this.validateForm()) {
        let res = {
          x: document.getElementById("x").value,
          y: document.getElementById("Input_y").value,
          r: document.getElementById("r").value
        };
        axios.post('/controller', res, {
          headers: { 'Authorization': "Bearer " + store.getters.getToken }
        }).then(result => {
          if (result.status === 200) this.points.push(result.data);
          else displayErrors(this.errors, ["something went wrong"]);
          document.getElementById("x").value = NaN;
          document.getElementById("Input_y").value = '';
          document.getElementById("r").value = NaN;
        });
      }
    },
    validateForm() {
      let x = document.getElementById("x").value;
      let y = document.getElementById("Input_y").value;
      let r = document.getElementById("r").value;
      let errorsToDisplay = [];
      if (x === null || isNaN(x)) errorsToDisplay.push("x is required");
      if (y === null || y === '') errorsToDisplay.push("y is required");
      else if (!(-5 <= parseFloat(y) && parseFloat(y) <= 5)) errorsToDisplay.push("y is not between -5 and 5");
      if (r === null || isNaN(r)) errorsToDisplay.push("r is required");
      displayErrors(this.errors, errorsToDisplay);
      return this.errors.length === 0;
    },
    reset() {
      document.getElementById("x").value = NaN;
      document.getElementById("Input_y").value = '';
      document.getElementById("r").value = NaN;
      this.errors.length = 0;
    }
  }
  }
</script>

<template>
  <div>
    <button-input variable="x" :from="-4" :to="4"/>
    <text-input variable="Input_y" :length="7"/>
    <button-input variable="r" :from="1" :to="4" :r="r"/>
    <input class="button" type="submit" value="Save" v-on:click="send">
    <input class="button" type="submit" value="Reset" v-on:click="reset">
  </div>
</template>

<style>

</style>