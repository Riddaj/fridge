import axios from 'axios';

// Spring Boot 서버의 주소를 설정합니다.
const API_URL = 'http://localhost:8081/api';

// axios 인스턴스 생성
const api = axios.create({
    baseURL: API_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

// API 요청 메서드 예제
export const getHello = () => api.get('/hello');
// export function getHello() {
//     return axios.get('http://localhost:8081/api/hello')
//     .then(response => {
//         console.log('API response:', response);
//         return response;
//       })
//       .catch(error => {
//         console.error('Error calling API:', error);
//       });
//   }
  
