app.controller('profileController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.weiboUser = {};

    $scope.getUserInfo = function (){
        httpService.postJson("../weiboUser/currentWeiboUser").success(function (user){
            $scope.weiboUser = user;
        });
    }
    $scope.getUserInfo();

})
