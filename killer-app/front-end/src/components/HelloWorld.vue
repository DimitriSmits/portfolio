<template>
<div class="backgroundimg">

  <h1>Become the best league player you can be!</h1>


</div>
</template>

<script>
  export default {
     data() {
    return {
      image: { backgroundImage: "url(../assets/aatrox.jpg')" }
    };
  }

};
</script>
<style>
.backgroundimg{
  height: 100vh;
   background-image: url('../assets/aatrox.jpg');
  background-size: cover;
  line-height: 100vh;
}
.title{
  color:#69bdd2;
  margin: auto;
  text-align: center;

}
h1{
padding-top: 20px;
align-content: ;
 text-align: center;
    font-size: 3.0vw;
    color: #69bdd2;
}
</style>
