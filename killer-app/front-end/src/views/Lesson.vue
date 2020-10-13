<template>
<section>
  <div >
    <h1>Lesson</h1>
  </div>
  <SingleLesson/>
  <div align="center">
  <iframe width="1120" height="630" src="https://www.youtube.com/embed/jvrcJTzDArI" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
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