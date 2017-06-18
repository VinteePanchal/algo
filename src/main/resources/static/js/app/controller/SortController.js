'use strict';

angular.module('sortApp').controller('SortController',
		[ 'SortService', '$scope', function(SortService, $scope) {

			var self = this;
			self.sortList = [];
			self.unsortedList = {};
			self.submit = submit;
	        self.reset = reset;

	        self.successMessage = '';
	        self.errorMessage = '';
	        self.done = false;
			self.getData = getData;

			function getData() {
				sortList = SortService.getAllList();
				return sortList;
			}
			
			function submit() {
	            console.log('Submitting');
	            if (self.unsortedList === undefined || self.unsortedList === null) {
	                console.log('Sorting the entered list and saving it to database', self.unsortedList);
	                sortList(self.unsortedList);
	            } 
	        }
			
			function sortList(unsortedList) {
	            console.log('About to sort and save list');
	            SortService.sortList(unsortedList)
	                .then(
	                    function (response) {
	                        console.log('Sorted and saved successfully');
	                        self.successMessage = 'Data saved successfully';
	                        self.errorMessage='';
	                        self.done = true;
	                        self.unsortedList={};
	                        $scope.myForm.$setPristine();
	                    },
	                    function (errResponse) {
	                        console.error('Error while saving data');
	                        self.errorMessage = 'Error while saving data'; 
	                        self.successMessage='';
	                    }
	                );
	        }

			
			function reset(){
	            self.successMessage='';
	            self.errorMessage='';
	            self.unsortedList={};
	            $scope.myForm.$setPristine(); 
	        }
		}

		]);