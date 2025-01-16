<template>
  <div id="app">
    <!-- Header -->
    <header class="header">
      <img src="@/assets/fridge.png" alt="Logo" class="logo" />
      <div class="icons">
        <!-- 다국어설정 -->
        <!-- <p>{{ $t('message.fridge') }}</p> -->
        <select v-model="selectedLocale" v-on:change="changeLocale">
          <option value="kr" selected>한국어</option>
          <option value="en">ENGLISH</option>
        </select>
        <div class="member">
          <button class="button" type="login">로그인</button>
          <button class="button" type="singin">회원가입</button>
        </div>

      </div>
    </header>

    <!-- Tabs -->
    <nav class="tabs">
      <router-link to="/fridge" class="tab">
        <img src="@/assets/fridgeMenu.png" alt="fridgeMenu" class="menu"/>
        <p>{{ $t('message.fridge') }}</p>
      </router-link>
      <router-link to="/freezer" class="tab">
        <img src="@/assets/freezer.png" alt="freezer" class="menu"/>
        <p>{{ $t('message.freezer') }}</p>
      </router-link>
      <router-link to="/pantry" class="tab">
        <img src="@/assets/pantry.png" alt="pantry" class="menu"/>
        <p>{{ $t('message.pantry') }}</p>
      </router-link>
      <!-- <div class="goCart">
          <a @click.prevent="goToCart">          
            <img src="@/assets/cart.png" alt="cart" class="cart"/>
          </a>
      </div>  -->
      <router-link to="/cart" class="tab">
        <img src="@/assets/cart.png" alt="cart" class="menu"/>
        <p>{{ $t('message.cart') }}</p>
      </router-link>
    </nav>

    <!-- Main Content -->
    <router-view></router-view> <!-- 여기에 기본적으로 FridgeView가 표시됩니다 -->
      <!--식재료 추가 팝업 버튼-->
      <div>
          <a @click="openPopup" class="popupAdd">
            <img src="@/assets/add.png" alt="add" class="add"/>재료 추가하기
          </a>
              <!-- 팝업 컴포넌트 -->
        <PopupAdd :isVisible="isPopupVisible" @close="closePopup" @submit="handleSubmit" />
      </div>
  </div>
</template>

<script>
import { ref, computed } from 'vue';
import FridgeView from '@/views/FridgeView.vue';
import FreezerView from './views/FreezerView.vue';
import PantryView from './views/PantryView.vue';
import PopupAdd from '@/components/PopupAdd.vue';
import { useI18n } from 'vue-i18n'

export default {
  name: 'App',
  views: {
    FridgeView,
    FreezerView,
    PantryView,

  }, components: {
    PopupAdd,
  },
  data() {
    return {
      isPopupVisible: false,
    };
  },

  methods: {
      goToCart() {
      this.$router.push('/cart'); // '/cart' 경로로 페이지 전환
      },
      //재료 추가 팝업
      openPopup() {
        this.isPopupVisible = true;
      },
      closePopup() {
        this.isPopupVisible = false;
      },
      handleSubmit(newIngredient) {
        // DB로 정보 전송
        console.log("보여라보여라");
        console.log("Submitted data:", newIngredient);
        fetch('http://localhost:8081/api/addIngredient', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(newIngredient),
        })
          .then(response => response.json())
          .then(data => {
            console.log('Ingredient added:', data);
          })
          .catch(error => {
            console.error('Error adding ingredient:', error);
          });
        this.closePopup(); // 팝업 닫기
      },
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

#app{
  font-family: "Nanum Gothic Coding", monospace;
  font-size: 10pt;
  background-color: #F0F8FF;
  height: 100%;
  display: flex;
  flex-direction: column;
}


/* router-view가 나머지 공간을 차지하도록 설정 */
router-view {
  flex-grow: 1;
  overflow-y: auto; /* 내용이 넘칠 경우 스크롤 가능 */
}

.header {
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.add{
  height: 25px;
  cursor: pointer;
}

.popupAdd{
  position: fixed; /* 화면에 고정 */
  bottom: 20px;    /* 화면 아래에서 20px */
  right: 20px;     /* 화면 오른쪽에서 20px */
  padding: 10px 20px;         /* 버튼에 여백을 추가 */
  border-radius: 50px;        /* 버튼을 둥글게 */
  color: white;               /* 텍스트 색상 */
  background-color: skyblue;
  text-decoration: none;      /* 링크 스타일 제거 */
  display: flex;
  align-items: center;        /* 아이콘과 텍스트가 수평 정렬되도록 */
  justify-content: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 그림자 효과 */
}

.popupAdd:hover{
  background-color: #ff784e; /* 마우스를 올렸을 때 배경 색상 */
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

.goCart{
  margin-left: 30px;
}

button{
  border: none;
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