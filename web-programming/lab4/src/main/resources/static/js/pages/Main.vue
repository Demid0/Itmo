<script>
import PointForm from "../components/forms/PointForm.vue";
import PointTable from "../components/points.layout/table/PointTable.vue";
import Graphic from "../components/points.layout/graphic/Graphic.vue";
import ErrorSpace from "../components/errors/ErrorSpace.vue";
import NavigationHeader from "../components/NavigationHeader.vue";

export default {
    components: {NavigationHeader, ErrorSpace, Graphic, PointForm, PointTable},
    data() {
      return {
        errors: [],
        points: [],
        r: []
      };
    }
  }
</script>

<template>
  <div>
    <navigation-header/>
    <table>
      <tr>
        <td>
          <graphic :points="points" :r="r[0]" :errors="errors"/>
        </td>
        <td>
          <point-form :points="points" :r="r" :errors="errors"/>
          <point-table :points="points"/>
        </td>
      </tr>
      <tr>
        <error-space :errors="errors" padding="150px"></error-space>
      </tr>
    </table>
  </div>
</template>

<style scoped>
  td {
    padding-top: 50px;
    padding-right: 100px;
    padding-left: 200px;
    width: 50%;
  }
</style>