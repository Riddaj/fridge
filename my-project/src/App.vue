<template>
  <div v-show="toggle">true</div>
  <div v-show="!toggle">false</div>
  <button @click="onToggle">Toggle</button>
  <div class="container">
    <h2>TO DO LIST</h2>
    <TodoSimpleForm @add-todo="addTodo"/>

      <!-- todos 리스트 출력 -->
      <!-- {{ todos }} -->
      <div v-if="!todos.length">
        추가된 To do가 없습니다
      </div>
      <TodoList 
      :todos="todos" 
      @toggle-todo="toggleTodo"
      @delete-todo="deleteTodo"
      />
  </div>
</template>

<script>
import { ref, computed } from 'vue';
import TodoSimpleForm from './components/TodoSimpleForm.vue';
import TodoList from './components/TodoList.vue';

export default {
  //components: { TodoSimpleForm },
  components: {
    TodoSimpleForm,
    TodoList,
  },
  setup(){
   //toggole 선언
   const toggle = ref(false);
   //to do list 만들기(list니까 array로 놓음)

   const toggleTodo = (index) => {
    console.log(todos.value[index]);
    todos.value[index].completed = !todos.value[index].completed;
    console.log(todos.value[index]);
  }
   const todos = ref([]);
   const todoStyle = {
    textDecoration: 'line-through',
    color: 'gray'
   };

    // const greeting = (name) => {
    //   return 'Hello, ' + name;
    // };

    const addTodo = (todo) => {
      console.log(todo);
      todos.value.push(todo);
    };

    const onToggle = () =>{
      toggle.value = !toggle.value;
    };

    // const updateName = (e) => {
    //   name.value - e.target.value;
    //   console.log(e.target.value)
    // };

    //to do list 삭제
    const deleteTodo = (index) => {
      todos.value.splice(index, 1);
      console.log('delete Todo')
    };

    const count = ref(1);
    const doubleCount = computed(() => {
      return count.value*2;
    });

    return{
      todos,
      addTodo,
      toggle,
      toggleTodo,
      onToggle,
      todoStyle,
      count, 
      doubleCount,
      deleteTodo,
    };
  }
}
</script>

<style>
  .todo{
    color: gray;
    text-decoration: line-through;
  }
</style>