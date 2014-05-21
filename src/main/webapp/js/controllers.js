'use strict';

/* Controllers */

invoices.controller('InvoiceListController',  function InvoiceListController($scope, invoicesService, $route) {
	invoicesService.getInvoices().then(
		function(invoices) {$scope.invoices = invoices;},
		function(statusCode) {console.log(statusCode);}
	);
	
	$scope.removeInvoice = function(invioceId) {
		invoicesService.removeInvoice(invioceId).then(
				function(data) {$route.reload();},
				function(statusCode) {console.log(statusCode);}
			);
	};
});


invoices.controller('AddInvoiceController',  function AddInvoiceController($scope, invoicesService) {
	
	$scope.addInvoice = function(invioce) {
		invoicesService.addInvoice(invioce).then(
				function(data) {window.location = "#/invoiceList";},
				function(statusCode) {console.log(statusCode);}
			);
	};
	$scope.cancel = function() {window.location = "#/invoiceList";};
});

invoices.controller('LoginController',  function AddInvoiceController($rootScope, $scope, $cookieStore, $location, securityService) {
	
	$scope.login = function(invioce) {
		$scope.loginError = null;
		securityService.authenticate($scope.username, $scope.password).then(
				function(userWithToken) {
					var authenticationToken = userWithToken.token;
					$rootScope.authenticationToken = authenticationToken;
					if ($scope.rememberMe) {
						$cookieStore.put('authenticationToken', authenticationToken);
					}
					$rootScope.user = userWithToken.user;
					$location.path("/Invoices");
				},
				function(errorData, statusCode) {
						$scope.loginError = errorData.message;
					}
			);
	};
});

