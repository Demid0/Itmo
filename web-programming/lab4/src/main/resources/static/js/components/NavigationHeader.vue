<script>
  import {store} from "../store";

  export default {
    computed: {
      store() {
        return store;
      }
    }
  }
</script>

<template>
  <div>
    <div v-show="store.getters.isAuthenticated">
      <router-link class="button" to="/main">Main page</router-link>
      <router-link class="button" to="/user">{{store.getters.getUsername.length >= 13 ? store.getters.getUsername.substring(10).concat("...") : store.getters.getUsername.length === 0 ? 'User' : store.getters.getUsername }}</router-link>
      <router-link class="button" to="/logout">Logout</router-link>
    </div>
    <div v-show="!store.getters.isAuthenticated">
      <router-link class="button" to="/login">Login page</router-link>
      <router-link class="button" to="/register">Register page</router-link>
    </div>
  </div>
</template>

<style scoped>
  div {
    display: flex;
    align-content: center;
    justify-content: center;
  }
  .button:hover {
    font-size: 170%;
  }
  .button {
    text-align: center;
    height: 25px;
    width: 163px;
  }
</style>