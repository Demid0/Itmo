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
      <router-link to="/main">Main</router-link>
      <router-link to="/logout">Logout</router-link>
    </div>
    <div v-show="!store.getters.isAuthenticated">
      <router-link to="/login">Login</router-link>
      <router-link to="/register">Register</router-link>
    </div>
  </div>
</template>

<style>

</style>