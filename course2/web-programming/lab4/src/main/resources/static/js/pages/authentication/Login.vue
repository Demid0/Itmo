<script>

import TextInput from "../../components/inputs/TextInput.vue";
import axios from "axios";
import {router} from "../../router";
import ErrorSpace from "../../components/errors/ErrorSpace.vue";
import {store} from "../../store";
import NavigationHeader from "../../components/NavigationHeader.vue";

export default {
  components: {NavigationHeader, ErrorSpace, TextInput},
  data() {
    return {
      errors: [],
      user: {
        username: {
          value: '',
          name: "Username"
        },
        password: {
          value: '',
          name: "Password"
        }
      }
    }
  },
  methods: {
    login() {
      let username = this.user.username.value;
      let password = this.user.password.value;
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
          else this.errors = [response.data.message];
        }).catch(error => this.errors = [error.response.data.message]);
      }
      else {
        let errorsToDisplay = []
        if (username === null || username === "") errorsToDisplay.push("Username is required");
        if (password === null || password === "") errorsToDisplay.push("Password is required");
        this.errors = errorsToDisplay;
      }
    },
    isValid(username, password) {
      return username !== null
          && username !== ""
          && password !== null
          && password !== "";
    },
  }
}
</script>

<template>
  <div>
    <navigation-header/>
    <div class="block">
      <table>
        <tr><text-input
            v-model="user.username"
            :length="15"
        /></tr>
        <tr><text-input
            v-model="user.password"
            :length="15"
            :secret="true"
        /></tr>
        <tr><input class="button" type="submit" value="Login" @click="login"></tr>
        <tr><error-space :errors="errors" style="padding-left: 0;"/></tr>
      </table>
    </div>
  </div>
</template>

<style scoped>
  .block {
    margin-top: 20px;
  }
  table {
    width: min-content;
  }
</style>