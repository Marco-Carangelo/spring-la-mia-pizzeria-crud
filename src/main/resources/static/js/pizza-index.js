'use strict'

//Form element
const pizzaSearch = document.getElementById('pizzaSearch');

//Button element
const searchSubmit = document.getElementById('searchSubmit');

//Input element
const searchInput = document.getElementById('searchInput');

searchSubmit.addEventListener('click', function(){
	
	const formAction = 'pizzas/findByNome/' + searchInput.value;
	
	pizzaSearch.action= formAction;
	
	pizzaSearch.submit();
	
})

pizzaSearch.addEventListener('submit', function(event){
	
event.preventDefault();

})



