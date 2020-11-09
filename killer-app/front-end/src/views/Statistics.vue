<template>
<section>
  <div >
    <h1>{{this.currentUser.lolname}}</h1>
    <h1>{{this.currentUser.stats.queuetype}}</h1>
    <h1>{{this.currentUser.stats.tier}}</h1>
    <h1>{{this.currentUser.stats.rank}} Rank</h1>
    <h1>{{this.currentUser.stats.leaguePoints}} Leaguepoints</h1>
    <h1>{{this.currentUser.stats.wins}} wins</h1>
    <h1>{{this.currentUser.stats.losses}} losses </h1>
    <h1>{{this.currentUser.stats.winrate}} % winrate</h1>
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
data(){
        return{
            currentUser:null,
            message:''
        };
    },
methods:{
        getStats(){
        this.axios
        .get("http://192.168.178.21:8089/user/"+this.$store.state.userid)
        .then((response) => (this.currentUser = response.data));
        }
    },
    mounted(){
        this.message = '';
        this.getStats();
    }
}
</script>