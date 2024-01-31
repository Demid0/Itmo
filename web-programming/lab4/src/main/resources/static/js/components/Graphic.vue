<script>
  import axios from "axios";
  import ErrorSpace from "./ErrorSpace.vue";

  export default {
    components: {ErrorSpace},
    props: ['points', 'r'],
    data() {
      return {
        errors: []
      }
    },
    methods: {
      checkFromSVG(event) {
        this.errors.length = 0
        let target = document.querySelector("svg").getBoundingClientRect();
        if (!(this.r == null || isNaN(this.r))) {
          let px = event.clientX - target.left;
          let py = event.clientY - target.top;
          let res = {
            x: ((px - 300) * this.r / 200).toFixed(2),
            y: (-(py - 300) * this.r / 200).toFixed(2),
            r: this.r
          }
          axios.post('/controller/hash_to_init', res).then(result => {
            if(result.status === 200) this.points.push(result.data)
          })
        }
        else {
          this.errors.push("r is required")
        }
      }
    }
  }
</script>

<template>
  <div>
    <error-space :errors="errors"/>
    <svg width="600px" height="600px" v-on:click="checkFromSVG">
      <!-- arrows -->
      <polygon points="300,0 290,20 310,20" stroke="#2c2d2a"/>
      <polygon points="600,300 580,290 580,310" stroke="#2c2d2a"/>

      <!-- rectangle -->
      <polygon points="200,100 200,300 300,300 300,100" fill="#0783ff"/>

      <!-- triangle -->
      <polygon points="100,300 300,300 300,500" fill="#0783ff"/>

      <!-- circle -->
      <path d="M 300,100 A 200,200 90 0,1 500,300 L 300,300 Z" fill="#0783ff"/>

      <!-- axis -->
      <line x1="0" x2="600" y1="300" y2="300" stroke="#2c2d2a"/>
      <line x1="300" x2="300" y1="0" y2="600" stroke="#2c2d2a"/>

      <!-- labels on the axis x -->
      <line x1="100" x2="100" y1="290" y2="310" stroke="#2c2d2a"/>
      <line x1="200" x2="200" y1="290" y2="310" stroke="#2c2d2a"/>
      <line x1="400" x2="400" y1="290" y2="310" stroke="#2c2d2a"/>
      <line x1="500" x2="500" y1="290" y2="310" stroke="#2c2d2a"/>

      <!-- labels on the axis y -->
      <line x1="290" x2="310" y1="100" y2="100" stroke="#2c2d2a"/>
      <line x1="290" x2="310" y1="200" y2="200" stroke="#2c2d2a"/>
      <line x1="290" x2="310" y1="400" y2="400" stroke="#2c2d2a"/>
      <line x1="290" x2="310" y1="500" y2="500" stroke="#2c2d2a"/>

      <!-- axis labels -->
      <text x="580" y="280">x</text>
      <text x="310" y="20">y</text>

      <!-- R values on the axis x -->
      <text x="80" y="276">{{ -r }}</text>
      <text x="170" y="276">{{ -r / 2 }}</text>
      <text x="380" y="276">{{ r / 2 }}</text>
      <text x="490" y="276">{{ isNaN(r) ? NaN : r }}</text>

      <!-- R values on the axis y -->
      <text x="324" y="508">{{ -r }}</text>
      <text x="324" y="408">{{ -r / 2 }}</text>
      <text x="324" y="208">{{ r / 2 }}</text>
      <text x="324" y="108">{{ isNaN(r) ? NaN : r }}</text>

      <circle v-for="point in points" v-show="point.r === r" r="3"
              :cx="300 + (200 * point.x) / point.r"
              :cy="300 - (200 * point.y) / point.r"
              :fill="point.color">
      </circle>
    </svg>
  </div>
</template>

<style>

</style>