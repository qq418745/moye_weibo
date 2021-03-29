app.service('httpService',function($http){

    var config = {
        headers: { 'Content-Type': 'application/json' }
    };

    this.postJson = function(url,entity){
        return $http.post(url, entity, config);
    };

})