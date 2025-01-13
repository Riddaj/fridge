<template>
  <div v-if="isVisible" class="popup-overlay">
    <div class="popup">
      <h2>Add Ingredient</h2>
      <form @submit.prevent="submitForm">
        <div>
          <label for="name">Ingredient Name:</label>
          <input type="text" v-model="formData.name" required />
        </div>
        <div>
          <label for="bestBefore">Best Before:</label>
          <input type="date" v-model="formData.bestBefore" required />
        </div>
        <button class="button" type="submit">Submit</button>
        <button class="button" type="button" @click="$emit('close')">Close</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PopupAdd',
  props: {
    isVisible: {
      type: Boolean,
      required: true,
    },
  },
  data() {
    return {
      formData: {
        name: '',
        bestBefore: '',
      },
    };
  },
  methods: {
    
    submitForm() {
      this.$emit('submit', this.formData); // 부모 컴포넌트로 데이터 전달
      this.formData = { name: '', bestBefore: '' }; // 폼 초기화
    },
  },
};
</script>

<style>
.popup-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}
.popup {
  background: white;
  padding: 20px;
  border-radius: 8px;
  width: 300px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}
.button{
  padding: 10px 20px;         /* 버튼에 여백을 추가 */
  border-radius: 50px;        /* 버튼을 둥글게 */
}
.button:hover{
  background-color: skyblue;
}

</style>
