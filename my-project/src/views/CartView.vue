<template>
    <div>
      <div class="ingredients">
        <button
          v-for="item in items"
          :key="item.id"
          @click="addToCart(item)"
          class="ingredient-item"
        >
          {{ item.name }}
        </button>
      </div>
      <div class="cart">
        <h2>장바구니</h2>
        <ul>
          <li v-for="item in cart" :key="item.id">{{ item.name }}</li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    setup() {
      // 재료 목록
      const items = ref([
        { id: 1, name: '토마토' },
        { id: 2, name: '양파' },
        { id: 3, name: '당근' },
        { id: 4, name: '감자' }
      ]);
  
      // 장바구니
      const cart = ref([]);
  
      // 장바구니에 재료 추가
      const addToCart = (item) => {
        if (!cart.value.find(i => i.id === item.id)) {
          cart.value.push(item);
        }
      };
  
      return {
        items,
        cart,
        addToCart
      };
    }
  };
  </script>
  
  <style>
  .ingredients {
    display: flex;
    flex-wrap: wrap;
  }
  
  .ingredient-item {
    margin: 5px;
    padding: 10px;
    border: 1px solid #ddd;
    cursor: pointer;
  }
  
  .cart {
    margin-top: 20px;
  }
  </style>
  