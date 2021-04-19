app.controller('navigationController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承
    /**
     * 是否登陆
     * @type {boolean}
     */
    $scope.isLogin2 = false;

    /**
     * 是否登陆方法
     */
    $scope.isLogin = function () {
        httpService.postJson("../weiboUser/p/isLogin",{}).success(function (l){
            $scope.isLogin2 = l;
        })

    };

    /**
     * 初始化执行
     */
    $scope.isLogin ();

})
