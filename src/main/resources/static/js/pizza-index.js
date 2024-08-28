'use strict'

const pizzaSearch = document.getElementById('pizzaSearch');

const searchInput = document.getElementById('searchInput');

pizzaSearch.addEventListener('submit', function(e){
	
	e.preventDefault();
	 
	const formAction = 'pizzas/findByNome/' + searchInput.value;
	
	pizzaSearch.action= formAction;
	
	pizzaSearch.submit();
	
})



