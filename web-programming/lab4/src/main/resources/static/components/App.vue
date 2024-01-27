<template>
  <div>
    <input type="hidden" id="x"/>
    <input type="hidden" id="r"/>
    <point-input :points="points" />
    <points-table :points="points" />
  </div>
</template>

<script type="module">

  import pointsTable from "./PointsTable.vue";
  import pointInput from "./PointInput.vue";

  export default {
    components: {
      pointsTable, pointInput
    },
    data() {
      return {
        points: []
      }
    }
  }
</script>

<style>

</style>