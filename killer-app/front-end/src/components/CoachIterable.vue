<template>
  <v-card class="mx-auto" max-width="1500">
    <v-container fluid>
      <v-row dense>
        <v-col
          v-for="card in cards"
          :key="card.coachId"
          cols="6"
          md="2"
          sm="1"
          xs="6"
        >
          <v-card>
            <v-img
              :src="require('../assets/profileicon.jpg')"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="180px"
            >
              <v-card-title v-text="card.username"></v-card-title>
            </v-img>
            <v-card-text>
              <div>
                Summonername
                {{card.lolname}}
              </div>
            </v-card-text>
            <v-card-actions>
              <router-link :to="{path: '/Coaches/' + card.coachId}" tag="v-btn"> 
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
    this.loadCoaches();
  },
  methods: {
    loadCoaches: function () {
      this.axios
        .get("http://192.168.178.21:8089/coaches/")
        .then((response) => (this.cards = response.data));
    },
  },
  data: () => ({
    cards: [],
  }),
};
</script>