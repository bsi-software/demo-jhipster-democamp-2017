(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('speaker', {
            parent: 'entity',
            url: '/speaker',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'talkOrganizerApp.speaker.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/speaker/speakers.html',
                    controller: 'SpeakerController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('speaker');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('speaker-detail', {
            parent: 'speaker',
            url: '/speaker/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'talkOrganizerApp.speaker.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/speaker/speaker-detail.html',
                    controller: 'SpeakerDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('speaker');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Speaker', function($stateParams, Speaker) {
                    return Speaker.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'speaker',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('speaker-detail.edit', {
            parent: 'speaker-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/speaker/speaker-dialog.html',
                    controller: 'SpeakerDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Speaker', function(Speaker) {
                            return Speaker.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('speaker.new', {
            parent: 'speaker',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/speaker/speaker-dialog.html',
                    controller: 'SpeakerDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                firstName: null,
                                lastName: null,
                                email: null,
                                phoneNumber: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('speaker', null, { reload: 'speaker' });
                }, function() {
                    $state.go('speaker');
                });
            }]
        })
        .state('speaker.edit', {
            parent: 'speaker',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/speaker/speaker-dialog.html',
                    controller: 'SpeakerDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Speaker', function(Speaker) {
                            return Speaker.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('speaker', null, { reload: 'speaker' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('speaker.delete', {
            parent: 'speaker',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/speaker/speaker-delete-dialog.html',
                    controller: 'SpeakerDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Speaker', function(Speaker) {
                            return Speaker.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('speaker', null, { reload: 'speaker' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
