<template>
      <ul>
      <li v-for="ingredient in ingredients" :key="ingredient.ingredientId">
        {{ ingredient.name }} - {{ ingredient.bestBefore }}  <!-- 원하는 데이터 표시 -->
      </li>
    </ul>

</template>

<script>
export default {
  data() {
    return {
      ingredients: []
    };
  },
  mounted() {
    fetch('/api/fridge')  // 프록시 설정에 따라 경로 수정
      .then(response => response.json())
      .then(data => {
        console.log("Fetched data:", data);  // 응답 데이터 확인
        this.ingredients = data;  // 데이터 할당
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }
}

</script>

<style scoped>

</style>