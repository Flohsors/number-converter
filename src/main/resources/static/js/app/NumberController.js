'use strict'
angular.module('converter.services', []).factory('NumberController', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.saveUser = function(convertibleNumber) {
        return $http.post(CONSTANTS.convertNumber, convertibleNumber);
    }
    return service;
}]);