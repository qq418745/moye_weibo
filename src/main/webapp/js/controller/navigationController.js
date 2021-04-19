app.controller('navigationController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承
    $scope.topicList = [];

    $scope.searchText = '';
    $scope.searchType = '微博';

    $scope.isLogin2 = false;
    $scope.isLogin = function () {
        httpService.postJson("../weiboUser/p/isLogin",{}).success(function (l){
            $scope.isLogin2 = l;
        })

    };
    $scope.fireTopic = function () {
        httpService.postJson("../weibo/p/fireTopic",{}).success(function (topicList){
            $scope.topicList = topicList;
        })

    };
    $scope.fireTopic ();
    $scope.isLogin ();

})
