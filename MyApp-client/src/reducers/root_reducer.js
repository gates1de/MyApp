import restaurantReducer from './restaurant_reducer';
import asyncReducer from './async_reducer';
import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';

const rootReducer = combineReducers({
		routing: routerReducer,
		restaurant: restaurantReducer,
		async: asyncReducer
});

export default rootReducer;
