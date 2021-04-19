app.controller('navigationController' ,function($scope,$controller,httpService){

    $controller('baseController',{$scope:$scope});//继承

    $scope.searchText = '';

    $scope.searchType = '微博';


})
