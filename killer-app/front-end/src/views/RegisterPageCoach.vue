<template>
  <v-container>
    <v-row class="text-center">
      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">Register as a coach</h1>
         <router-link to='/LoginPageCoach'>Already have an account? Sign in here</router-link>
        <registerCoach/>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
// @ is an alias to /src
import registerCoach from '@/components/coach/RegisterCoach.vue'

export default {
  name: 'test',
  components: {
    registerCoach
  }
}
</script>