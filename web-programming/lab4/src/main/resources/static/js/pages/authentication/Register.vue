<script>

import TextInput from "../../components/inputs/TextInput.vue";
import axios from "axios";
import {router} from "../../router";
import ErrorSpace from "../../components/errors/ErrorSpace.vue";
import { store } from "../../store";
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
        },
        passwordConfirm: {
          value: '',
          name: 'Password Confirm'
        }
      }
    };
  },
  methods: {
    signUp() {
      let username = this.user.username.value;
      let password = this.user.password.value;
      let confirm = this.user.passwordConfirm.value;
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
          else this.errors = [response.data.message];
        }).catch(err => this.errors = [err.response.data.message]);
      }
      else {
        let errorsToDisplay = [];
        if (username === null || username === "") errorsToDisplay.push("Login is required");
        if (password === null || password === "") errorsToDisplay.push("Password is required");
        if (password !== confirm) errorsToDisplay.push("Password and confirm are not the same");
        this.errors = errorsToDisplay;
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
        <tr><text-input
            v-model="user.passwordConfirm"
            :length="15"
            :secret="true"
        /></tr>
        <tr><input class="button" type="submit" value="Sign up" @click="signUp"></tr>
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