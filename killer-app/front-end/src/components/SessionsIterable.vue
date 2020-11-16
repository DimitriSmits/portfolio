<template>
  <v-card class="mx-auto" max-width="1500">
    <v-container fluid>
      <v-row dense>
        <v-col
          v-for="card in cards"
          :key="card.coach.coachId"
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
              <v-card-title v-text="card.coach.username"></v-card-title>
            </v-img>
            <v-card-text>
              <div>
                Summonername
                {{card.coach.lolname}}
              </div>
            </v-card-text>
            <v-card-actions>
              <router-link :to="{path: '/Coaches/' + card.coach.coachId}" tag="v-btn"> 
              <v-btn text>Details</v-btn>
              </router-link>
              <v-btn @click.native.prevent="editProfile(card.id)" text>Accept</v-btn>

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
    this.loadSessions();
  },
  methods: {
    loadSessions: function () {
      this.axios
        .get("http://192.168.178.21:8089/coachsessions/")
        .then((response) => (this.cards = response.data));
    },
    editProfile: function (id) {
      this.axios
        .put(
          "http://192.168.178.21:8089/coachsessions/",
          {
            id: id,
            accepted: true,
            
          })
          .then(response => {
            console.log(response.status);
          })
          .catch(error => {
            console.log(error.response)
          })
    }
  },
  data: () => ({
    cards: [],
  }),
};
</script>