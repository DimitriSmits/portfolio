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
         
              Coaches
        
      </v-btn>
      <v-btn to="/Statistics">
         
              Statistics
         
      </v-btn>
        <v-btn to="/Lessons">
        
             Lessons
         
      </v-btn>
        <v-btn to="/CoachSessions">
          
             Coach sessions
         
      </v-btn>
      

      <v-spacer></v-spacer>
      <v-btn to="/LoginPage" icon>
        Login
      </v-btn>
      <v-btn to="/RegisterPage" icon>
        Register
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
