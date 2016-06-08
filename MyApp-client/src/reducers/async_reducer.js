import * as types from '../actions/async/actionTypes';
import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';

export default function asyncReducer(state = {
	isLoading: false,
	data: [],
	error: false }, action = null) {
		switch(action.type) {
			case types.RECV_DATA:
				return Object.assign({}, state, { isLoading : false, data : action.data, error : false});
			case types.REQ_DATA:
				return Object.assign({}, state, { isLoading : false, error : false});
			default:
				return state;
		}
};


