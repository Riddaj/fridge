<template>
  <div v-show="toggle">true</div>
  <div v-show="!toggle">false</div>
  <button @click="onToggle">Toggle</button>
  <div class="container">
    <h2>TO DO LIST</h2>
    <form 
      @submit.prevent="onSubmit"
      class="d-flex">
      
      <div class="flex-grow-1 mr-2">
        <!-- 데이터 바인딩, oninput event -->
        <input v-bind:type="type" 
          v-model="todo"
          placeholder="Type new to-do"
        > 
      </div>
      <div>
        <button 
          class="btn btn-primary"
          type="submit">
            Add
          </button>
        </div>
      </form>
      <!-- todos 리스트 출력 -->
      <!-- {{ todos }} -->
      <div
        v-for="t in todos"
        :key="t.id"
        class="card mt-2">
        <div class="card-body p-2">
            {{ t.subject }}
        </div>
      </div>
  </div>
</template>

<script>
import { ref } from 'vue';
export default {
  setup(){
    //name 바꾸는 함수가 적용되기 위해서 ref를 사용
   const todo = ref('');
   //toggole 선언
   const toggle = ref(false);
   //to do list 만들기(list니까 array로 놓음)
   const todos = ref([
    {id:1, subject: 'chicken breast'},
    {id: 2, subject: 'watermelon'}
   ]);

   const type = ref('text');

    // const greeting = (name) => {
    //   return 'Hello, ' + name;
    // };

    const onSubmit = () => {
      //form에서 리로딩하는 것을 막기 위한 것
      //event.prevnetDefault();
      //ref를 사용하면 name 뒤에 .value를 붙여야 한다
      console.log(todo.value)
      todos.value.push({
        id: Date.now(),
        subject: todo.value
      });
      
    };

    const onToggle = () =>{
      toggle.value = !toggle.value;
    };

    // const updateName = (e) => {
    //   name.value - e.target.value;
    //   console.log(e.target.value)
    // };

    return{
      todo,
      todos,
      onSubmit,
      type,
      toggle,
      onToggle,
    };
  }
}
</script>

<style>

</style>