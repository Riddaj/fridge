<template>
    <div>
      <button @click="fetchHello">Fetch Hello</button>
      <h1>이게 나와야 된다고옥</h1>
      <p>{{ message }}</p>
    </div>
  </template>
  
  <script>
  import { getHello } from '../api'; // api.js에서 설정한 함수 import
  
  export default {
    name: 'ExComponent', // 이름 설정
    data() {
      return {
        message: '',
      };
    },
    methods: {
      async fetchHello() {
        try {
          const response = await getHello();
          console.log('아 좀 되라!!');
          console.log('Response data:', response.data); // API 응답 데이터 확인
          
          this.message = response.data;
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      },
    },
    mounted() {
      console.log('Component mounted');
    },
  };
  </script>
  