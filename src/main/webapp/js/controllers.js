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





invoices.controller('AddInvoiceController',  function AddInvoiceController($scope, $filter, invoicesService, contractorsService, taxRatesService, ngTableParams) {
	
	 $scope.lovTitle = "Search for Employees";
     $scope.lovColumnList = ["Name"];
     $scope.lovFieldList = ["name"];
     
     $scope.tableParams = new ngTableParams({
         page: 1, 
         count: 1000  
     }, {
         counts: [], // hide page counts control
         total: 1,  // value less than count hide pagination
         getData: function($defer, params) {
        	 $defer.resolve($scope.invoice.positions);
         }
     }); 
     
     $scope.addInvoicePosition = function() {
    	 $scope.invoice.positions.push({});
     };
     
     $scope.deleteInvoicePosition = function(invoice, position) {
 		var index = $scope.invoice.positions.indexOf(position);
 		if (index > -1) {
 			$scope.invoice.positions.splice(index, 1);
 		}
 		$scope.invoiceChanged(invoice);
      };
      
      $scope.invoicePositionChanged = function(invoice, invoicePosition) {
    	
    	  var quantity = invoicePosition.quantity,
    	  unitPrice = invoicePosition.unitPrice;
    	  
    	  if (typeof quantity !== 'undefined' &&  typeof unitPrice !== 'undefined') {
    		  quantity = parseFloat(quantity.replace(",", "."), 10.00) * 100;
        	  unitPrice = parseFloat(unitPrice.replace(",", "."), 10.00);
    		  
    		  invoicePosition.total = Math.round(unitPrice * quantity) /100;
    	  }
    	  $scope.invoiceChanged(invoice);
      };
      
      $scope.invoiceChanged = function(invoice) {
    	  var taxMap = {};
    	  var taxMapKeys = [];
    	  var invoicePositionLength = invoice.positions.length;
    	  for (var i = 0; i < invoicePositionLength; i++) {
    		  var positionTaxRate = invoice.positions[i].taxRate;
    		  var positionTotal = invoice.positions[i].total;
    		  if (typeof positionTotal !== 'undefined' && typeof positionTaxRate !== 'undefined') {
    			  
    			  
    			  var sumaryTaxRate = taxMap[positionTaxRate.rate];
    			  if (typeof sumaryTaxRate === 'undefined') {
    				  sumaryTaxRate = {taxRate : positionTaxRate, taxSubtotal : 0, tax : 0}; 
    				  taxMap[positionTaxRate.rate] = sumaryTaxRate;
    				  taxMapKeys.push(positionTaxRate);
    			  }
    			  sumaryTaxRate.taxSubtotal += positionTotal;
    			  sumaryTaxRate.tax = sumaryTaxRate.taxSubtotal * sumaryTaxRate.taxRate.rate;
    		  } 
    	  }
    	  
    	  
    	  var taxMapKeysLength = taxMapKeys.length;
    	  invoice.taxTotals = [];
    	  invoice.totalAmount = 0;
    	  invoice.subTotalAmount = 0;
    	  for (var i = 0; i < taxMapKeysLength; i++) {
    		  var taxMapValue = taxMap[taxMapKeys[i].rate];
    		  var invoiceTaxTotal = {taxRate : taxMapValue.taxRate, taxSubtotal : taxMapValue.taxSubtotal, tax : taxMapValue.tax};
    		  
    		  invoice.subTotalAmount +=  taxMapValue.taxSubtotal;
    		  invoice.totalAmount += taxMapValue.taxSubtotal + taxMapValue.tax;
    		  
    		  invoice.taxTotals.push(invoiceTaxTotal);
    	  } 
      };
      
	
     if (typeof $scope.invoice === 'undefined') {
			$scope.invoice = {};
			$scope.invoice.positions = [{}];
	}
     
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
	
	taxRatesService.getTaxRates().then(
			function(taxRates) {
				$scope.taxRates = taxRates;
				},
			function(statusCode) {console.log(statusCode);}
		);
	
	
	$scope.addInvoice = function(invoice,newInvoiceForm) {
		
		if (newInvoiceForm.$valid) {
			
			invoicesService.addInvoice(invoice).then(
					function(data) {window.location = "#/invoiceList";},
					function(statusCode) {console.log(statusCode);}
				);
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

