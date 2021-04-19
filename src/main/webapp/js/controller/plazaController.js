app.controller('plazaController' ,function($scope, $controller, httpService){

    $controller('baseController',{$scope:$scope});//继承
    $scope.weiboList = {}; //微博数据

    /**
     * 查所有微博
     * @param page
     * @param rows
     */
    $scope.search = function (page, rows) {
        httpService.postJson(  (page && rows ?  $scope.pagingQuery("../weibo/p/findAll", page, rows) : $scope.pagingQuery("../weibo/p/findAll")),{}) .success(function (response){
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
