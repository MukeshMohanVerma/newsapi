var app = angular.module('app', ['ngRoute']);
app.config(function($routeProvider){
    $routeProvider
        .when('/news',{
            templateUrl: 'views/news.html',
            controller: 'newsController'
        })
        .otherwise(
            { redirectTo: '/news'}
        );
});