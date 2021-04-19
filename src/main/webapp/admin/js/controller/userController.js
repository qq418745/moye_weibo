app.controller('userController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.userList = {}; //用户数据
    $scope.likeText = ''; //搜索文本

    /**
     * 查询
     * @param page
     * @param rows
     */
    $scope.search = function (page, rows) {
        httpService.postJson(  (page && rows ?  $scope.pagingQuery("../weiboUser/findAll", page, rows) : $scope.pagingQuery("../weiboUser/findAll")) + "&userText="+$scope.likeText,{}) .success(function (response){
            $scope.paginationConf.totalItems = response.total;
            $scope.userList = response.rows;
        })
    }

    /**
     * 删除
     */
    $scope.delete = function (id) {
        httpService.postJson(  "../weiboUser/delete?id=" + id,{}) .success(function (response){
            $scope.search()
        })
    }







})
