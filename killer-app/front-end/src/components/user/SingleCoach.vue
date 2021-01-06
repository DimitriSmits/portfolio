<template>

    <v-container >
      <v-card class="elevation-12 mx-auto" max-width="600">
        <v-toolbar class="toolbarname" color="#272727">
        <v-toolbar-title color="#69bdd2">{{currentCoach.userName}}</v-toolbar-title>
      </v-toolbar>
      <v-card-title>
        {{currentCoach.lolname}}
      </v-card-title>
      <v-card-text>
      {{currentCoach.intro}}
      </v-card-text>
      <v-card-title>
        Request
      </v-card-title>
      <v-card-text>
      Ask a question to the coach and send a request!
      </v-card-text>
      <v-text-field name="question"
                      label=""
                      id="question"
                      v-model="question"
                      type="question"
                      required>
      </v-text-field>
      <v-btn @click.native.prevent="join">Request Session</v-btn>
      </v-card>
    </v-container>
    

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
    name:"coach",
    data(){
        return{
            currentCoach:null,
            message:'',
            question: '',
            alertSucces: false,
        };
    },
    methods:{
        getCoach(id){
        this.axios
        .get("http://192.168.178.21:8089/coaches/"+id)
        .then((response) => (
            this.currentCoach = response.data));
        },  
        join: function () {
      this.axios
        .post("http://192.168.178.21:8089/coaches/request", {
          userId: this.userid,
          coachId: this.currentCoach.coachId,  
          question: this.question,
          accepted: false
        })
        .then((response) => {
         
          if (response.status !== 204) {
            this.alertSucces = true;
          }
        })
        .catch((error) => {
          console.log(error.response);
        });
      },
    },
    mounted(){
        this.message = '';
        this.getCoach(this.$route.params.id);
    }
};
</script>
<style scoped>
.toolbarname{
  color: #69bdd2;
}
</style>
