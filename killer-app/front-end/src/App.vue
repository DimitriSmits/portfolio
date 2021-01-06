<template>
  <div>
  <Navbar v-if="this.userid!=null"></Navbar>
  
  <NavbarCoach v-else-if="this.coachid!=null"></NavbarCoach>
  <NavbarDefault v-else-if="this.userid==null&&this.coachid==null"></NavbarDefault>


  </div>


</template>


<script>

import Navbar from './components/user/Navbar';
import NavbarCoach from './components/coach/NavbarCoach';
import NavbarDefault from './components/NavbarDefault';

export default {
  name: 'App',
  components: {
    Navbar,
    NavbarCoach,
    NavbarDefault
  },
  computed:{
        userid: {
        get () {
        return this.$store.state.userid
          }
        },
        coachid: {
        get (){
          return this.$store.state.coachid
        }
        }
  },

  data: () => ({
    //
  }),
};
</script>
<style>
</style>

