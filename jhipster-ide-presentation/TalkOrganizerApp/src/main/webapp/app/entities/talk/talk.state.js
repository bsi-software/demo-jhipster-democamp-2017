(function() {
    'use strict';

    angular
        .module('talkOrganizerApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('talk', {
            parent: 'entity',
            url: '/talk',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'talkOrganizerApp.talk.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/talk/talks.html',
                    controller: 'TalkController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('talk');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('talk-detail', {
            parent: 'talk',
            url: '/talk/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'talkOrganizerApp.talk.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/talk/talk-detail.html',
                    controller: 'TalkDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('talk');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Talk', function($stateParams, Talk) {
                    return Talk.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'talk',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('talk-detail.edit', {
            parent: 'talk-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/talk/talk-dialog.html',
                    controller: 'TalkDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Talk', function(Talk) {
                            return Talk.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('talk.new', {
            parent: 'talk',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/talk/talk-dialog.html',
                    controller: 'TalkDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                title: null,
                                description: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('talk', null, { reload: 'talk' });
                }, function() {
                    $state.go('talk');
                });
            }]
        })
        .state('talk.edit', {
            parent: 'talk',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/talk/talk-dialog.html',
                    controller: 'TalkDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Talk', function(Talk) {
                            return Talk.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('talk', null, { reload: 'talk' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('talk.delete', {
            parent: 'talk',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/talk/talk-delete-dialog.html',
                    controller: 'TalkDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Talk', function(Talk) {
                            return Talk.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('talk', null, { reload: 'talk' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
