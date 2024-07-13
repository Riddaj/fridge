<template>
    <div class="name">
      {{ name }}
    </div>
    <button 
      class="btn btn-primary"
      v-on:click="updateName">
        Click
      </button>
</template>

<script>
import { ref } from 'vue';
export default {
  setup(){
    //name 바꾸는 함수가 적용되기 위해서 ref를 사용
    let name = ref('Fridge Master');

    // const greeting = (name) => {
    //   return 'Hello, ' + name;
    // };

    const updateName = () => {
      //ref를 사용하면 name 뒤에 .value를 붙여야 한다
      name.value = 'cofdjfke';
      console.log('타냐?');
    };

    return{
      name,
      updateName,
      
    };
  }
}
</script>

<style>

</style>