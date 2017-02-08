import React from "react"
import { connect } from "react-redux"

import { fetchShows } from "../actions/showsActions";

import Show from '../components/Show.jsx';

@connect((store) => {
  return {
    shows: store.shows.shows,
  };
})
export default class Shows extends React.Component {
  componentDidMount() {
    this.props.dispatch(fetchShows());
  }

  render() {
    const { shows } = this.props;

    var mappedShows;
    if (typeof shows.list === 'undefined') {
      mappedShows = [];
    }
    else {
      mappedShows = shows.list.map(show => <Show key={show.id} id={show.id} name={show.name} description={show.description} avatar={show.avatarURL} />);
    }

    return (
      <div>
        <div className="page-header">
          <h1>Spectacole</h1>
        </div>
        
        <ul>{mappedShows}</ul>
      </div>
    )
  }
}
