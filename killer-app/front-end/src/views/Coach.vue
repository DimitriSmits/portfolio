<template>
<section>

  <SingleCoach/>
  
</section>


</template>

<script>
//@ is an alias to /src
import SingleCoach from '@/components/user/SingleCoach.vue'

export default {
 name: 'Coach',
 components: {
   SingleCoach
 }
}
</script>