<template>

    <v-container >
        <h1 align="center">
            {{currentLesson.title}}
        </h1><br>
        <div align="center">
  <iframe width="1120" height="630" v-bind:src="currentLesson.videoURL" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  
        <div class="grey--text mb-2" align="center">
                      {{currentLesson.description}}
        </div>

    </v-container>

</template>
<script>
export default {
    name:"lesson",
    data(){
        return{
            currentLesson:null,
            message:''
        };
    },
    methods:{
        getLesson(id){
        this.axios
        .get("http://192.168.178.21:8089/lessons/"+id)
        .then((response) => (this.currentLesson = response.data));
        },  
    },
    mounted(){
        this.message = '';
        this.getLesson(this.$route.params.id);
    }
};
</script>
