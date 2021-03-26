var app = angular.module("moyeApp",['pagination' ,'ngRoute' ])

    .config(function($provide, $routeProvider) {
    $provide.factory('$routeProvider', function () {
        return $routeProvider;
    });
    })
    .run(function($routeProvider, $http, $route) {

        $routeProvider
            .when('/home', {
                templateUrl: 'view/home.html',
                controller: 'homeController',
            })
            .when('/navigation', {
                templateUrl: 'view/navigation.html',
                controller: 'navigationController',
            })
            .when('/profile', {
                templateUrl: 'view/profile.html',
                controller: 'profileController',
            })
            .otherwise({
                redirectTo:  '/navigation'
            });
        // you might need to call $route.reload() if the route changed
        $route.reload();
    })
