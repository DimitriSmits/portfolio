<template>
<section>
  <div >
    <h1>Coachsessions</h1>
    <Sessions/>
  </div>
  
</section>

  
</template>
<script>
import Sessions from '@/components/SessionsIterable.vue'

export default {
  name: 'Test',
  components: {
    Sessions,
  }
}
</script>