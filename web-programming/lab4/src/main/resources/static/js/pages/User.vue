<script>
import NavigationHeader from "../components/NavigationHeader.vue";
import {store} from "../store";

export default {
  computed: {
    store() {
      return store;
    }
  },
  components: { NavigationHeader }

}
</script>

<template>
<div>
  <navigation-header/>
  <div class="block">
    <table>
      <tr><h1 style="padding-left: 300px; color: var(--primary)"><b>Username:</b> {{ store.getters.getUsername }}</h1></tr>
      <tr><h1 style="font-size: 100%; padding-left: 150px; color: var(--primary)"><b>Token:</b> {{ store.getters.getToken.replaceAll(".", ".\n") }}</h1></tr>
      <tr><img style="padding-left: 220px" src="../../images/pig.jpg" width="500" height="500" alt="image"/></tr>
    </table>
  </div>
</div>
</template>

<style scoped>
  table {
    width: 50%;
  }

</style>