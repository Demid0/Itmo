<script>

import {defineComponent} from "vue";
import TextInput from "../../components/inputs/TextInput.vue";
import axios from "axios";
import {router} from "../../router";
import ErrorSpace from "../../components/errors/ErrorSpace.vue";
import { store } from "../../store";
import {displayErrors} from "../../displayErrors";

export default defineComponent({
  components: {ErrorSpace, TextInput},
  data() {
    return {
      errors: []
    }
  },
  methods: {
    signUp() {
      let username = document.getElementById("Username").value;
      let password = document.getElementById("Password").value;
      let confirm = document.getElementById("Password_confirm").value;
      if (this.isConfirm(username, password, confirm)) {
        axios.post('/auth/register', {
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
        let errorsToDisplay = [];
        if (username === null || username === "") errorsToDisplay.push("Login is required");
        if (password === null || password === "") errorsToDisplay.push("Password is required");
        if (password !== confirm) errorsToDisplay.push("Password and confirm are not the same");
        displayErrors(this.errors, errorsToDisplay);
      }
    },
    isConfirm(username, password, confirm) {
      return username !== null
          && username !== ""
          && password !== null
          && password !== ""
          && password === confirm;
    }
  }
})
</script>

<template>
  <div>
    <error-space :errors="errors"/>
    <text-input variable="Username" :length="15"/>
    <text-input variable="Password" :length="15"/>
    <text-input variable="Password_confirm" :length="15"/>
    <input type="submit" value="Sign up" v-on:click="signUp">
  </div>
</template>

<style>

</style>