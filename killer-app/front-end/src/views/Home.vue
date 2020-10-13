<template>
<section>
  <div >
    <h1>Homepage</h1>
  </div>
  <HelloWorld/>
  
</section>

</template>

<script>
//@ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
 name: 'Home',
 components: {
   HelloWorld
 }
}
</script>
