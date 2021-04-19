app.controller('navigationController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.searchText = '';

    $scope.searchType = '微博';

    $scope.search = function () {
        httpService.postJson(  "../weibo/p/search?type=" +  $scope.searchType  +"&text="+   $scope.searchText,{}) .success(function (response){
            $scope.paginationConf.totalItems=response.total
            $scope.weiboList = response.rows;
        })
    };
})
