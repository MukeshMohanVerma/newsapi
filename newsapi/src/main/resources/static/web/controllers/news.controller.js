app.controller('newsController', function($scope, $http, $rootScope) {
	
	$scope.errorMsg="";	
	$scope.successMsg = "";
	$scope.country = "";
	$scope.selectedCategories  = "";
	$scope.searchLimit = "";
	$scope.selectOptions = [{code:"au",country:"Australia"},{code:"ca",country:"Canada"},{code:"cn",country:"China"},
	                        {code:"in",country:"India"},{code:"it",country:"Itly"},{code:"jp",country:"Japan"},
	                        {code:"ru",country:"Russia"},{code:"us",country:"United States"},
	                        {code:"gb",country:"United Kingdom"}];
	$scope.catgories = ["Business","Entertainment","Health","Science","Sports","Technology"];
	$scope.isSearching = false;
	$scope.newsData = [];
	var baseUrl = localStorage.getItem("apiBaseUrl");;
	var data = "";
	var config = { headers : { 'Content-Type' : 'application/json;charset=utf-8;'}};
	
	$scope.init = function(){
		$('.select2').select2();
	}
	
	$scope.getNews = function(){
		var validateStatus = validateSearch();
		if(validateStatus){
			$scope.isSearching = true;
			var getNewsUrl = baseUrl + "getNews";
			var requestPayload = {country : $scope.country.code, categories : $scope.selectedCategories.toString().toLowerCase(), limit : $scope.searchLimit};
			$http.post(getNewsUrl, requestPayload).then(function(response){
				$scope.newsData = response.data;
				if($scope.newsData.length == 0){
					showErrorMsg("No data found for search");
				}
				$scope.isSearching = false;
			});			
		}
	}
	
	$scope.clearSearch = function(){
		$scope.country = "";
		$scope.searchLimit = "";
		for(var i=0; i<$scope.selectedCategories.length; i++){
			 setTimeout(function(){ 
				 $(".select2-selection__choice__remove").trigger("click");			
			 }, 100);
		}
		$scope.selectedCategories  = "";
		$scope.newsData = [];
	}
	
	var validateSearch = function(){
		if($scope.country == ""){
			showErrorMsg("Please select country");
			return false;
		}else if($scope.searchLimit == ""){
			showErrorMsg("Please enter news limit");
			return false;
		}else if(parseInt($scope.searchLimit) <= 0){
			showErrorMsg("Limit must be greator than 0");
			return false;
		}else{
			return true;
		}
	}
	var showErrorMsg = function(msg){
		toastr.error(msg);
	}
});
