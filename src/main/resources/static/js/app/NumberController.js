'use strict'
var module = angular.module('converter.controllers', []);
module.controller("NumberController", ["$scope", "NumberService",
    function($scope, NumberService) {
        $scope.convertibleNumber = {
            inputNumber: null,
            numberType: null
        };
        $scope.convertNumber = function() {
            NumberService.convertNumber($scope.convertibleNumber).then(function() {
                console.log("works");
                $scope.skills = [];
                $scope.convertibleNumber = {
                    inputNumber: null,
                    numberType: null
                };
            }, function(reason) {
                console.log("error occurred");
            }, function(value) {
                console.log("no callback");
            });
        }
    }
]);