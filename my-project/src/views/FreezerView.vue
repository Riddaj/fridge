<template>
      <!-- 0104 카테고리ID 추가 -->
      <div class="app">
      <ul v-for="(group, categoryId) in groupedIngredients" :key="categoryId" class="category">
        <li>
          <strong>{{ group.categoryName }} ({{ group.items.length }})</strong>
        </li>
        <hr style="border:solid 0.2px black; margin: 20px auto;">
        <div class="card">
        <div class="card-body" v-for="ingredient in group.items" :key="ingredient.ingredientId">
          <div class="foodName">{{ ingredient.name }}</div>
          <div class="bestBefore">{{ ingredient.bestBefore }}</div>
        </div>
      </div>
      </ul>
    </div>
    <!-- <div class="app">
      <ul class="category" v-for="ingredient in ingredients" :key="ingredient.ingredientId">
        {{ ingredient.category.categoryName }} ()
        <hr style="border:solid 0.2px black; margin: 20px auto;">
        <div class="card">
          <div class="card-body" v-for="ingredient in ingredients" :key="ingredient.ingredientId" >
            <p class="foodName"> {{ ingredient.name }}</p>
          </div>
        </div>
      </ul>
  </div> -->
</template>
  
  <script>
  export default {
    data() {
      return {
        ingredients: [],
        groupedIngredients: {}  // 그룹화된 데이터를 저장할 변수
      };
    },
      mounted() {
      fetch('http://localhost:8081/api/freezer')  // 백엔드의 URL로 직접 요청
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then(data => {
          console.log("Fetched data:", data);  // 응답 데이터 확인
          this.ingredients = data;  // 데이터 할당

          // 데이터를 카테고리별로 그룹화하여 groupedIngredients에 할당
         this.groupedIngredients = this.groupIngredientsByCategory(data);
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        });
    }, methods: {
    // 카테고리별로 그룹화하는 메서드
    groupIngredientsByCategory(data) {
      const grouped = {};

      // 데이터 순회하며 카테고리별로 그룹화
      data.forEach(item => {
        const categoryId = item.category.categoryId;
        
        // 해당 카테고리 아이디가 없다면 새로 추가
        if (!grouped[categoryId]) {
          grouped[categoryId] = {
            categoryName: item.category.categoryName,
            items: []
          };
        }

        // 각 항목을 해당 카테고리에 추가
        grouped[categoryId].items.push({
          ingredientId: item.ingredientId,
          name: item.name,
          bestBefore: item.bestBefore
        });
      });

      return grouped;
    }
  }
  
  };
  
  </script>

<style>
  .app{
    font-family: "Nanum Gothic Coding", monospace;
    font-size: 10pt;
    background-color: #F0F8FF;
    height: 100%;
    display: flex;
    flex-direction: column;
  }

  .category{
    font-size: 10px;
    font-weight: bold;
  }

  .card{
    display: flex; /* 가로로 쌓이도록 설정 */
    flex-wrap: wrap;
    gap: 10px; /* 항목 사이 간격 */
    margin: 20px; /* 바깥쪽 여백을 20px로 설정 */
    padding: 10px; /* 내부 여백을 10px로 설정 */
  }

  .card-body{
    border: 1px solid skyblue;
    margin-right: 10px; /* 각 항목 사이 간격 */
    margin-bottom: 10px;
    font-size: 10px;

    width: 150px; /* 각 항목의 고정 너비 */
    height: 100px; /* 각 항목의 고정 높이 */
    background-color: #f0f0f0; /* 배경색을 추가하여 보기 쉽게 */
    display: flex;
    justify-content: center; /* 항목을 가로 중앙 정렬 */
    align-items: center; /* 항목을 세로 중앙 정렬 */
    border-radius: 5px; /* 테두리 둥글게 */

    display: flex;
    flex-direction: column; /* 세로 정렬 */
    align-items: flex-start; /* 왼쪽 정렬 (필요에 따라 center로 변경 가능) */
    gap: 8px; /* 항목 간 간격 */
  }
</style>