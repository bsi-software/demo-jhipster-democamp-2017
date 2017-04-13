(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('SpeakerDialogController', SpeakerDialogController);

    SpeakerDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Speaker', 'Talk'];

    function SpeakerDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Speaker, Talk) {
        var vm = this;

        vm.speaker = entity;
        vm.clear = clear;
        vm.save = save;
        vm.talks = Talk.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.speaker.id !== null) {
                Speaker.update(vm.speaker, onSaveSuccess, onSaveError);
            } else {
                Speaker.save(vm.speaker, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('talkOrganizerApp:speakerUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
