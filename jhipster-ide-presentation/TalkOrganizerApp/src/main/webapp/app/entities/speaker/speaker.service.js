(function() {
    'use strict';
    angular
        .module('talkOrganizerApp')
        .factory('Speaker', Speaker);

    Speaker.$inject = ['$resource'];

    function Speaker ($resource) {
        var resourceUrl =  'api/speakers/:id';

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
