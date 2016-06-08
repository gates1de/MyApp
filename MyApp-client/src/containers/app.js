import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import { connect } from 'react-redux';

import Map from '../components/map_component';
import NavigationBar from '../components/navigation_bar_component';
import RestaurantsList from '../components/restaurants_list_component';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import '../styles/style.scss';

class App extends Component {

	constructor(props) {
		super(props);
	}

	render() {
		return (
			<div id="app">
				<NavigationBar />
				<RestaurantsList />
				<Map />
			</div>
		)
	}

}

const ConnectedApp = connect(
	state => ({ 
		routerState: state.router,
		restaurant: state.restaurant
	})
)(App)

export default ConnectedApp;
