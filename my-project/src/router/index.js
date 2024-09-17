import { createRouter, createWebHistory } from 'vue-router';
import Fridge from '@/views/FridgeView.vue';
import Freezer from '@/views/FreezerView.vue';
import Pantry from '@/views/PantryView.vue';
import Cart from '@/views/CartView.vue';
import Add from '@/views/AddView.vue';


const routes = [
  {
    path: '/fridge',
    name: 'Fridge',
    component: Fridge
  },
  {
    path: '/freezer',
    name: 'Freezer',
    component: Freezer
  },
  {
    path: '/pantry',
    name: 'Pantry',
    component: Pantry
  },
  {
    path: '/cart',
    name: 'Cart',
    component: Cart
  },
  {
    path: '/add',
    name: 'Add',
    component: Add
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;