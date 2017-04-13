'use strict';

describe('Controller Tests', function() {

    describe('Talk Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockTalk, MockSpeaker, MockConference;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockTalk = jasmine.createSpy('MockTalk');
            MockSpeaker = jasmine.createSpy('MockSpeaker');
            MockConference = jasmine.createSpy('MockConference');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Talk': MockTalk,
                'Speaker': MockSpeaker,
                'Conference': MockConference
            };
            createController = function() {
                $injector.get('$controller')("TalkDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'talkOrganizerApp:talkUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
