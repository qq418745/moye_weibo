app.controller('plazaController' ,function($scope, $controller, httpService){

    // $scope.weiboEntity = {};
    // $scope.weiboEntity.content = "";
    $controller('baseController',{$scope:$scope});//继承
    $scope.weiboList = {};

    $scope.search = function (page, rows) {
        httpService.postJson(  (page && rows ?  $scope.pagingQuery("../weibo/p/findAll", page, rows) : $scope.pagingQuery("../weibo/p/findAll")),{}) .success(function (response){
            $scope.paginationConf.totalItems=response.total
            $scope.weiboList = response.rows;
        })
    }
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



    // $scope.send = function () {
    //     httpService.postJson("../weibo/send", $scope.weiboEntity).success(function (weibo){
    //         httpService.postJson("../weibo/currentUser/findAll",{}) .success(function (list){
    //             $scope.weiboList = list;
    //             $scope.weiboEntity = {};
    //         })
    //     })
    // }
})
