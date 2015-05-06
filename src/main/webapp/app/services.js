(function(angular) {
    var HATEOAS_URL = './api/users';
    var UsersFactory = function($http, SpringDataRestAdapter) {

        function User(user){
            if(user._resources){
                user.resources = user._resources("self", {}, {
                    update: {
                        method: 'PUT'
                    }
                });
                user.save = function(callback){
                    user.resources.update(user, function(){
                        callback && callback(user);
                    });
                }

                user.remove = function(callback) {
                    user.resources.remove(function() {
                        callback && callback(user);
                    });
                };
            }else{

                user.save = function(callback){
                    User.resources.save(user, function(user,headers){

                    var deferred = $http.get(headers().location);
                    return SpringDataRestAdapter.processWithPromise(deferred).then(function(newUser){
                        callback && callback(new User(newUser));

                    });

                    });

                };
            }

            return user;
        }


        User.query = function(callback) {
            var deferred = $http.get(HATEOAS_URL);
            return SpringDataRestAdapter.processWithPromise(deferred).then(function(data) {
                User.resources = data._resources("self");
                callback && callback(_.map(data._embeddedUser, function(user) {
                    return new User(user);
                }));
            });
        };

        User.resources=null;
        return User;
    };

    UsersFactory.$inject = ['$http', 'SpringDataRestAdapter'];
    angular.module("myApp.services").factory("User", UsersFactory);
}(angular));