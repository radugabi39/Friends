import React from "react";
import { connect } from "react-redux"

import { fetchSingleShow } from "../actions/showsActions.js";

@connect((store) => {
  return {
    show: store.shows.shows,
  };
})

export default class Shows extends React.Component {
	fetchSingleShow() {
		this.props.dispatch(fetchSingleShow(this.props.params['id']));
	}

  render() {
    console.log(this.props);

    return <div>123</div>
  }
}
