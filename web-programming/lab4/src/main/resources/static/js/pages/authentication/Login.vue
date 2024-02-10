<script>

import {defineComponent} from "vue";
import TextInput from "../../components/inputs/TextInput.vue";
import axios from "axios";
import {router} from "../../router";
import ErrorSpace from "../../components/errors/ErrorSpace.vue";
import {store} from "../../store";
import {displayErrors} from "../../displayErrors";

export default defineComponent({
  components: {ErrorSpace, TextInput},
  data() {
    return {
      errors: []
    }
  },
  methods: {
    login() {
      let username = document.getElementById("Username").value;
      let password = document.getElementById("Password").value;
      if (this.isValid(username, password)) {
        axios.post('/auth/login', {
          name: username,
          userPassword: password
        }).then(response => {
          if (response.status === 200) {
            let user = {
              username: username,
              token: response.data.token
            };
            store.dispatch('login', user);
            router.push("/main");
          }
          else displayErrors(this.errors, [response.data.message]);
        }).catch(err => displayErrors(this.errors, [err.response.data.message]));
      }
      else {
        let errorsToDisplay = []
        if (username === null || username === "") errorsToDisplay.push("Username is required");
        if (password === null || password === "") errorsToDisplay.push("Password is required");
        displayErrors(this.errors, errorsToDisplay);
      }
    },
    isValid(username, password) {
      return username !== null
          && username !== ""
          && password !== null
          && password !== "";
    }
  }
})
</script>

<template>
  <div>
    <error-space :errors="errors"/>
    <text-input variable="Username" :length="15"/>
    <text-input variable="Password" :length="15"/>
    <input type="submit" value="Login" v-on:click="login">
  </div>
</template>

<style>

</style>