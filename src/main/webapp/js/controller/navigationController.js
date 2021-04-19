app.controller('navigationController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承
    $scope.topicList = [];

    $scope.searchText = '';
    $scope.searchType = '微博';

    $scope.fireTopic = function () {
        httpService.postJson("../weibo/p/fireTopic",{}).success(function (topicList){
            $scope.topicList = topicList;
        })

    };
    $scope.fireTopic ();

})
