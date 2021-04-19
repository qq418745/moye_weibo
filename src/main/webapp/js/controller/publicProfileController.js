app.controller('publicProfileController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.weiboUser = {};
    $scope.setWeiboUser = {};
    $scope.followList = [];
    $scope.unFollowList = [];
    $scope.weiboList = []
    $scope.cardSwitch = 'activity';
    $scope.userId = location.href.split("?")[1].split("=")[1];
    /**
     * 当前用户信息
     */
    $scope.getUserInfo = function (){

        httpService.postJson("../weiboUser/p/user?id="+ $scope.userId ).success(function (user){
            $scope.weiboUser = user;
            $scope.setWeiboUser = JSON.parse( JSON.stringify(user));
        });
    }
    /**
     * 关注和被关注的信息
     */
    $scope.getFollow = function (){
        httpService.postJson("../follow/p/follow?id="+ $scope.userId ).success(function (rs){;
            $scope.followList = rs.rows;

        });
        httpService.postJson("../follow/p/unFollow?id="+ $scope.userId ).success(function (rs){
            $scope.unFollowList =  rs.rows;
        });
    }

    /**
     * 获取所有的微博
     */
    $scope.searchWeiboList = function () {
        httpService.postJson(  "../weibo/p/findAllByUserId"+"?page=" + 1 +'&rows='+999+'&id='+ $scope.userId ,{}) .success(function (response){
            $scope.weiboList = response.rows;
        })
    }





    $scope.unFollow  = function (id) {
        httpService.postJson(  "../follow/currentUser/delete"+ '?id='+ id ,{}) .success(function (response){
            $scope.init();
        })
    }

    $scope.follow  = function (id) {
        httpService.postJson(  "../follow/currentUser/add"+ '?id='+ id ,{}) .success(function (response){
            $scope.init();
        })
    }

    $scope.isFollowTow = false;
    $scope.isFollow = function (id) {
        httpService.postJson(  "../follow/p/isFollow"+ '?id='+ id ,{}) .success(function (response){
            $scope.isFollowTow  = response;
        })
    };
    $scope.init = function () {
        $scope.getFollow();
        $scope.getUserInfo();
        $scope.searchWeiboList();
        $scope.isFollow($scope.userId)
    }
    $scope.init();




})
