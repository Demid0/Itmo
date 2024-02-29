<script>
import NavigationHeader from "../NavigationHeader.vue";

export default {
  components: { NavigationHeader }
}
</script>

<template>
  <div>
    <navigation-header/>
    <div class="block">
      <h1>Bro, please return for existing pages</h1>
    </div>
  </div>
</template>

<style scoped>
  h1 {
    color: var(--red);
  }
</style>