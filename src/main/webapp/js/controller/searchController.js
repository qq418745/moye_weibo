app.controller('searchController' ,function($scope, $controller,httpService){

    $controller('baseController',{$scope:$scope});//继承
    // 搜索内容
    $scope.hrefText = location.href.split("?")[1].split("&")[1].split("=")[1]
    //搜收类型
    $scope.hrefType = location.href.split("?")[1].split("&")[0].split("=")[1]
    //微博集合
    $scope.weiboList = {};
    //用户集合
    $scope.userList = {};

    /**
     * 搜索微博或者用户
     */
    $scope.search = function () {
        httpService.postJson(  "../weibo/p/search?type=" +   $scope.hrefType  +"&text="+      $scope.hrefText,{}) .success(function (response){

            if ("YH" === $scope.hrefType){
                $scope.$applyAsync($scope.cardSwitch = 'timeline2')
                $scope.userList = response;
            }
            if ("HT" === $scope.hrefType){
                $scope.$applyAsync($scope.cardSwitch = 'timeline')
                $scope.weiboList = response;
            }
            if ("WO" === $scope.hrefType){
                $scope.$applyAsync($scope.cardSwitch = 'activity')
                $scope.weiboList = response;
            }

        })
    };
    $scope.search();



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
