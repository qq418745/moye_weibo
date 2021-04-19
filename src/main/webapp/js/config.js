app.config([ '$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('httpInterceptor');
} ]);
/**
 * 401拦截
 */
app.factory('httpInterceptor', [ '$q', '$injector',function($q, $injector) {
    var httpInterceptor = {
        'responseError' : function(response) {
            if (response.status == 401) {

                window.location = "../../login.html";
                return;
            }
        },
        'response' : function(response) {
            return response;
        }
    }
    return httpInterceptor;
}
]);