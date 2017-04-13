(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('TalkDialogController', TalkDialogController);

    TalkDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Talk', 'Speaker', 'Conference'];

    function TalkDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Talk, Speaker, Conference) {
        var vm = this;

        vm.talk = entity;
        vm.clear = clear;
        vm.save = save;
        vm.speakers = Speaker.query();
        vm.conferences = Conference.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.talk.id !== null) {
                Talk.update(vm.talk, onSaveSuccess, onSaveError);
            } else {
                Talk.save(vm.talk, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('talkOrganizerApp:talkUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
