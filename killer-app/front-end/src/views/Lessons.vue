<template>
<section>
  <div class="pa-md-4 mx-lg-auto">
    
  </div>
  <Lessons v-if="showLessons"/>
  <SingleLesson v-if="showSingleLesson"/>
    <div class="pa-md-4 mx-lg-auto">
    
  </div>

  
</section>

  
</template>
<script>
// @ is an alias to /src
import Lessons from '@/components/LessonsIterable.vue'
import SingleLesson from '@/components/SingleLesson.vue'

export default {
  name: 'Test',
  components: {
    Lessons,
    SingleLesson
  },
  data: () => ({
     showSingleLesson: false,
     showLessons: true,
  }),
  methods: {
    hideForm(){
      this.showSingleLesson = true
      this.showLessons = false
    },
  }
}
</script>


