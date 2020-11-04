<template>
  <v-card class="mx-auto" max-width="1500">
    <v-container fluid>
      <v-row dense>
        <v-col
          v-for="card in cards"
          :key="card.title"
          cols="12"
          md="4"
          sm="3"
          xs="12"
        >
          <v-card>
            <v-img
              :src="require('../assets/fakerLes.jpg')"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="200px"
            >
              <v-card-title v-text="card.title"></v-card-title>
            </v-img>
            <v-card-text>
              <div>
                Beschrijving
                {{card.description}}
              </div>
            </v-card-text>
            <v-card-actions>
              <router-link :to="{path: '/Lessons/' + card.lessonId}" tag="v-btn"> 
              <v-btn text>Details</v-btn>
              </router-link>

              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
export default {
  name: "#app",
  mounted() {
    this.loadLessons();
  },
  methods: {
    loadLessons: function () {
      this.axios
        .get("http://192.168.178.21:8089/lessons/")
        .then((response) => (this.cards = response.data));
    },
  },
  data: () => ({
    cards: [],
  }),
};
</script>