<template>
<section>
  <SingleSession/>
  
</section>


</template>

<script>
//@ is an alias to /src
import SingleSession from '@/components/SingleSession.vue'

export default {
 name: 'Session',
 components: {
   SingleSession
 }
}
</script>