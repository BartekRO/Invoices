'use strict';

var invoices = angular.module('invoices', [ 'ngRoute', 'ngCookies' ]).config(function($routeProvider, $httpProvider) {
			$routeProvider.when('/invoiceList', {
				templateUrl : 'template/invoiceList.html',
				controller : 'InvoiceListController'
			});
			$routeProvider.when('/addInvoice', {
				templateUrl : 'template/addInvoice.html',
				controller : 'AddInvoiceController'
			});
			$routeProvider.when('/login', {
				templateUrl : 'template/login.html',
				controller : 'LoginController'
			});
			$routeProvider.otherwise({
				redirectTo : '/invoiceList'
			});

			$httpProvider.interceptors.push(function ($q, $rootScope, $location) {
			        return {
			        	'responseError': function(rejection) {
			        		var status = rejection.status;
			        		var data = rejection.data;
			        		var config = rejection.config;
			        		var method = config.method;
			        		var url = config.url;
			      
			        		if (status == 401) {
			        			$location.path( "/login" );
			        		} else {
			        			$rootScope.error = data.message;
			        			console.log(method + " on " + url + " failed with status " + status + " and message " + data.message);
			        		}
			              
			        		return $q.reject(rejection);
			        	}
			        };
			    }
		    );
			
			 $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
			        return {
			        	'request': function(config) {
			        		var isRestCall = config.url.indexOf('rest') >= 0;
			        		if (isRestCall && angular.isDefined($rootScope.authenticationToken)) {
			        			var authenticationToken = $rootScope.authenticationToken;
		        				config.headers['X-Auth-Token'] = authenticationToken;
			        		}
			        		return config || $q.when(config);
			        	}
			        };
			    });
		})
		.run(function($rootScope, $location, $cookieStore, securityService) {
			
			/* Reset error when a new view is loaded */
			$rootScope.$on('$viewContentLoaded', function() {
				delete $rootScope.error;
			});
			
			$rootScope.hasRole = function(role) {
				
				if ($rootScope.user === undefined) {
					return false;
				}
				
				if ($rootScope.user.roles[role] === undefined) {
					return false;
				}
				
				return $rootScope.user.roles[role];
			};
			
			
			$rootScope.logout = function() {
				delete $rootScope.user;
				delete $rootScope.authToken;
				$cookieStore.remove('authenticationToken');
				$location.path( "/login" );
			};
			
			var originalPath = $location.path();
			$location.path("/login");
			var authenticationToken = $cookieStore.get('authenticationToken');
			if (authenticationToken !== undefined) {
				$rootScope.authenticationToken = authenticationToken;
				
				securityService.getUser().then(
					function(user) {
						$rootScope.user = user;
						$location.path(originalPath);
					},
					function(statusCode) {
							console.log(statusCode);
					}
				);
			}
			
			$rootScope.initialized = true;
		});
