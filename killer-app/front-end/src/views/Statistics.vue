<template>
<section class="pa-7">
  <v-card flat class="elevation-12 mx-auto text-center " max-width="600"> 
    <v-toolbar  class="toolbarname" color="#272727">
      <v-spacer></v-spacer>
        <v-toolbar-title class="justify-center " >{{this.currentUser.lolname}}</v-toolbar-title>
        <v-spacer></v-spacer>
      </v-toolbar>
      
      <v-img  class="imgtier" width="200" :src="require('../assets/'+tier+'.png')"></v-img>

      <v-card-title class="justify-center">
        {{this.currentUser.stats.tier}} {{this.currentUser.stats.rank}}<br> 
        {{this.currentUser.stats.leaguePoints}} LP / {{this.currentUser.stats.wins}}W {{this.currentUser.stats.losses}}L <br>
        Win Ratio {{this.currentUser.stats.winrate}} %
      </v-card-title>
  </v-card>

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
            message:'',
            tier:'',
        };
    },
methods:{
        getStats(){
        this.axios
        .get("http://192.168.178.21:8089/user/"+this.$store.state.userid)
        .then((response) => {this.currentUser = response.data
        this.tier = this.currentUser.stats.tier.toLowerCase()
        });
        }
    },
    mounted(){
        this.message = '';
        this.getStats();
        console.log(this.currentUser.stats.tier)
        
    }
}
</script>
<style scoped>
.toolbarname{
  color: #69bdd2;
}
.imgtier{
  display: block;
  margin-left: auto;
  margin-right: auto;
}
</style>