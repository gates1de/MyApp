import React from 'react';
import {List, ListItem} from 'material-ui/List';
import Restaurant from 'material-ui/svg-icons/maps/restaurant';
import Bar from 'material-ui/svg-icons/maps/local-bar';

import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

const muiTheme = getMuiTheme();

const RestaurantsList = () => (
		<div id="restaurants_list" className="list">
			<MuiThemeProvider muiTheme={muiTheme}>
				<List>
					<ListItem primaryText="みよし食堂" leftIcon={<Restaurant />} />
      		<ListItem primaryText="居酒屋 乙" leftIcon={<Bar />} />
      		<ListItem primaryText="レストラン グーテンターク" leftIcon={<Restaurant />} />
      		<ListItem primaryText="バー プログレス" leftIcon={<Bar />} />
      		<ListItem primaryText="Moomin Cafe" leftIcon={<Restaurant />} />
				</List>
			</MuiThemeProvider>
		</div>
);

export default RestaurantsList;
