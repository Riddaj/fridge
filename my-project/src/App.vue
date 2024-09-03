<template>
  <div id="app">
    <!-- Header -->
    <header class="header">
      <img src="@/assets/fridge.png" alt="Logo" class="logo" />
      <div class="icons">
        <!-- 다국어설정 -->
        <p>{{ $t('message.fridge') }}</p>
        <select v-model="selectedLocale" v-on:change="changeLocale">
            <option value="" disabled>선택하세요</option>
            <option value="kr">한국어</option>
            <option value="en">영어</option>
        </select>
        <!-- shopping cart list-->
        <a @click="goToCart">          
          <img src="@/assets/cart.png" alt="cart" class="cart"/>
        </a>
      </div>
    </header>

    <!-- Tabs -->
    <nav class="tabs">
      <router-link to="/fridge" class="tab"><img src="@/assets/fridgeMenu.png" alt="fridgeMenu" class="menu"/></router-link>
      <router-link to="/freezer" class="tab"><img src="@/assets/freezer.png" alt="freezer" class="menu"/></router-link>
      <router-link to="/pantry" class="tab"><img src="@/assets/pantry.png" alt="pantry" class="menu"/></router-link>
    </nav>

    <!-- Main Content -->
    <router-view></router-view>
  </div>
</template>

<script>
import { ref, computed } from 'vue';
import FridgeView from '@/views/FridgeView.vue';
import FreezerView from './views/FreezerView.vue';
import PantryView from './views/PantryView.vue';
import { useI18n } from 'vue-i18n'

export default {
  name: 'App',
  views: {
    FridgeView,

  },

  methods: {
    goToCart() {
      this.$router.push('/cart'); // '/cart' 경로로 페이지 전환
      }
    },

    setup() {
    const { locale } = useI18n(); // useI18n을 사용하여 locale에 접근
    const selectedLocale = ref(locale.value); // ref로 locale 값을 감싸줍니다

    const changeLocale = (event) => {
      const newLocale = event.target.value;
      selectedLocale.value = newLocale;
      locale.value = newLocale; // i18n locale을 업데이트 
    };

    return {
      selectedLocale,
      changeLocale
    };
  }



}


</script>

<style scoped>
/* 기본 스타일 추가 */
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.cart{
  height: 25px;
}

.search{
  height: 25px;
}

.logo {
  height: 40px;
}

.menu {
  height: 40px;
}
.icons i {
  margin-left: 20px;
  font-size: 1.5em;
  cursor: pointer;
}

.tabs {
  display: flex;
  justify-content: space-around;
  padding: 10px 0;
}

.tab {
  flex: 1;
  text-align: center;
  padding: 10px;
  color: #333;
  text-decoration: none;
}

.tab.router-link-exact-active {
  font-weight: bold;
}
</style>