<script>
import axios from "axios";
import ButtonInput from "../inputs/ButtonInput.vue";
import TextInput from "../inputs/TextInput.vue";
import {store} from "../../store";

export default {
  components: { TextInput, ButtonInput },
  props: ['points', 'point'],
  methods: {
    send() {
      if (this.validateForm()) {
        let res = {
          x: this.point.x.value,
          y: this.point.y.value,
          r: this.point.r.value,
        };
        axios.post('/controller', res, {
          headers: { 'Authorization': "Bearer " + store.getters.getToken }
        }).then(result => {
          if (result.status === 200) this.$emit('add', result.data);
          else this.$emit('err', ["something went wrong"]);
          this.$emit('reset');
        }).catch(error => { this.$emit('err', error.response.data.message)});
      }
    },
    validateForm() {
      let errorsToDisplay = [];
      let x = this.point.x.value;
      let y = this.point.y.value;
      let r = this.point.r.value;
      if (x === null || isNaN(x)) errorsToDisplay.push("x is required");
      if (y === null || y === '') errorsToDisplay.push("y is required");
      else if (!(-5 <= parseFloat(y) && parseFloat(y) <= 5)) errorsToDisplay.push("y is not between -5 and 5");
      if (r === null || isNaN(r)) errorsToDisplay.push("r is required");
      this.$emit('err', errorsToDisplay);
      return errorsToDisplay.length === 0;
    },
    resetPoint() {
      this.point.x.value = NaN;
      this.point.y.value = '';
      this.point.r.value = NaN;
      this.$emit('reset');
      this.$emit('err', []);
    },
  }
}
</script>

<template>
  <div>
    <button-input v-model="point.x" :from="-4" :to="4"/>
    <text-input v-model="point.y" :length="7"/>
    <button-input v-model="point.r" :from="1" :to="4"/>
    <input class="button" type="button" value="Save" @click="send">
    <input class="button" type="button" value="Reset" @click="resetPoint">
  </div>
</template>

<style>

</style>