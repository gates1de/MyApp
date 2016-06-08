import * as types from './actionTypes';

function addRestaurants() {
	return {
		type: types.ADD_RESTAURANTS
	}
}

function removeAllRestaurants() {
	return {
		type: types.REMOVE_ALL_RESTAURANTS
	}
}
