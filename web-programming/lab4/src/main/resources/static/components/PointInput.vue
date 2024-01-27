<template>
  <div>
    <button-input :name="x"/> <br/>
    <input type="text" v-model="y" maxlength="7"/> <br/>
    <button-input :name="r"/> <br/>
    <input type="submit" value="Check" @click="send"/>
  </div>
</template>

<script type="module">
  import Vue from "vue";
  import ButtonInput from "./ButtonInput.vue";

  function validate(point) {
    function between(a, from, to) {
      return !(a == null || isNaN(a)) && (from <= a && a <= to)
    }
    let x = parseFloat(point.x);
    let y = parseFloat(point.y);
    let r = parseInt(point.r);
    return between(x, -4, 4) && between(y, -5, 5) && between(r, -4, 4);
  }

  export default {
    components: {ButtonInput},
    props: ['points'],
    data()  {
      return {
        x : 'x',
        y : '',
        r : 'r'
      }
    },
    methods: {
      send() {
        let point = {
          x : document.getElementById("x").value,
          y : this.y,
          r : document.getElementById("r").value,
          time : new Date().toLocaleTimeString()
        };
        if (validate(point)) {
          let pointAPI = Vue.resource("/main");
          pointAPI.save(point).then(result =>
              result.json().then(data => {
                if (data['id'] === -1) {}
                else this.points.push(data);
                document.getElementById("x").value = '';
                document.getElementById("r").value = '';
                this.y = '';
              })
          )
        } else {
          alert("lolololo")
        }
      }
    }
  }
</script>

<style>

</style>