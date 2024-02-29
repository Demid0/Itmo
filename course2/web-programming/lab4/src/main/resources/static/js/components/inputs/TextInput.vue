<script>
  export default {
    props: ['length', 'secret', 'modelValue'],
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
    <input :type="secret ? 'password' : 'text'" :maxlength="length" @input="set($event.target.value)" v-bind:value="this.modelValue.value"/>
  </div>
</template>

<style scoped>
  .label-div {
    margin-top: 20px;
  }
  label {
    color: var(--primary);
    font-weight: bold;
    font-family: monospace;
    font-size: 150%;
    text-decoration: none;
    padding: 5px;
  }
  input {
    border-radius: 10px;
    border: 2px var(--primary) dotted;
    color: var(--primary);
    font-size: 150%;
    padding: 5px;
    margin-top: 15px;
  }

</style>