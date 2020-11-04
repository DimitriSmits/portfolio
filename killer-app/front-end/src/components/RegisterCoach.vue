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
                    Schrijf een kleine intro over jezelf, zodat spelers beter weten wat ze kunnen verwachten
                  <v-flex xs12>
                    <v-text-field
                      name="intro"
                      label="intro"
                      id="intro"
                      v-model="intro"
                      type="intro"
                      required></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field
                      name="LOL Summoner Name"
                      label="LOL Summoner Name"
                      id="lolname"
                      v-model="lolname"
                      type="lolname"
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
        confirmPassword: '',
        lolname:'',
        intro:'',
        alertSucces: false
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
      
      send: function () {
      this.axios
        .post("http://192.168.178.21:8089/coaches/", {
          userName: this.username,
          password: this.password,
          intro:this.intro,
          lolname:this.lolname
        })
        .then((response) => {
          console.log(response.status);
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