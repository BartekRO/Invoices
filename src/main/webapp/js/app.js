'use strict';

var invoices = angular.module('invoices', [ 'ngRoute' ]).config(function($routeProvider, $httpProvider) {
			$routeProvider.when('/invoiceList', {
				templateUrl : 'template/invoiceList.html',
				controller : 'InvoiceListController'
			});
			$routeProvider.when('/addInvoice', {
				templateUrl : 'template/addInvoice.html',
				controller : 'AddInvoiceController'
			});
			$routeProvider.otherwise({
				redirectTo : '/invoiceList'
			});

			$httpProvider.interceptors.push(function ($q, $rootScope, $location) {
			        return {
			        	'responseError': function(rejection) {
			        		var status = rejection.status;
			        		var config = rejection.config;
			        		var method = config.method;
			        		var url = config.url;
			      
			        		if (status == 401) {
			        			$location.path( "/login" );
			        		} else {
			        			$rootScope.error = method + " on " + url + " failed with status " + status;
			        		}
			              
			        		return $q.reject(rejection);
			        	}
			        };
			    }
		    );
		});
