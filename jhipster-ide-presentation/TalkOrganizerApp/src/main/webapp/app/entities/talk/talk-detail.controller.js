(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('TalkDetailController', TalkDetailController);

    TalkDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Talk', 'Speaker', 'Conference'];

    function TalkDetailController($scope, $rootScope, $stateParams, previousState, entity, Talk, Speaker, Conference) {
        var vm = this;

        vm.talk = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('talkOrganizerApp:talkUpdate', function(event, result) {
            vm.talk = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
