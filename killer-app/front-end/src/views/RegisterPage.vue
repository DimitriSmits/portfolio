<template >
<div class="backgroundimg">
  <v-container>
    <v-row class="text-center">
      <v-col class="mb-4">
        <register/>
      </v-col>
    </v-row>
  </v-container>
</div>
</template>

<script>
// @ is an alias to /src
import register from '@/components/user/Register.vue'

export default {
  name: 'test',
  components: {
    register
  }
}
</script>
<style scoped>
.backgroundimg{
  height: 100vh;
   background-image: url('../assets/aatrox.jpg');
  background-size: cover;
}
</style>