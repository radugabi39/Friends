import React from "react";
import { connect } from "react-redux";
import { fetchShowsByCreationDate } from "../actions/showsActions";
import { IndexLink, Link } from "react-router";
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
      for (var i=0; i < 6; i++) {
      	mappedShowsByDate.push(
          <li className="col-md-4 homeRecentShowsLi">
            <div style={{backgroundImage: 'url(' + showsByDate.list[i].avatarURL + ')'}} className="homeRecentShowsLiContainer">
              <div className="homeRecentShowsLink">
                <div className="grayOverlay">
                  <Link to={"show/" + showsByDate.list[i].id}>
                    {showsByDate.list[i].name}
                  </Link>
                </div>
              </div>
            </div>
          </li>
        )
      }
    }

    return (
    	<div>
	    	<h1>Home</h1>

	    	<h2>Cele mai discutate spectacole</h2>
  			<ShowSlider />  	

        <div className="container">
    			<h2>Cele mai recente spectacole</h2>
  	    	<ul className="row homeRecentShowsUl">{mappedShowsByDate}</ul>
        </div>
    	</div>
    );
  }
}
