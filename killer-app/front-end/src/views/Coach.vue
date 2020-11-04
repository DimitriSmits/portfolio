<template>
<section>
  <div >
    <h1>Coach</h1>
  </div>
  <SingleCoach/>
  
</section>


</template>

<script>
//@ is an alias to /src
import SingleCoach from '@/components/SingleCoach.vue'

export default {
 name: 'Coach',
 components: {
   SingleCoach
 }
}
</script>