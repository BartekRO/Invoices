'use strict';

/* Controllers */

invoices.controller('InvoiceListController',  function InvoiceListController($scope, invoicesService, $route, ngTableParams) {
	
	$scope.tableParams = new ngTableParams({
        page: 1,            // show first page
        count: 10,          // count per page
        sorting: {
            name: 'asc'     // initial sorting
        }
    }, {
        total: 0,           // length of data
        getData: function($defer, params) {
                   
        	invoicesService.getInvoices(params.$params.page, params.$params.count).then(
        			function(data) {
        				params.total(data.total); 
        				$defer.resolve(data.records);
        			},
        			function(statusCode) {console.log(statusCode);}
        		);
        }
    }); 
	
	
	
	$scope.removeInvoice = function(invioceId) {
		invoicesService.removeInvoice(invioceId).then(
				function(data) {$route.reload();},
				function(errorData, statusCode) {
					console.log(statusCode);
				}
			);
	};
	
	
});





invoices.controller('AddInvoiceController',  function AddInvoiceController($scope, invoicesService, contractorsService) {
	
	 $scope.lovTitle = "Search for Employees";
     $scope.lovColumnList = ["Name"];
     $scope.lovFieldList = ["name"];
	
     $scope.lovCallBack = function (e) {

		if (typeof $scope.invoice === 'undefined') {
			$scope.invoice = {};
		}
        $scope.invoice.contractor = e;
        $scope.newInvoiceForm.contractor.$setValidity('editable', true);
     };
	
	contractorsService.getContractors().then(
		function(contractors) {
			$scope.contractors = contractors;
			},
		function(statusCode) {console.log(statusCode);}
	);
	
	$scope.addInvoice = function(invoice,newInvoiceForm) {
		
		if (newInvoiceForm.$valid) {
			
			alert($scope.dupa);
			
//			invoice.totalAmount = parseFloat(invoice.totalAmount.replace(",", "."), 10.00);
//			
//			invoicesService.addInvoice(invoice).then(
//					function(data) {window.location = "#/invoiceList";},
//					function(statusCode) {console.log(statusCode);}
//				);
		}
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
					$cookieStore.put('authenticationToken', authenticationToken);
					$rootScope.user = userWithToken.user;
					$location.path("/Invoices");
				},
				function(errorData, statusCode) {
						$scope.loginError = errorData.message;
					}
			);
	};
	
});

