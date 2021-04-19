app.controller('navigationController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.topicList = []; //话题数据
    $scope.searchText = ''; //搜索文本
    $scope.searchType = '微博'; //搜索类型

    $scope.isLogin2 = false; //是否登陆

    /**
     *判断是否登陆
     */
    $scope.isLogin = function () {
        httpService.postJson("../weiboUser/p/isLogin",{}).success(function (l){
            $scope.isLogin2 = l;
        })

    };

    /**
     * 热门话题
     */
    $scope.fireTopic = function () {
        httpService.postJson("../weibo/p/fireTopic",{}).success(function (topicList){
            $scope.topicList = topicList;
        })

    };

    //执行
    $scope.fireTopic ();
    $scope.isLogin ();

})
