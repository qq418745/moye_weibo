app.config(function($provide, $routeProvider) {
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
            .when('/publicProfile', {
                templateUrl: 'view/publicProfile.html',
                controller: 'publicProfileController',
            })
            .when('/star', {
                templateUrl: 'view/star.html',
                controller: 'starController',
            })
            .when('/like', {
                templateUrl: 'view/like.html',
                controller: 'likesController',
            })
            .when('/comment', {
                templateUrl: 'view/comment.html',
                controller: 'commentController',
            })
            .when('/profile', {
                templateUrl: 'view/profile.html',
                controller: 'profileController',
            })
            .when('/plaza', {
                templateUrl: 'view/plaza.html',
                controller: 'plazaController',
            })
            .otherwise({
                redirectTo:  '/plaza'
            });
        // you might need to call $route.reload() if the route changed
        $route.reload();
    })