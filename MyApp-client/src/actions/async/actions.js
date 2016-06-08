import * as types from './actionTypes';
import axios from 'axios';

function requestData() {
	return { type : types.REQ_DATA }
};

function receiveData(json) {
	return {
		type : types.RECV_DATA,
		data : json
	}
};

export function fetchData(url) {
	return function(dispatch) {
		dispatch(requestData());

		return axios({
			url : url,
			timeout : 10000,
			method : 'get',
			responseType: 'json'
		})
		.then(function(response) {
			dispatch(receiveData(response.data));
			console.log(response.data);
		})
	}
};
