<script>
import PointForm from "../components/PointForm.vue";
import PointTable from "../components/PointTable.vue";
import Graphic from "../components/Graphic.vue";

export default {
    components: {Graphic, PointForm, PointTable},
    data() {
      return {
        points: [],
        r: []
      }
    }
  }
</script>

<template>
  <div>
    <point-form :points="points" :r="r"/>
    <point-table :points="points"/>
    <graphic :points="points" :r="r[0]"/>
  </div>
</template>

<style>

</style>