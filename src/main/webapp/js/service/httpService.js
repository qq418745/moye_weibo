/**
 * http发送工具类
 */
app.service('httpService',function($http){

    var jsonConfig = {
        headers: { 'Content-Type': 'application/json' }
    };

    /**
     * json请求
     * @param url
     * @param entity
     * @returns {*}
     */
    this.postJson = function(url,entity){
        return $http.post(url, entity, jsonConfig);
    };

    /**
     * post请求
     * @param url
     * @param entity
     * @returns {*}
     */
    this.post = function(url,entity){
        return $http.post(url, entity);
    };
})