(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('SpeakerDetailController', SpeakerDetailController);

    SpeakerDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Speaker', 'Talk'];

    function SpeakerDetailController($scope, $rootScope, $stateParams, previousState, entity, Speaker, Talk) {
        var vm = this;

        vm.speaker = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('talkOrganizerApp:speakerUpdate', function(event, result) {
            vm.speaker = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
