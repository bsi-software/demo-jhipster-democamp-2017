(function() {
    'use strict';
    angular
        .module('talkOrganizerApp')
        .factory('Talk', Talk);

    Talk.$inject = ['$resource'];

    function Talk ($resource) {
        var resourceUrl =  'api/talks/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
