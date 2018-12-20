function formataDinheiro(int) {
	var tmp = int+'';
    tmp = tmp.replace(/([0-9]{2})$/g, ",$1");
    if( tmp.length > 6 )
            tmp = tmp.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");

    return tmp;
}
var app = angular.module("UserManagement", []);
app.controller("UserController", function($scope, $http) {	
	$scope.names = ["A", "B", "C"];
    $scope.user = [];
    $scope.userForm = {
        userId: 1,
        userNome: "",
        userCredito: "",
        userRisco: "",
        userTaxa: ""
    };
    
    $scope.changedValue = function(item){
		console.log('dddd');
		if(item=='A'){
			$scope.userForm.userTaxa = "0";
		}else if(item=='B'){
			$scope.userForm.userTaxa = "10";
		}else if(item=='C'){
			$scope.userForm.userTaxa = "20";
		}
	}
 
    _refreshUserData();
 
    $scope.submitUser = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.userForm.userId == -1) {
            method = "POST";
            url = '/user';
        } else {
            method = "PUT";
            url = '/user';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.userForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createUser = function() {
        _clearFormData();
    }
 
    $scope.deleteUser = function(user) {
        $http({
            method: 'DELETE',
            url: '/user/' + user.userId
        }).then(_success, _error);
    };
 
    $scope.editUser = function(user) {
        $scope.userForm.userId = user.userId;
        $scope.userForm.userNome = user.userNome;
        $scope.userForm.userCredito = user.userCredito;
        $scope.userForm.userRisco = user.userRisco;
        $scope.userForm.userTaxa = user.userTaxa;
    };
 
    function _refreshUserData() {
        $http({
            method: 'GET',
            url: '/users'
        }).then(
            function(res) { // success
                $scope.users = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
    	_refreshUserData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // limpa
    function _clearFormData() {
    	$scope.userForm.userId = -1;
        $scope.userForm.userNome = "";
        $scope.userForm.userCredito = "";
        $scope.userForm.userRisco = "";
        $scope.userForm.userTaxa = "";
        
    };
});