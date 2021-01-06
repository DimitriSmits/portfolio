<template>
  <v-container>
    <v-layout row>
      <v-flex xs12 sm6 offset-sm3>
        <v-toolbar  class="toolbarname" color="#272727">
            <v-spacer></v-spacer>
            <v-toolbar-title class="justify-center " >Login</v-toolbar-title>
            <v-spacer></v-spacer>
        </v-toolbar>
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
                  <v-flex xs12>
                    <v-text-field
                      name="confirmPassword"
                      label="Confirm Password"
                      id="confirmPassword"
                      v-model="confirmPassword"
                      type="password"
                      :rules="[comparePasswords]"></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field
                      name="lolname"
                      label="lolname"
                      id="lolname"
                      v-model="lolname"
                      type="lolname"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field
                      name="Discord name and tag"
                      label="Discord name + tag"
                      id="discord"
                      v-model="discord"
                      type="discord"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-btn @click="send">Sign up</v-btn>
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
        password: '',
        lolname:'',
        discord:'',
        confirmPassword: '',
        alertSucces: false
      }
    },
    computed: {
      userID(){
        return this.$store.state.userid
      },
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
      
      send: function () {
      this.axios
        .post("http://192.168.178.21:8089/user/", {
          userName: this.username,
          password: this.password,
          lolname: this.lolname,
          discord: this.discord
        })
        .then((response) => {
          console.log(response.status);
          if (response.status !== 204) {
            this.alertSucces = true;
            this.$router.push('LoginPage') 
          }
        })
        .catch((error) => {
          console.log(error.response);
        });
    },
    }
  }
</script>
<style scoped>
.toolbarname{
  color: #69bdd2;
}
</style>