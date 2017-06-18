var app = angular.module('sortApp', [ 'ui.router', 'ngStorage' ]);

app.constant('urls', {
	BASE : 'http://localhost:8080/sort',
	SERVICE_API : 'http://localhost:8080/sort/list'
});

app.config([
		'$stateProvider',
		'$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {

			$stateProvider.state('home', {
				url : '/',
				templateUrl : 'index.html',
				controller : 'SortController',
				controllerAs : 'ctrl',
				resolve : {
					sortList : function($q, SortService) {
						console.log('Load list');
						var deferred = $q.defer();
						SortService.loadList().then(deferred.resolve,
								deferred.resolve);
						return deferred.promise;
					}
				}
			});
		} ]);
