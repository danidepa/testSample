(function(angular) {
    var AppController = function($scope, User) {
        User.query(function(response) {
            $scope.users = response ? response : [];
        });

        $scope.addUser = function(firstName,lastName,dateOfBirth,sex,email,password,role) {
            new User({
                firstName:firstName,
                lastName:lastName,
                dateOfBirth:dateOfBirth,
                sex:sex,
                email:email,
                password:password,
                role:role
            }).save(function(user) {
                    $scope.users.push(user);
                });
            $scope.newUser = "";
        };

        $scope.updateUser = function(user) {
            user.save();
        };

        $scope.deleteUser = function(user) {
            user.remove(function() {
                $scope.users.splice($scope.users.indexOf(user), 1);
            });
        };
    };

    AppController.$inject = ['$scope', 'User'];
    angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));