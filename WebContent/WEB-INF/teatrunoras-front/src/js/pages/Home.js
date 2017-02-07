import React from "react";
import { connect } from "react-redux";
import { fetchShowsByCreationDate } from "../actions/showsActions";

import ShowSlider from "../components/ShowSlider.jsx";

@connect((store) => {
  return {
    showsByDate: store.shows.showsById,
  };
})

export default class Home extends React.Component {
	componentDidMount() {
    this.props.dispatch(fetchShowsByCreationDate());
  }

  render() {
  	const { showsByDate } = this.props;

  	var mappedShowsByDate = [];
    if (typeof showsByDate.list !== 'undefined') {
      // mappedShowsByDate = showsByDate.list.map(show => <li>{show.name}</li>);
      for (var i=0; i < 6; i++) {
      	mappedShowsByDate.push(<li>{showsByDate.list[i].name}</li>)
      }
    }

    return (
    	<div>
	    	<h1>Home</h1>

	    	<h2>Cele mai discutate spectacole</h2>
  			<ShowSlider />  	

  			<h2>Cele mai recente spectacole</h2>
	    	<ul>{mappedShowsByDate}</ul>
    	</div>
    );
  }
}
