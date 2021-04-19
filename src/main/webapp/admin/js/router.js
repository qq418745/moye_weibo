app.config(function($provide, $routeProvider) {
    $provide.factory('$routeProvider', function () {
        return $routeProvider;
    });
})
    .run(function($routeProvider, $http, $route) {

        $routeProvider
            .when('/user', {
                templateUrl: 'view/user.html',
                controller: 'userController',
            })
            .when('/comment', {
                templateUrl: 'view/comment.html',
                controller: 'commentController',
            })
            .when('/weibo', {
                templateUrl: 'view/weibo.html',
                controller: 'weiboController',
            })
            .otherwise({
                redirectTo:  '/weibo'
            });
        // you might need to call $route.reload() if the route changed
        $route.reload();
    })