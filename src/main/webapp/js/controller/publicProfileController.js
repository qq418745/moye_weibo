app.controller('publicProfileController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承
    //
    // $scope.weiboUser = {};
    // $scope.setWeiboUser = {};
    //
    // $scope.cardSwitch = 'activity';
    //
    // $scope.getUserInfo = function (){
    //     httpService.postJson("../weiboUser/currentWeiboUser").success(function (user){
    //         $scope.weiboUser = user;
    //         $scope.setWeiboUser = JSON.parse( JSON.stringify(user));
    //     });
    // }
    //
    // $scope.getUserInfo();
    //
    // $scope.save = function (){
    //     httpService.postJson("../weiboUser/save",$scope.setWeiboUser).success(function (user){
    //         $scope.weiboUser = user;
    //         $scope.setWeiboUser = JSON.parse( JSON.stringify(user));
    //     });
    // }


})
