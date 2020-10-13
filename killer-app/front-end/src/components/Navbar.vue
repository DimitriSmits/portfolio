<template>
<nav>
    <v-toolbar 
      flat
      app
      dark
    >
        <v-btn to="/Home" icon>
        <v-icon>home</v-icon>
      </v-btn>
     <v-spacer></v-spacer>
         <v-btn to="/Coaches">
          <v-span>
              Coaches
          </v-span>
      </v-btn>
      <v-btn to="/Statistics">
          <v-span>
              Statistics
          </v-span>
      </v-btn>
        <v-btn to="/Lessons">
          <v-span>
             Lessons
          </v-span>
      </v-btn>
        <v-btn to="/CoachSessions">
          <v-span>
             Coach sessions
          </v-span>
      </v-btn>
      

      <v-spacer></v-spacer>
    
      <v-btn to="/Profile" icon>
        <v-icon>account_circle
        </v-icon>
      </v-btn>
       <v-btn icon>
        <v-icon>input</v-icon>
      </v-btn>
      

    </v-toolbar>
  
  

</nav>
</template>
<script>
export default {
    
}
</script>
