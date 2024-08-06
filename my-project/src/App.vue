<template>
  <div v-show="toggle">true</div>
  <div v-show="!toggle">false</div>
  <button @click="onToggle">Toggle</button>
  <div class="container">
    <h2>TO DO LIST</h2>
    <TodoSimpleForm/>

      <!-- todos 리스트 출력 -->
      <!-- {{ todos }} -->
      <div v-if="!todos.length">
        추가된 To do가 없습니다
      </div>
      <div
        v-for="(t, index) in todos"
        :key="t.id"
        class="card mt-2">

        <div class="card-body p-2 d-flex align-items-center">
          <div class="form-check flex-grow-1">
            <input 
              class="form-check-input" 
              type="checkbox"
              v-model="t.completed"
            >
            <label 
              class="form-check-label"
              :class="{ todo: t.completed }"
            >
              {{ t.subject }}
            </label>
          </div>
          <div>
            <button 
              class="btn btn-danger btn-sm"
              @click="deleteTodo(index)"
            >
              Delete
            </button>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import TodoSimpleForm from './components/TodoSimpleForm.vue';

export default {
  components: { TodoSimpleForm },
  component: {
    TodoSimpleForm
  },
  setup(){
    //name 바꾸는 함수가 적용되기 위해서 ref를 사용
   const todo = ref('');
   //toggole 선언
   const toggle = ref(false);
   //to do list 만들기(list니까 array로 놓음)
   const todos = ref([]);
   const hasError = ref(false);
   const todoStyle = {
    textDecoration: 'line-through',
    color: 'gray'
   };

    // const greeting = (name) => {
    //   return 'Hello, ' + name;
    // };

    const onSubmit = () => {
      //form에서 리로딩하는 것을 막기 위한 것
      //event.prevnetDefault();
      //ref를 사용하면 name 뒤에 .value를 붙여야 한다
      console.log(todo.value)
      if(todo.value === ''){
        hasError.value = true;
      }else{
          todos.value.push({
          id: Date.now(),
          subject: todo.value,
          completed: false,   //체크박스를 위한 completed
        });
        hasError.value = false;
        todo.value = '';
      }
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

    return{
      todo,
      todos,
      onSubmit,
      toggle,
      onToggle,
      hasError,
      todoStyle,
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