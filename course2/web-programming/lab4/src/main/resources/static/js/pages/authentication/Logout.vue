<script>

  import {router} from "../../router";
  import axios from "axios";
  import {store} from "../../store";
  import NavigationHeader from "../../components/NavigationHeader.vue";

  export default {
    components: { NavigationHeader },
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
        }).catch(_ => this.backToMain());
      },
      backToMain() {
        router.back();
      }
    }

  }
</script>

<template>
  <div>
    <navigation-header/>
    <div class="block">
      <h1>Are you really want to logout?</h1>
      <input class="button" type="button" value="Yes" v-on:click="logout">
      <input class="button" type="button" value="No" v-on:click="backToMain">
    </div>
  </div>
</template>

<style scoped>
  h1 {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 300%;
    margin-right: 10px;
  }
  .button {
    font-size: 200%;
    width: 75px;
  }
  .button[value="Yes"]:hover {
    background-color: #56dd36;
    font-size: 230%;
  }
  .button[value="No"]:hover {
    background-color: var(--red);
    font-size: 230%;
  }
  .block {
    position: absolute;
    top: 40%;
    left: 30%;
  }
</style>