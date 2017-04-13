(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('ConferenceDeleteController',ConferenceDeleteController);

    ConferenceDeleteController.$inject = ['$uibModalInstance', 'entity', 'Conference'];

    function ConferenceDeleteController($uibModalInstance, entity, Conference) {
        var vm = this;

        vm.conference = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Conference.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
