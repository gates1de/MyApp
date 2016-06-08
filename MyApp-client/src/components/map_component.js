import { default as React, Component } from "react";
import { default as update } from "react-addons-update";

import { GoogleMapLoader, GoogleMap, Marker } from "react-google-maps";
import { triggerEvent } from "react-google-maps/lib/utils";


export default class Map extends Component {

  state = {
    markers: [{
      position: {
        lat: 35.6788776,
        lng: 139.7673199
      },
      key: 'Japan',
      defaultAnimation: 2,
    }],
  }

  constructor(props, context) {
    super(props, context);
  }

  handleMarkerClick(index, event) {
    console.log(`index = ${index}`);
  }

  render() {
    return (
      <div id="map">
        <GoogleMapLoader
          containerElement={
            <div
              style = {
                { width: '100%' },
                { height: '100%' }
              }
              {...this.props}
            />
          }
          googleMapElement={
            <GoogleMap
							// この設定でないとMapの中心がブラウザの真ん中になる
							ref = { googleMap => {
								setTimeout(() => {
              	  if (!googleMap) {
              	    return;
              	  }
              	}, 50);
							}}
              defaultZoom = { 15 }
              defaultCenter = { { lat: 35.6788776, lng: 139.7673199 } }
              options = {
                { scrollwheel: false }
              }
            >
              { this.state.markers.map((marker, index) => {
                return (
                  <Marker
                    { ...marker }
                    onClick = { this.handleMarkerClick.bind(this, index) }
                  />
                );
              })}
            </GoogleMap>
          }
        />
      </div>
    );
  }

}
