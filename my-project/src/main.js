import { createApp } from 'vue';
import App from './App.vue';
import router from './router'; // 라우터 가져오기
import i18n from './i18n' //다국어설정 

// Vue 3 애플리케이션 생성
const app = createApp(App);

// 플러그인 등록
app.use(router);
app.use(i18n);

// 애플리케이션 마운트
app.mount('#app');


// createApp(App)
//   .use(router) // 라우터를 애플리케이션에 등록
//   .mount('#app');

// // Vue 3에서는 .use()를 사용하여 플러그인을 등록
// app.use(router);
// app.use(i18n);

// // #app 엘리먼트에 애플리케이션을 마운트
// app.mount('#app');




/* vue2 버전이라 에러남 */
// Vue.config.productionTip = false

// new Vue({
//   i18n,
//   render: h => h(App),
//   data: {
//     foo:"test"
//   }
// }).$mount('#app')

/*
import { createApp } from 'vue';
import App from './App.vue';
import router from './router'; // 라우터를 가져오기

createApp(App)
  .use(router) // 라우터를 애플리케이션에 등록
  .mount('#app');

------

import { createApp } from 'vue'
import App from './App.vue'


createApp(App).mount('#app')
*/