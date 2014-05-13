'use strict';

var invoices = angular.module('invoices', [ 'ngRoute' ]).config(function($routeProvider) {
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
		});
