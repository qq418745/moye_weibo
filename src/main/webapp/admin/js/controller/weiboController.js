app.controller('weiboController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.weiboList = {}; //微博数据
    $scope.likeText = ''; //搜索文本

    /**
     * 查询微博
     * @param page
     * @param rows
     */
    $scope.search = function (page, rows) {
        httpService.postJson(  (page && rows ?  $scope.pagingQuery("../weibo/findAll", page, rows) : $scope.pagingQuery("../weibo/findAll")),{}) .success(function (response){
            $scope.paginationConf.totalItems=response.total
            $scope.weiboList = response.rows;
        })
    }

    /**
     * 模糊搜索微博
     */
    $scope.likeSearch = function () {
        httpService.postJson(  "../weibo/p/search?type=" +  "WO" +"&text="+      $scope.likeText,{}) .success(function (response){
            $scope.paginationConf.totalItems = response.length;
            $scope.weiboList = response;

        })
    };

    /**
     * 删微博
     */
    $scope.deleteWeibo = function (id) {
        httpService.postJson("../weibo/delete?id="+id, {}).success(function (weibo){
            $scope.search();
        })
    }

})
