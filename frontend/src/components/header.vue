<template>
  <div id="header">
    <clearAll/>
    <insert/>
    <simulation/>
  </div>
</template>

<script>
import insert from '../components/header/insertSection.vue';
import simulation from '../components/header/simulationSection.vue';
import clearAll from '../components/header/clearAll.vue';

export default {
  name: 'appHeader',
  components: {
    insert,
    simulation,
    clearAll,
  },
}
</script>

<style scoped>
  #header {
    height: 5.5rem;
    background-color: #F7F9F9;
    display: flex;
    justify-content: center;
    align-items: center;
  }

/* rgb(199, 0, 57) */
</style>