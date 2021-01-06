<template>
<section>

  <SingleLesson/>
  
</section>


</template>

<script>
//@ is an alias to /src
import SingleLesson from '@/components/SingleLesson.vue'

export default {
 name: 'Les',
 components: {
   SingleLesson
 }
}
</script>