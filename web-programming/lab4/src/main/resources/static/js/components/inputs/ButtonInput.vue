<script>
  export default {
    props: ['from', 'to', 'modelValue'],
    methods: {
      set(value) {
        let newVal = {
          name: this.modelValue.name,
          value: value
        };
        this.$emit('update:modelValue', newVal);
      }
    }
  }
</script>

<template>
  <div>
    <div class="label-div">
      <label>Input {{ modelValue.name }}</label><br/>
    </div>
    <input class="button" type="button" v-for="n in to - from + 1" @click="set(n + from - 1)" :value="n + from - 1"/>
  </div>
</template>

<style scoped>
  .label-div {
    margin-top: 20px;
    margin-bottom: 10px;
  }
  label {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 150%;
    text-decoration: none;
    padding: 5px;
  }
  .button {
    width: 36px;
  }
</style>