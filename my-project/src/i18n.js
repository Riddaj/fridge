import { createI18n } from 'vue-i18n'; // Vue 3에서 사용하는 createI18n을 import 

// json 파일을 읽어들이기 위한 function
const requireLang = require.context(
  '@/locales',    // 폴더명
  true,
  /\.json$/       // 폴더 아래 json 찾기용
);

const messages = {};

// json file read
for (const file of requireLang.keys()) {
  const path = file.replace(/(\.\/|\.json$)/g, '').split('/');  // 폴더 패스

  path.reduce((o, s, i) => {
    if (o[s]) return o[s];

    o[s] = i + 1 === path.length
      ? requireLang(file)
      : {};

    return o[s];
  }, messages);
}

// Vue 3에서 사용하는 i18n 인스턴스를 생성
const i18n = createI18n({
  locale: 'kr', // 기본 locale
  fallbackLocale: 'kr', // locale 설정 실패시 사용할 locale
  messages, // 다국어 메시지
  silentTranslationWarn: true // 메시지 코드가 없을 때 나오는 console 경고 off
});

export default i18n;


/* vue 2 버전 소스라 에러남  */

// import Vue from 'vue'
// import VueI18n from 'vue-i18n'

// // json 파일을 읽어들이기 위한 function
// const requireLang = require.context(
//   '@/locales',    // 폴더명 입니다.
//   true,
//   /\.json$/       // 폴더 아래 json 찾기용
// )

// const messages = {}

// // json file read
// for (const file of requireLang.keys()) {
//   const path = file.replace(/(\.\/|\.json$)/g, '').split('/')  // 폴더 패스

//   path.reduce((o, s, i) => {
//     if (o[s]) return o[s]

//     o[s] = i + 1 === path.length
//       ? requireLang(file)
//       : {}

//     return o[s]
//   }, messages)

// }

// Vue.use(VueI18n);

// const i18n = new VueI18n({
//   locale: 'ko', // 기본 locale
//   fallbackLocale: 'ko', // locale 설정 실패시 사용할 locale
//   messages, // 다국어 메시지
//   silentTranslationWarn: true // 메시지 코드가 없을때 나오는 console 경고 off
// })

// export default i18n