(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('ConferenceDetailController', ConferenceDetailController);

    ConferenceDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Conference', 'Location', 'Talk'];

    function ConferenceDetailController($scope, $rootScope, $stateParams, previousState, entity, Conference, Location, Talk) {
        var vm = this;

        vm.conference = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('talkOrganizerApp:conferenceUpdate', function(event, result) {
            vm.conference = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
