<template>
  <div class="fridge-page">
    <div class="ingredient-list">
      <div v-for="ingredient in ingredients" :key="ingredient.id" class="ingredient-card">
        <h3>{{ ingredient.name }}</h3>
        <p>Category: {{ ingredient.category }}</p>
        <p>Quantity: {{ ingredient.quantity }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ingredients: [
        { id: 1, name: 'Chicken Breast', category: 'Meat', quantity: '2 pieces' },
        { id: 2, name: 'Lettuce', category: 'Vegetable', quantity: '1 head' },
        { id: 3, name: 'Milk', category: 'Dairy', quantity: '1 liter' },
        // 추가 재료는 여기서 정의
      ],
    };
  },
};
</script>

<style scoped>
.fridge-page {
  padding: 20px;
  text-align: center;
  font-family: "Dongle", sans-serif;
}

.ingredient-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}

.ingredient-card {
  background-color: #f5f5f5;
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 20px;
  width: 200px;
  text-align: left;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.ingredient-card h3 {
  margin: 0;
  font-size: 18px;
}

.ingredient-card p {
  margin: 5px 0;
  font-size: 14px;
}
</style>