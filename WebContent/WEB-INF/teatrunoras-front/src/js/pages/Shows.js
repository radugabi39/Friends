import React from "react"
import { connect } from "react-redux"

import { fetchShows } from "../actions/showsActions";

import Show from '../components/Show.jsx';

@connect((store) => {
  console.log(store);
  return {
    shows: store.shows.shows,
  };
})
export default class Shows extends React.Component {
  // fetchShows() {
  //   this.props.dispatch(fetchShows());
  // }

  componentWillMount() {
    this.props.dispatch(fetchShows());
  }

  render() {
    const { shows } = this.props;

    // shows = this.fetchShows.bind(this);
    console.log(shows);

    // if (!shows.length) {
      // return <button onClick={this.fetchShows.bind(this)}>load tweets</button>
    // }

    const mappedShows = shows.map(show => <Show id={show.id} name={show.name} description={show.description} />);

    return (
      <div>
        <ul>{mappedShows}</ul>
      </div>
    )
  }
}
