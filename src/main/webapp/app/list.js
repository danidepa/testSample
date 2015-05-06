var app = angular.module("ListAng",[]);

app.controller("ListCtrl", function($scope, userService){
    $scope.users=[];
    userService.fetchAll().success(function(data){
        $scope.users=data;
    }).error(function(data,status){
        alert("Unable to load Data ("+status+") ");
    });

    $scope.remove = function(userId){
        userService.remove(userId).success(function () {
                for(var i=0 ; i  <$scope.users.length;i++){
                    var user = $scope.users[i];
                    if(userId == user.id){
                        $scope.users.splice(i,1);
                        break;
                    }
                }
                alert("Record removed success");
            }

        ).error(function(data,status){
                alert("Unable to remove record "+status);

        });
    };

    $scope.create  = function(user){
        userService.create(user).success(function(data){
            $scope.users.push(data);
            $scope.newUser={};
            alert("Record created success");
        }).error(function(data,status){
            alert("Unable to create record "+status);
        });
    };

    $scope.update = function(user){
        userService.update(user).success(
            function(data){
                for(var i=0 ; i  <$scope.users.length;i++){
                    var user = $scope.users[i];
                    if(data.id == user.id){
                        user=data;
                        break;
                    }
                }

                alert("Record updated success");

            }
        ).error(
            function(data,status){
                alert("Error updating record "+status);
            }
        );
    };

});

app.factory("userService", function($http){
    return {
        fetchAll: function(){
            return $http.get("rest/users");
        },
        remove: function(userId){
            return $http.delete("rest/users/"+userId);
        },
        create: function(user){
            return $http.post("rest/users", user);

        },
        update: function(user){
            return $http.put("rest/users", user);
        }
    }
});

var compareTo = function() {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function(scope, element, attributes, ngModel) {

            ngModel.$validators.compareTo = function(modelValue) {
                return modelValue == scope.otherModelValue;
            };

            scope.$watch("otherModelValue", function() {
                ngModel.$validate();
            });
        }
    };
};

app.directive("compareTo", compareTo);