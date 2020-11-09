<template>
<section>
  <div >
    <h1>{{this.userid}}</h1>
      <v-btn @click="send">Add</v-btn>
  </div>

</section>

  
</template>
<script>

export default {
  computed:{
        userid: {
       get () {
        return this.$store.state.userid
          }
     }
},
methods: {
      send: function () {
          this.$store.commit('increment')
    }
}
}
</script>