import React from 'react';
import AppBar from 'material-ui/AppBar';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

let injectTapEventPlugin = require("react-tap-event-plugin");
injectTapEventPlugin();

const muiTheme = getMuiTheme();

function openList() {
	document.getElementById('restaurants_list').classList.toggle('open');
}

const NavigationBar = () => (
		<div id="nav_bar">
			<MuiThemeProvider muiTheme={muiTheme}>
				<AppBar
					title = "MyApp"
					// onLeftIconButtonTouchTap = { openList }
				/>
			</MuiThemeProvider>
		</div>
);

export default NavigationBar;
