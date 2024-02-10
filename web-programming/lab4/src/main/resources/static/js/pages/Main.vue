<script>
import PointForm from "../components/forms/PointForm.vue";
import PointTable from "../components/points.layout/table/PointTable.vue";
import Graphic from "../components/points.layout/graphic/Graphic.vue";

export default {
    components: {Graphic, PointForm, PointTable},
    data() {
      return {
        points: [],
        r: []
      };
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