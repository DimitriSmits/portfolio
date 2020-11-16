<template>

    <v-container >
        <h1 align="center">
            {{currentCoach.userName}}
        </h1><br>
        <div align="center">
  </div>
  
        <div class="grey--text mb-2" align="center">
                      {{currentCoach.lolname}}<br>
                      {{currentCoach.intro}}<br><br><br><br>
                      <v-layout row>
                    Ask a question to the coach and send a request!
                  <v-flex xs12>
                    <v-text-field
                      name="question"
                      label="question"
                      id="question"
                      v-model="question"
                      type="question"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
        </div>
        <v-btn @click.native.prevent="join">Request Lesson</v-btn>

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
