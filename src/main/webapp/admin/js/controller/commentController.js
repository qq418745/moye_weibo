app.controller('commentController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.commentList = {};
    $scope.likeText = '';

    /**
     * 查询
     * @param page
     * @param rows
     */
    $scope.search = function (page, rows) {
        httpService.postJson(  (page && rows ?  $scope.pagingQuery("../comment/findAll", page, rows) : $scope.pagingQuery("../comment/findAll")) + "&commentText="+$scope.likeText,{}) .success(function (response){
            $scope.paginationConf.totalItems = response.total;
            $scope.commentList = response.rows;
        })
    }
     /**
      * 删评论
      * @param id
      */
     $scope.deleteComment = function (id) {
         httpService.postJson(  "../comment/delete?id="+id, {}) .success(function (response){
             $scope.search()
         })
     };






})
