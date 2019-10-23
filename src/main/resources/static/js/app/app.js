'use strict'
var converterApp = angular.module('converter', ['ui.bootstrap', 'converter.controllers',
    'converter.services'
]);
converterApp.constant("CONSTANTS", {
    convertNumber: "/converter/convertNumber"
});