import Vue from 'vue';
import VueResource from 'vue-resource';
import './filters';

import App from "./pages/App.vue";

Vue.use(VueResource);

new Vue({
    el: '#app',
    render: h => h(App)
});