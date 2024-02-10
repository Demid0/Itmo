<script>

  import {router} from "../../router";
  import axios from "axios";
  import {store} from "../../store";

  export default {
    methods: {
      logout() {
        axios.post("/auth/logout", {}, {
          headers: { 'Authorization': "Bearer " + store.getters.getToken }
        }).then(result => {
          if (result.status === 200) {
            store.dispatch('logout');
            router.push("/login");
          }
          else {
            console.log("/logout error");
            this.backToMain();
          }
        });
      },
      backToMain() {
        router.back();
      }
    }

  }
</script>

<template>
  <div>
    <h1>Are you really want to logout?</h1>
    <input type="button" value="Yes" v-on:click="logout">
    <input type="button" value="No" v-on:click="backToMain">
  </div>
</template>

<style>

</style>