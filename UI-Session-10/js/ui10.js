var sampleTasklist = new taskList("New Task");
var newTask = new taskFunction("Task");
var completedTask = new taskFunction("Completed Task");
completedTask.status = 6;
sampleTasklist.addNewTask(newTask);
sampleTasklist.addNewTask(completedTask);

//Angular JS: MVC
var app = angular.module("app", []);
app.controller("TaskListController", ["$scope", function($scope) {
    $scope.tasklist = sampleTasklist;
    $scope.selectedTask = null;

    $scope.selectTask = function(task) {
      $scope.selectedTask = task;
    }
    $scope.addNewTask = function(name) {
      var newtask = new taskFunction(name);
      $scope.tasklist.addNewTask(newtask);
      $scope.selectedTask = newtask;
      $scope.newtaskname = null;
    }
    $scope.deleteTask = function(task) {
	    $scope.tasklist.deleteTask(task);
    }
    $scope.saveTask = function(name) {
      $scope.selectedTask = null;
    }

    $scope.resetSelectedTask = function() {
      $scope.selectedTask = null;
    }
  }]);

function taskList(name) {
  this.name = name;
  this.tasks = [];
  this.addNewTask = function(task) {
    this.tasks.push(task);
  }
  this.deleteTask = function(task) {
    var index = this.tasks.findIndex(obj => obj.title == task);
    this.tasks.splice(index, 1);
  }
}

function taskFunction(name) {
  this.title = name;
  this.duedate = null;
  this.description = null;
  this.reminder = null;
  this.urgency = 2;
  this.status = 4;
  this.completed = false;
}