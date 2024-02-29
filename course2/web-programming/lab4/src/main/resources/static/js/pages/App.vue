<script>
export default {

  }
</script>

<template>
  <router-view></router-view>
</template>

<style>
  :root {
    --white: #e2e8f0;
    --black: #020617;
    --primary: #00386e;
    --button-background: #cadaef;
    --button-background-hover: #a9bad2;
    --red: #f51d1d;
  }
  body {
    background-color: var(--white);
  }

  .button {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 150%;
    background-color: var(--button-background);
    border: 2px var(--primary) solid;
    border-radius: 10px;
    text-decoration: none;
    padding: 5px;
    margin-top: 7px;
    margin-right: 5px;
  }
  .button:hover {
    background-color: var(--button-background-hover);
  }
  .block {
    display: flex;
    justify-content: center;
    align-content: center;
  }
</style>