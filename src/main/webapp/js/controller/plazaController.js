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

    $scope.addFavorite = function (weibo) {
        httpService.postJson( "../favorite/add", weibo) .success(function (commonResult){
            if(commonResult.code ===  $scope.SUCCESS_CODE){
                $scope.search()
            }
        })
    };

    $scope.deleteFavorite = function (weibo) {
        httpService.postJson( "../favorite/unAdd", weibo) .success(function (commonResult){
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
