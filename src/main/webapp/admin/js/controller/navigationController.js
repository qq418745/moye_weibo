app.controller('navigationController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.isLogin2 = false;
    $scope.isLogin = function () {
        httpService.postJson("../weiboUser/p/isLogin",{}).success(function (l){
            $scope.isLogin2 = l;
        })

    };

    $scope.isLogin ();

})
