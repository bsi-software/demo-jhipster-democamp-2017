(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .controller('TalkDeleteController',TalkDeleteController);

    TalkDeleteController.$inject = ['$uibModalInstance', 'entity', 'Talk'];

    function TalkDeleteController($uibModalInstance, entity, Talk) {
        var vm = this;

        vm.talk = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Talk.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
