<template>
       <div
        v-for="(t, index) in todos"
        :key="t.id"
        class="card mt-2">

        <div class="card-body p-2 d-flex align-items-center">
          <div class="form-check flex-grow-1">
            <input 
              class="form-check-input" 
              type="checkbox"
              :value="t.completed"
              @change="toggleTodo(index)"
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
</template>

<script>
export default {
    //부모 컴포넌트에서 넘겨받기
    props: {
        todos: {
            type: Array,
            required: true,
        }
    },
    emits:['toggle-todo', 'delete-todo'],
    setup(props, { emit }){
        const toggleTodo = (index) => {
            emit('toggle-todo', index);
        };

        const deleteTodo = (index) => {
            emit('delete-todo', index);
        };

        return{
            toggleTodo,
            deleteTodo,
        }
    }
}
</script>

<style>

</style>