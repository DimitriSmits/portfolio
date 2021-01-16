<template>
<v-container>
    <v-card class="elevation-12 mx-auto" max-width="400">
      <v-toolbar class="toolbarname" color="#272727">
        <v-toolbar-title>Session {{ getSession.user.userName }} and {{getSession.coach.userName}} </v-toolbar-title>
      </v-toolbar>
        <v-card-title>
       Start
      </v-card-title>
      <v-card-text>
      The coach will send you a friend request on discord
      </v-card-text>
      <v-card-title>
       Discord details
      </v-card-title>
      <v-card-text>
      Coach: {{getSession.coach.discord}}<br>Player: {{getSession.user.discord}}
      </v-card-text>
      <v-card-title>
       Initial question:
      </v-card-title>
      <v-card-text>
      {{ getSession.question }}
      </v-card-text>
       <div v-if="getSession.active==true&&this.userid!=null">
      <v-card-title>
       Active
      </v-card-title>
       </div>
      <div v-else-if="getSession.active==false">
      <v-card-title >
       Feedback by coach
      </v-card-title>
      <v-card-text>
      {{ getSession.feedback }}
      </v-card-text>
      <v-card-title >
       Session closed
      </v-card-title>
      </div>
      <div v-else-if="this.coachid!=null">
       <v-card-title >
       Send feedback to player
      </v-card-title>
       <v-text-field  name="feedback"
                      id="feedback"
                      v-model="feedback"
                      type="feedback"
                      required
                      v-if="this.coachid!=null">
      </v-text-field>
      <v-btn @click.native.prevent="closeSession(getSession.id)" v-if="this.coachid!=null">Send feedback and Close session</v-btn>
      </div>
      

    </v-card>
    <br />
    <v-alert
      class="elevation-12 mx-auto"
      outlined
      type="success"
      text
      :value="alertSucces"
      max-width="1000px"
      style="width: 400px;"
    >
      Alert
    </v-alert>
  </v-container>
  
</template>

<script>
export default {
  mounted() {
  

  },
  methods: {
   closeSession: function (id) {
      this.axios
        .put(
          "http://192.168.178.21:8089/coachsessions/close",
          {
            id: id,
            active: false,
            feedback: this.feedback,
            
          })
          .then(response => {
            console.log(response.status);
            this.$router.push('CoachSessions')
          })
          .catch(error => {
            console.log(error.response)
          })
    }

   
   
  },
  data: () => ({
  alertSucces: false,
  feedback: '',
  }),
  computed: {
    
    getSession: function(){
      return this.$store.getters.session
    },
    userid: {
        get () {
        return this.$store.state.userid
          }
        },
    coachid: {
    get () {
    return this.$store.state.coachid
      }
    },
  },
}
</script>
<style scoped>
.toolbarname{
  color: #69bdd2;
}
</style>