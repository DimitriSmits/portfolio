<template>
<v-container style="background:#272727">
    <h1 style="color:white" >
        Get better at laning
    </h1>
  <v-row >
    <v-col
      v-for="n in 9"
      :key="n"
      class="d-flex child-flex"
      cols="2"
      
    >
    <router-link to="/Lesson">
      <v-img 
        :src="require('../assets/fakerLes.jpg')"
        :lazy-src="`https://picsum.photos/10/6?image=${n * 5 + 10}`"
        aspect-ratio="16/9"
        class="grey lighten-2"
        max-height="170"
        max-width="300"
        
        
      >
     
        <template v-slot:placeholder>
          <v-row
            class="fill-height ma-0"
            align="center"
           
          >
        
            <v-progress-circular
              indeterminate
              color="grey lighten-5"
            ></v-progress-circular>
          </v-row>
        </template>
      </v-img>
    </router-link>
    </v-col>
  </v-row>
</v-container>

</template>
<script>
export default {
  name:'Gallery',
  data() {
    return {
      items: [
        {
          id: 1,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 2,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 3,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 4,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 5,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 6,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 7,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 8,
          src: require("../assets/fakerLes.jpg")
        },
        {
          id: 9,
          src: require("../assets/fakerLes.jpg")
        }
      ]
    };
  }
    
}
</script>