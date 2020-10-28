<template>
<nav>
    <v-app-bar
      flat
      
      dark
    >
        <v-btn to="/Home" icon>
        <v-icon>home</v-icon>
      </v-btn>
     <v-spacer></v-spacer>
         <v-btn to="/Coaches">
          <v-span name="test">
              Coaches
          </v-span>
      </v-btn>
      <v-btn to="/Statistics">
          <v-span name="test">
              Statistics
          </v-span>
      </v-btn>
        <v-btn to="/Lessons">
          <v-span name="test">
             Lessons
          </v-span>
      </v-btn>
        <v-btn to="/CoachSessions">
          <v-span name="test">
             Coach sessions
          </v-span>
      </v-btn>
      

      <v-spacer></v-spacer>
      <v-btn to="/LoginPage" icon>
        <v-icon>account_circle
        </v-icon>
      </v-btn>
      <v-btn to="/RegisterPage" icon>
        <v-icon>account_circle
        </v-icon>
      </v-btn>
    
      <v-btn to="/Profile" icon>
        <v-icon>account_circle
        </v-icon>
      </v-btn>
       <v-btn icon>
        <v-icon>input</v-icon>
      </v-btn>
      

    </v-app-bar>
  
  

</nav>
</template>
<script>
export default {
    
}
</script>
