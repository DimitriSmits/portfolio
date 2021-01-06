<template>
<div class="backgroundimg">
   
  <v-container>   
    <v-row class="text-center">
      <v-col class="mb-4">
        
        <login/>
      </v-col>
    </v-row>
  </v-container>
</div>
</template>

<script>
// @ is an alias to /src
import login from '@/components/user/Login.vue'

export default {
  name: 'test',
  components: {
    login
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