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

    $scope.search = function (){
        $scope.init();
    }
    /**
     * 发评论
     * @param commentText
     * @param weibo
     */
    $scope.sendComment = function (commentText,weibo) {
        httpService.postJson(  "../comment/add?commentText="+commentText+"&weiboId="+ weibo.weiboId, {}) .success(function (response){
            $scope.search()
        })
    };

    /**
     * 添加微博收藏
     * @param weibo
     */
    $scope.addFavorite = function (weibo) {
        httpService.postJson( "../favorite/add", weibo) .success(function (commonResult){
            if(commonResult.code ===  $scope.SUCCESS_CODE){
                $scope.search()
            }
        })
    };
    /**
     * 取消微博收藏
     * @param weibo
     */
    $scope.deleteFavorite = function (weibo) {
        httpService.postJson( "../favorite/unAdd", weibo) .success(function (commonResult){
            if(commonResult.code ===  $scope.SUCCESS_CODE){
                $scope.search()
            }
        })
    };

    /**
     * 点赞微博
     * @param weibo
     */
    $scope.addLike = function (weibo) {
        httpService.postJson( "../like/add", weibo) .success(function (commonResult){
            if(commonResult.code ===  $scope.SUCCESS_CODE){
                $scope.search()
            }
        })
    };

    /**
     * 取消点赞
     * @param weibo
     */
    $scope.deleteLike = function (weibo) {
        httpService.postJson( "../like/unAdd", weibo) .success(function (commonResult){
            if(commonResult.code ===  $scope.SUCCESS_CODE){
                $scope.search()
            }
        })
    };
    /**
     * 去用户主页
     * @param user
     */
    $scope.toFrofile = function (user) {
        location.href = "./#publicProfile?userId="+ user.userId;
    };




})
