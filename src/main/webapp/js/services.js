'use strict';


 invoices.factory('invoicesService', function($http, $q) {
	return {
		getInvoices : function() {
			var deferred = $q.defer();
			
			$http({method : "GET", url : "rest/getInvoices"
				}).success(function (data, status, headers, config) {
					deferred.resolve(data);
				}).error(function (data, status, headers, config) {
					deferred.reject(status);
				});
			
			return deferred.promise;
		},
		
		addInvoice : function(invoice) {
			var deferred = $q.defer();
			
			$http({method : "POST", url : "rest/addInvoice", data: invoice
			}).success(function (data, status, headers, config) {
				deferred.resolve(data);
			}).error(function (data, status, headers, config) {
				deferred.reject(status);
			});
		
			return deferred.promise;
		},
		
		removeInvoice : function(invoiceId) {
			var deferred = $q.defer();
			
			$http({method : "POST", url : "rest/removeInvoice", data: invoiceId
			}).success(function (data, status, headers, config) {
				deferred.resolve(data);
			}).error(function (data, status, headers, config) {
				deferred.reject(status);
			});
		
			return deferred.promise;
		}
		
	};
});
 
 
 invoices.factory('securityService', function($http, $q) {
		return {
			authenticate : function(usr, pass) {
				var deferred = $q.defer();
				
				$http({method : "POST", url : "rest/authenticate", data : {username : usr, password : pass}
					}).success(function (data, status, headers, config) {
						deferred.resolve(data);
					}).error(function (data, status, headers, config) {
						deferred.reject(data, status);
					});
				
				return deferred.promise;
			},
			getUser : function() {
				var deferred = $q.defer();
				
				$http({method : "GET", url : "rest/user"
					}).success(function (data, status, headers, config) {
						deferred.resolve(data);
					}).error(function (data, status, headers, config) {
						deferred.reject(status);
					});
				
				return deferred.promise;
			}
		};
 });
