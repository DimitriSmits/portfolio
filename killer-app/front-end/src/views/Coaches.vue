<template>
<section>
  <div >
    <h1>Coaches</h1>

    <Coaches/>
  </div>
  
</section>

</template>
<script>
import Coaches from '@/components/CoachIterable.vue'

export default {
  name: 'Test',
  components: {
    Coaches,
  }
}
</script>