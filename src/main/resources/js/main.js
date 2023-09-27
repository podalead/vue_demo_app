import {createApp} from 'vue';
import globalFilters from './filters';

import App from "./pages/App.vue";

const app = createApp(App);

app.config.globalProperties.$filters = globalFilters;

app.mount('#app');
