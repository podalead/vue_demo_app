import Vue from "vue";
import moment from 'moment';

// Global filters
Vue.filter('dateNormalizer', function (value) {
    return value ? moment(String(value)).format('MM/DD/YYYY hh:mm:ss') : null;
});

Vue.filter('capitalCase', function (value) {
    return value.charAt(0) + value.substring(1).toLowerCase();
});

Vue.filter('length', function (value) {
    return value.length;
});