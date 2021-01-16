<template>
<v-app id="inspire">
    <v-app-bar app flat dark>
      <router-link style="text-decoration: none; color: inherit;" to="/">
      <v-toolbar-title style="width: 90px ;color:#69bdd2">Killerapp</v-toolbar-title>
      </router-link>
      <v-tabs >
         <v-spacer></v-spacer>

        <v-tab to="/Lessons" style="color:#69bdd2">Lessons</v-tab>
        <v-tab to="/Requests" style="color:#69bdd2">Requests</v-tab>
        <v-tab to="/CoachSessions" style="color:#69bdd2">Player sessions</v-tab>
         <v-spacer></v-spacer>
        <v-tab to="/Profile" style="color:#69bdd2">Profile</v-tab>
        <v-tab @click="logout()" to="/home" style="color:#69bdd2">Logout</v-tab>
      </v-tabs>
    </v-app-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
    <v-footer
    dark
    flat
    fixed
  >
    <v-row justify="center"    no-gutters  >
      <v-btn   color="#69bdd2" text   rounded  class="my-2"    >
      About us
      </v-btn>
      <v-btn   to="/RegisterPageCoach" color="#69bdd2" text   rounded  class="my-2"    >
      Coaching Options
      </v-btn>
      <v-btn   color="#69bdd2" text   rounded  class="my-2"    >
      Contact us
      </v-btn> 
    </v-row>
  </v-footer>
  </v-app>
</template>
<script>
export default {
    methods: {
      logout: function () {
          this.$store.commit('logoutCoach')
   
    },
    }
}
</script>
