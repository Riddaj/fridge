<template>
  <div v-show="toggle">true</div>
  <div v-show="!toggle">false</div>
  <button @click="onToggle">Toggle</button>
  <div id="app">
    <ex-component /> <!-- 컴포넌트를 사용하는 부분 -->
  </div>
  <div class="container">
    <h2>TO DO LIST</h2>
    <input v-bind:type="type" 
            v-model="searchText"
            placeholder="Search"
    > 
    <hr />
    <TodoSimpleForm @add-todo="addTodo"/>
    <div>{{ error }}</div>
      <!-- todos 리스트 출력 -->
      <!-- {{ todos }} -->
      <div v-if="!filteredTodos.length">
        There is nothing to display
      </div>
      <TodoList 
      :todos="filteredTodos" 
      @toggle-todo="toggleTodo"
      @delete-todo="deleteTodo"
      />
      <hr />
      <nav aria-label="Page navigation example">
        <ul class="pagination">
          <li class="page-item">
            <a class="page-link" href="#">Previous</a>
          </li>
          <li
            v-for="page in numberOfPages"
            :key="page" 
            class="page-item"
            :calss="currentPage === page ? 'active': ''"
            >
            <a class="page-link" href="#">{{ page }}</a>
          </li>
          <li class="page-item">
            <a class="page-link" href="#">Next</a>
          </li>
        </ul>
      </nav>
      {{ numberOfPages }}
  </div>
</template>

<script>
import { ref, computed } from 'vue';
import TodoSimpleForm from './components/TodoSimpleForm.vue';
import TodoList from './components/TodoList.vue';
import axios from 'axios';
// exComponent를 import
import ExComponent from './components/exComponent.vue';



export default {
  //components: { TodoSimpleForm },
  components: {
    TodoSimpleForm,
    TodoList,
    ExComponent,
  },
  setup(){
   //toggole 선언
   const toggle = ref(false);
   //to do list 만들기(list니까 array로 놓음)

   const error = ref('');
   const numberOfTodos = ref(0);
   const limit = 5;
   const currentPage = ref(1);

   
   //비동기 사용async 
   const getTodos = async () =>{
     try {
       const res = await axios.get(
         `http://localhost:3000/todos?_page=${currentPage.value}&_limit=${limit}`);
         numberOfTodos.value = res.headers['x-total-count'];
         console.log("헤더 받아오냐고: " + res.headers);
         todos.value = res.data;
        } catch (err) {
          console.log(err);
          error.value = 'getTodos went wrong';
        }
      }
      
      getTodos();
      
    const numberOfPages = computed(() => {
       const pages = Math.ceil(numberOfTodos.value/limit);
       console.log("에러나는가 보자고 : " + pages);
       return Math.ceil(numberOfTodos.value/limit);
      });

   const toggleTodo = async (index) => {
      error.value = '';
      const id = todos.value[index].id;
      try {
          await axios.patch('http://localhost:3000/todos/' + id, {
            completed : !todos.value[index].completed
          });
      } catch (err) {
        console.log(err);
        error.value = 'Something went wrong';
      }
    todos.value[index].completed = !todos.value[index].completed;

  }
  
  const todos = ref([]);
  const todoStyle = {
    textDecoration: 'line-through',
    color: 'gray'
  };

    // const greeting = (name) => {
    //   return 'Hello, ' + name;
    // };

    const addTodo = async (todo) => {
      error.value ='';
      try{
        //db에 todo를 저장하기(강의) json server에 저장- 추후에 백엔드로 mysql에 저장해야함) 
        const res = await axios.post('http://localhost:3000/todos', {
          subject: todo.subject,
          completed: todo.completed,
        });
        todos.value.push(res.data);
      } catch (err) {
        console.log(err);
        error.value = 'Something went wrong';
      }
      // .then(res =>{
      //   //console.log(todo);
      //   console.log(res);
      //   todos.value.push(res.data);
      // }).catch(err => {
      //   console.log(err);
      //   error.value = 'Something went wrong';
      //   });
    };

    const onToggle = () =>{
      toggle.value = !toggle.value;
    };

    // const updateName = (e) => {
    //   name.value - e.target.value;
    //   console.log(e.target.value)
    // };

    //to do list 삭제
    const deleteTodo = async (index) => {
      error.value = '';
      const id = todos.value[index].id;
      try {
        await axios.delete('http://localhost:3000/todos/' + id);
        todos.value.splice(index, 1);
      } catch (err) {
        error.value = 'Something went wrong';
      }
      
    };

    const searchText = ref('');
    const filteredTodos = computed(() => {
      if(searchText.value) {
        //filter 함수 : 자바스크립트 기본 함수, array에 쓸 수 있음
        return todos.value.filter(todo => {
          return todo.subject.includes(searchText.value);
        });
      }
      return todos.value;
    });

    return{
      todos,
      addTodo,
      toggle,
      toggleTodo,
      onToggle,
      todoStyle,
      deleteTodo,
      searchText,
      filteredTodos,
      error,
      numberOfPages,
      currentPage,
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