<template>
<section>
  <div >
    <h1>Lesson</h1>
  </div>
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