app.service('httpService',function($http){

    var jsonConfig = {
        headers: { 'Content-Type': 'application/json' }
    };

    this.postJson = function(url,entity){
        return $http.post(url, entity, jsonConfig);
    };

})