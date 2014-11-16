todoApp.controller("todoController", function($scope, $http) {
	
	$scope.isLoading = true;
	
	var responsePromise = $http.get("http://localhost:8080/springhello/todos");
	responsePromise.success(
    	function(response) {$scope.todos = response;}
    );
	responsePromise.error(
			function(data, status, headers, config) {
                alert("AJAX failed!");
            }
    );
	$scope.isLoading = false;
	
	$scope.todoBiz = {};
	
	$scope.todoBiz.doclick = function () {
		alert("Hello World");
	}
	
	$scope.todoBiz.deleteTodo = function(id) {
		if (confirm("Going to delete " + id + "?")) {
			$http.delete("http://localhost:8080/springhello/todos/" + id);
		}
	}
	
	$scope.todoBiz.createTodo = function() {
		$http.put("http://localhost:8080/springhello/todos/",
				{title: "Hello todo"});
		
	}
	
	$scope.todoBiz.modifyTodo = function() {
		$http.post("http://localhost:8080/springhello/todos/",
				{id: 1 , title: "Hello todo"});
		
	}
	
});

 