<template>
<section>
  <div >
    <h1>Profile</h1>
  </div>
  <ProfileCoach/>

  
</section>

  
</template>

<script>
// @ is an alias to /src
import ProfileCoach from '@/components/coach/ProfileCoach.vue'

export default {
  name: 'test',
  components: {
    ProfileCoach
  }
}
</script>
