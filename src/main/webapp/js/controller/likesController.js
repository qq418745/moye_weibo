app.controller('likesController' ,function($scope, $controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.weiboList = {}; //微博数据
    $scope.weiboEntity = {}; //微博对象
    $scope.weiboEntity.content = ""; //微博对象内容
    $scope.paginationConf.itemsPerPag = 9999;

    /**
     * 发微博
     */
    $scope.send = function () {
        httpService.postJson("../weibo/send", $scope.weiboEntity).success(function (weibo){
            $scope.search();
            $scope.weiboEntity = {};
        })
    }

    /**
     * 删微博
     */
    $scope.deleteWeibo = function (id) {
        httpService.postJson("../weibo/delete?id="+id, {}).success(function (weibo){
            $scope.search();
        })
    }

    /**
     * 搜当前用户微博
     * @param page
     * @param rows
     */
    $scope.search = function (page, rows) {
        httpService.postJson(  (page && rows ?  $scope.pagingQuery("../weibo/currentUser/findByLike", page, rows) : $scope.pagingQuery("../weibo/currentUser/findByLike")),{}) .success(function (response){
            $scope.paginationConf.totalItems=response.total
            $scope.weiboList = response.rows;
        })
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
