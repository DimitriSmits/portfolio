<template>

    <v-container >
        <h1 align="center">
            {{currentCoach.userName}}
        </h1><br>
        <div align="center">
  </div>
  
        <div class="grey--text mb-2" align="center">
                      {{currentCoach.lolname}}<br>
                      {{currentCoach.intro}}
        </div>

    </v-container>

</template>
<script>
export default {
    name:"coach",
    data(){
        return{
            currentCoach:null,
            message:''
        };
    },
    methods:{
        getCoach(id){
        this.axios
        .get("http://192.168.178.21:8089/coaches/"+id)
        .then((response) => (this.currentCoach = response.data));
        },  
    },
    mounted(){
        this.message = '';
        this.getCoach(this.$route.params.id);
    }
};
</script>
