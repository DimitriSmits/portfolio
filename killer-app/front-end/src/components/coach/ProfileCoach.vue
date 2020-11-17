<template>
  <v-container>
    <v-layout row>
      <v-flex xs12 sm6 offset-sm3>
        <v-card>
          <v-card-text>
            <v-container>
              <form @submit.prevent="onSignup">
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field
                      name="username"
                      label="username"
                      id="username"
                      v-model="username"
                      :placeholder="currentCoach.userName"
                      type="username"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                    
                  <v-flex xs12>
                    <v-text-field
                      name="intro"
                      label="intro"
                      id="intro"
                      v-model="intro"
                      type="intro"
                      :placeholder="currentCoach.intro"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field
                      name="LOL Summoner Name"
                      
                      id="lolname"
                      v-model="lolname"
                      type="lolname"
                      :placeholder="currentCoach.lolname"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-btn @click="editProfile()">Edit profile</v-btn>
                  </v-flex>
                </v-layout>
                <br>
                
               
              </form>
              <v-alert
      class="elevation-12 mx-auto"
      outlined
      type="success"
      text
      :value="alertSucces"
      max-width="1000px"
    >
      Registered!
    </v-alert>
            </v-container>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
  export default {
    data () {
      return {
        username: '',
        lolname:'',
        intro:'',
        alertSucces: false,
        currentCoach:null
      }
    },
    computed: {
      comparePasswords () {
        return this.password !== this.confirmPassword ? 'Passwords do not match' : ''
      },
      //user () {
       // return this.$store.getters.user
      //}
    },
    watch: {
      user (value) {
        if (value !== null && value !== undefined) {
          this.$router.push('/')
        }
      }
    },
    methods: {
    editProfile: function () {
      this.axios
        .put(
          "http://192.168.178.21:8089/coaches/",
          {
            coachId: this.$store.state.coachid,
            userName: this.username,
            intro:this.intro,
            lolname:this.lolname
            
          })
          .then(response => {
            console.log(response.status);
           
          })
          .catch(error => {
            console.log(error.response)
          })
    },
    getCoach(id){
        this.axios
        .get("http://192.168.178.21:8089/coaches/"+id)
        .then((response) => (
            this.currentCoach = response.data));

             
        },  
    },
    mounted(){
        this.getCoach(this.$store.state.coachid);
   
    }
  }
</script>