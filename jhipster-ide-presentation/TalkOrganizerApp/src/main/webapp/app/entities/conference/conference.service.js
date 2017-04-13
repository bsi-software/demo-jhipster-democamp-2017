(function() {
    'use strict';
    angular
        .module('talkOrganizerApp')
        .factory('Conference', Conference);

    Conference.$inject = ['$resource', 'DateUtils'];

    function Conference ($resource, DateUtils) {
        var resourceUrl =  'api/conferences/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.date = DateUtils.convertDateTimeFromServer(data.date);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
