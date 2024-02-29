<script>
import PointForm from "../components/forms/PointForm.vue";
import PointTable from "../components/points.layout/table/PointTable.vue";
import Graphic from "../components/points.layout/graphic/Graphic.vue";
import ErrorSpace from "../components/errors/ErrorSpace.vue";
import NavigationHeader from "../components/NavigationHeader.vue";
import axios from "axios";
import {store} from "../store";

export default {
    components: {NavigationHeader, ErrorSpace, Graphic, PointForm, PointTable},
    created() {
      axios.get('/controller', {
        headers: { 'Authorization': "Bearer " + store.getters.getToken }
      }).then(result => {
        if (result.status === 200) result.data.forEach(point => this.addPoint(point));
        else this.showErrors(['Something went wrong']);
      }).catch(error => this.showErrors(error.response.data.message));
    },
    data() {
      return {
        errors: [],
        points: [],
        point: {
          x: {
            value: NaN,
            name: 'x'
          },
          y: {
            value: '',
            name: 'y'
          },
          r: {
            value: NaN,
            name: 'r'
          },
        }
      };
    },
    methods: {
      addPoint(point) { this.points.push(point); },
      clear() { this.points.length = 0; },
      deleteById(id) { this.points = this.points.filter(point => point.id !== id); },
      showErrors(errors) { this.errors = errors; },
      resetPoint() {
        this.point.x.value = NaN;
        this.point.y.value = '';
        this.point.r.value = NaN;
      }
    }
  }
</script>

<template>
  <div>
    <navigation-header/>
    <table>
      <tr>
        <td>
          <graphic
              :points="points"
              :r="point.r.value"
              @add="addPoint"
              @err="showErrors"
          />
        </td>
        <td>
          <point-form
              :points="points"
              v-model:point="point"
              @add="addPoint"
              @err="showErrors"
              @reset="resetPoint"
          />
          <point-table
              :points="points"
              @add="addPoint"
              @clear="clear"
              @deleteById="deleteById"
              @err="showErrors"
          />
        </td>
      </tr>
      <tr>
        <error-space :errors="errors" style="padding-left: 150px;"></error-space>
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