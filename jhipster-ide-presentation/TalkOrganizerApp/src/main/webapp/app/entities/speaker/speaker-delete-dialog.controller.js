(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('SpeakerDeleteController',SpeakerDeleteController);

    SpeakerDeleteController.$inject = ['$uibModalInstance', 'entity', 'Speaker'];

    function SpeakerDeleteController($uibModalInstance, entity, Speaker) {
        var vm = this;

        vm.speaker = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Speaker.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
