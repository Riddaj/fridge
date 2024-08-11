<template>
    <form @submit.prevent="onSubmit">
      <div class="d-flex">
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
      </div>
      <div v-show="hasError" style="color: red">
        This field cannot be empty
      </div>
    </form>
</template>

<script>
    import { ref } from 'vue';

    export default {
      emits: ['add-todo'],
      setup(props, { emit }){
        //name 바꾸는 함수가 적용되기 위해서 ref를 사용
        const todo = ref('');
        const hasError = ref(false);
        const onSubmit = () => {
            //form에서 리로딩하는 것을 막기 위한 것
            //event.prevnetDefault();
            //ref를 사용하면 name 뒤에 .value를 붙여야 한다
            console.log(todo.value)
            if(todo.value === ''){
              hasError.value = true;
            }else{
              //데이터를 부모컴포넌트로 보내는 기능: context.emit
              emit('add-todo', {
                id: Date.now(),
                subject: todo.value,
                completed: false, 
              });
                // todos.value.push({
                // id: Date.now(),
                // subject: todo.value,
                // completed: false,   //체크박스를 위한 completed
                //});
              hasError.value = false;
              todo.value = '';
            }
          };
       
        return{
          todo,
          hasError,
          onSubmit,
        }
      }

    }
</script>

<style></style>