<template>
  <v-container>
    <v-layout row>
      <v-flex xs12 sm6 offset-sm3>
        <v-card>
          <v-card-text>
            <v-container>
              <form @submit.prevent="onLogin">
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field
                      name="username"
                      label="username"
                      id="username"
                      v-model="username"
                      type="username"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field
                      name="password"
                      label="Password"
                      id="password"
                      v-model="password"
                      type="password"
                      required></v-text-field>
                  </v-flex>
                </v-layout> 
                <v-layout row>
                  {{coachid}}
                  <v-flex xs12>
                    <v-btn @click.native.prevent="send" type="submit">Login</v-btn>
                  </v-flex>
                </v-layout>
                
              </form>
              <v-alert
             class="elevation-12 mx-auto"
             outlined
             type="success"
             text
             :value="alertSucces"
             max-width="1000px"
            >
              Logged in!
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
     name: 'login',
     computed:{
        coachid: {
       get () {
        return this.$store.state.coachid
          }
     },
     },
    data () {
      return {
        username: '',
        password: '',
        alertSucces: false,
      }
    },

    methods: {
      login () {
        this.$store.dispatch('login', {email: this.email, password: this.password})
      },
      send: function () {
      this.axios
        .post("http://192.168.178.21:8089/coaches/login", {
          userName: this.username,
          password: this.password,  
        })
        .then((response) => {
          this.username = response.data.userName
          this.$store.commit('updateCoachid', response.data.coachId)
          console.log(response.status + 'statussss');
          console.log(response.data.lolname + 'ID');
         
          if (response.status !== 204) {
            this.alertSucces = true;
          }
        })
        .catch((error) => {
          console.log(error.response);
        });
    },
    }
  }
</script>