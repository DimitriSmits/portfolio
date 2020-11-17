<template>
<section>
  <div >
    <h1>Coachsessions</h1>
    <Sessions v-if="this.$store.state.userid!=null"/>
    <PlayerSessions v-else-if="this.$store.state.coachid!=null"/>
  </div>
  
</section>

  
</template>
<script>
import Sessions from '@/components/SessionsIterable.vue'
import PlayerSessions from '@/components/PlayerSessionsIterable.vue'

export default {
  name: 'Test',
  components: {
    Sessions,
    PlayerSessions
  }
}
</script>