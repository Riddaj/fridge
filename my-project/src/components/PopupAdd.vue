<template>
  <div v-if="isVisible" class="popup-overlay">
    <div class="popup">
      <p>{{ $t('message.Add Ingredients') }}</p>
      <form @submit.prevent="submitForm">
        <div>
          <label for="name">Ingredient Name:</label>
          <input type="text" v-model="formData.name" required />
        </div>
        <div>
          <label>저장공간</label>
          <select id="storage" v-model="formData.storage" required>
            <option disabled value="">Please select a storage</option>
            <option value="fridge">{{ $t('message.fridge') }}</option>
            <option value="freezer">{{ $t('message.freezer') }}</option>
            <option value="pantry">{{ $t('message.pantry') }}</option>
          </select>
        </div>
        <div>
          <label for="bestBefore">{{$t('message.Best Before')}}</label>
          <input type="date" v-model="formData.bestBefore" required />
        </div>
        <div>
          <label for="category">카테고리</label>
          <select id="category" v-model="formData.category" required>
            <option disabled value="">Please select a category</option>
            <option value="A0000">육류</option>
            <option value="B0000">채소</option>
            <option value="C0000">유제품</option>
            <option value="D0000">과일</option>
            <option value="E0000">인스턴트</option>
            <option value="F0000">냉동식품</option>
            <option value="G0000">기타</option>
          </select>
        </div>
        <div>
          <label for="brand">{{$t('message.brand')}}</label>
          <input type="text" v-model="formData.brand" required />
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
        storage: '',
        category: '',
        brand: ''
      },
    };
  },
  methods: {
    
    submitForm() {
      // 제출 시 폼 데이터 출력
      console.log('#### Form Data ###### :', this.formData);
      this.$emit('submit', this.formData); // 부모 컴포넌트로 데이터 전달
      
    },
  },
};
</script>

<style>
.popup-overlay {
  font-family: "Nanum Gothic Coding", monospace;
  font-size: 10pt;
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
