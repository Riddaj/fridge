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
    export default {}
</script>

<style></style>