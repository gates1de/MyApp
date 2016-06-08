import { createStore, combineReducers, applyMiddleware } from 'redux';

import rootReducer from '../reducers/root_reducer';

import thunk from 'redux-thunk';

import { routerReducer } from 'react-router-redux'


export default function configureStore(initialState){
	const store = createStore(
			combineReducers({
				rootReducer,
				routing: routerReducer
		}), initialState, applyMiddleware(thunk)
	);

	return store;
};
