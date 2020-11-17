<template>
<section>
  <div >
    <h1>Requests</h1>
    <Requests v-if="this.$store.state.coachid!=null"/>
  </div>
  
</section>

  
</template>
<script>
import Requests from '@/components/RequestsIterable.vue'

export default {
  name: 'Test',
  components: {
    Requests
  }
}
</script>