import * as types from '../actions/actionTypes';

const initialState = {
	restaurants : []
}

export default function restaurantReducer(state = initialState, action) {
	switch(action.type) {
		case types.ADD_RESTAURANTS:
			return { restaurants: [action.data] }
		case types.REMOVE_RESTAURANTS:
			return { restaurants: [] }
		default:
			return state
	}
}
