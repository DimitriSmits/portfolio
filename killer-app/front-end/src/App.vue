<template>
  
  <v-app id="inspire">
    <v-app-bar app flat dark>
      <router-link style="text-decoration: none; color: inherit;" to="/">
      <v-toolbar-title style="width: 90px">Killerapp</v-toolbar-title>
      </router-link>
      <v-tabs >
         <v-spacer></v-spacer>
        <v-tab to="/Coaches">Coaches</v-tab>
        <v-tab to="/Statistics">Statistics</v-tab>
        <v-tab to="/Lessons">Lessons</v-tab>
        <v-tab to="/CoachSessions">Coach Sessions</v-tab>
         <v-spacer></v-spacer>
        <v-tab to="/LoginPage">Login</v-tab>
        <v-tab to="/RegisterPage">Register</v-tab>
      </v-tabs>
    </v-app-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
    <v-footer
    dark
    flat
    padless
  >
    <v-row justify="center"    no-gutters  >
      <v-btn   color="white" text   rounded  class="my-2"    >
      About us
      </v-btn>
      <v-btn   to="/RegisterPageCoach" color="white" text   rounded  class="my-2"    >
      Coaching Options
      </v-btn>
      <v-btn   color="white" text   rounded  class="my-2"    >
      Contact us
      </v-btn> 
    </v-row>
  </v-footer>
  </v-app>
</template>

<script>

//import HelloWorld from './components/HelloWorld';

export default {
  name: 'App',

 

  data: () => ({
    //
  }),
};
</script>

