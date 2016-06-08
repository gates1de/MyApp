import React from 'react';
import ReactDOM from 'react-dom';

import configureStore from './store/configureStore';
import App from './containers/App';
import Home from './components/Home';

import { Provider } from 'react-redux'
import { Router, Route, browserHistory, hashHistory, IndexRoute } from 'react-router'
import { syncHistoryWithStore } from 'react-router-redux';
import { createHashHistory } from 'history';

import { fetchData } from './actions/async/actions';

const store = configureStore();
const history = syncHistoryWithStore(hashHistory, store);

function loadData() {
	store.dispatch(fetchData('http://' + location.hostname + '/api/v1/cities/1'));
};

ReactDOM.render(
	<Provider store = { store } >
		<Router history = { history } >
			<Route path="/" component = { App } onEnter={loadData} >
			</Route>
		</Router>
	</Provider>,
	document.getElementById('main')
);
