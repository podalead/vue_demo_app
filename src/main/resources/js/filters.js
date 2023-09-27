import moment from 'moment';

// Global filters
const globalFilters = {
    dateNormalizer(value) {
        return value ? moment(String(value)).format('MM/DD/YYYY hh:mm:ss') : null;
    },
    capitalCase(value) {
        return value.charAt(0) + value.substring(1).toLowerCase();
    },
    cutMessageLength(value) {
        return value.length > 200 ? `${value.substring(0, 197)}...` : value;
    },
    length(value) {
        return value.length;
    }
}

export default globalFilters;
