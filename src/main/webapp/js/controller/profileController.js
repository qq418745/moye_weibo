app.controller('profileController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.weiboUser = {}; //微博用户
    $scope.setWeiboUser = {}; //set微博用户对象
    $scope.followList = []; //粉丝列表
    $scope.unFollowList = []; //关注列表
    $scope.weiboList = [] //微博列表
    $scope.cardSwitch = 'activity'; //切换

    /**
     * 当前用户信息
     */
    $scope.getUserInfo = function (){
        httpService.postJson("../weiboUser/currentWeiboUser").success(function (user){
            $scope.weiboUser = user;
            $scope.setWeiboUser = JSON.parse( JSON.stringify(user));
        });
    }
    /**
     * 关注和被关注的信息
     */
    $scope.getFollow = function (){
        httpService.postJson("../follow/follow").success(function (rs){;
            $scope.followList = rs.rows;

        });
        httpService.postJson("../follow/unFollow").success(function (rs){
            $scope.unFollowList =  rs.rows;
        });
    }

    /**
     * 获取所有的微博
     */
    $scope.searchWeiboList = function () {
        httpService.postJson(  "../weibo/currentUser/findAll"+"?page=" + 1 +'&rows='+999,{}) .success(function (response){
            $scope.weiboList = response.rows;
        })
    }

    //执行
    $scope.getFollow();
    $scope.getUserInfo();
    $scope.searchWeiboList();

    /**
     * 用户信息保存
     */
    $scope.save = function (){
        httpService.postJson("../weiboUser/save",$scope.setWeiboUser).success(function (user){
            $scope.weiboUser = user;
            $scope.setWeiboUser = JSON.parse( JSON.stringify(user));
        });
    }


})
