'use strict';

describe('Controller Tests', function() {

    describe('Conference Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockConference, MockLocation, MockTalk;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockConference = jasmine.createSpy('MockConference');
            MockLocation = jasmine.createSpy('MockLocation');
            MockTalk = jasmine.createSpy('MockTalk');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Conference': MockConference,
                'Location': MockLocation,
                'Talk': MockTalk
            };
            createController = function() {
                $injector.get('$controller')("ConferenceDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'talkOrganizerApp:conferenceUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
