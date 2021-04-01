app.controller('navigationController' ,function($scope,httpService){

   $scope.weiboEntity = {};
   $scope.weiboEntity.content = "";

   $scope.weiboList = {};

    $scope.currentUserFindAll = function () {
          httpService.postJson("../weibo/currentUser/findAll",{}) .success(function (list){
              $scope.weiboList = list;
          })
    }
    $scope.currentUserFindAll();

   $scope.send = function () {
       httpService.postJson("../weibo/send", $scope.weiboEntity).success(function (weibo){
           httpService.postJson("../weibo/currentUser/findAll",{}) .success(function (list){
               $scope.weiboList = list;
               $scope.weiboEntity = {};
           })
       })
   }
})
