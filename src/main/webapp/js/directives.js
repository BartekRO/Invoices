'use strict';

invoices.directive('loadingContainer', function () {
    return {
        restrict: 'A',
        scope: false,
        link: function(scope, element, attrs) {
            var loadingLayer = angular.element('<div class="loading"></div>');
            element.append(loadingLayer);
            element.addClass('loading-container');
            scope.$watch(attrs.loadingContainer, function(value) {
                loadingLayer.toggleClass('ng-hide', !value);
            });
        }
    };
}); 

invoices.directive('dateConverter', function($filter){
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function(scope, element, attrs, ngModelController) {
            ngModelController.$parsers.push(function(data) {
              //convert data from view format to model format
              var date = Date.parse(data);
              return isNaN(date) ? '' : date;
            });

            ngModelController.$formatters.push(function(data) {
              //convert data from model format to view format
              return $filter('date')(data, 'yyyy-MM-dd'); //converted
            });
        }
    };
});