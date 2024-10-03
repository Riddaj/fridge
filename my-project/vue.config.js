const { defineConfig } = require('@vue/cli-service');
const path = require('path');
const webpack = require('webpack');
const ESLintPlugin = require('eslint-webpack-plugin');

module.exports = defineConfig({
  transpileDependencies: true,

  // npm run build 타겟 디렉토리 -> 해당 경로에 vue 빌드 출력물 생성됨
  outputDir: path.resolve(__dirname, './backend/fridgeManager/src/main/resources/static'),

  // 개발 서버 설정
  devServer: {
    port: 8080,
    proxy: {
      '/api': {
        target: 'http://localhost:8081',
        changeOrigin: true,
        pathRewrite: { '^/api': '' }
      }
    }
  },

  // 빌드 결과물의 경로 설정
  publicPath: '/',

  // webpack 설정
  configureWebpack: {
    resolve: {
      alias: {
        '@': path.join(__dirname, 'src/'),
        '@spring': path.join(__dirname, './backend/fridgeManager/src/main/resources/static')
      }
    },
    plugins: [
      new webpack.DefinePlugin({
        __VUE_PROD_HYDRATION_MISMATCH_DETAILS__: false
      }),
       // 241001 ESLintPlugin 주석 처리
      //new ESLintPlugin()
    ]
  }
});



