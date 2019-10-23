'use strict'
var demoApp = angular.module('converter', ['ui.bootstrap', 'converter.controllers',
    'converter.services'
]);
demoApp.constant("CONSTANTS", {
    convertNumber: "/converter/"
});