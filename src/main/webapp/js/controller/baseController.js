app.controller("baseController", function ($scope) {
    // 分页的配置的信息
    $scope.paginationConf = {
        currentPage: 1, // 当前页数
        showEndPage: true, // 显示最后一页
        totalItems: 0, // 总记录数
        itemsPerPage: 20, // 每页显示多少条记录
        perPageOptions: [10, 20, 30, 40, 50],// 显示多少条下拉列表
        onChange: function () { // 当页码、每页显示多少条下拉列表发生变化的时候，自动触发了
            $scope.reloadList();// 重新加载列表
        }
    };

    $scope.SUCCESS_CODE = 0; //成功码
    $scope.ERROR_CODE = -1; //失败码

    /**
     * 重载页面
     */
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    /**
     * 分页信息拼接工具
     * @param url
     * @param page
     * @param rows
     * @returns {string}
     */
    $scope.pagingQuery = function (url, page, rows){
        if(page && rows){
            return url + "?page=" + page +'&rows='+rows
        }
        return url + "?page=" +  $scope.paginationConf.currentPage +'&rows='+ $scope.paginationConf.itemsPerPage
    }



})