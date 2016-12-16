import React from "react"
import { connect } from "react-redux"

import Show from '../components/Show.jsx';

@connect((store) => {
  return {
    shows: store.shows.shows,
  };
})
export default class Shows extends React.Component {
  render() {
    const { shows } = this.props;
    const mappedShows = shows.map(show => <Show id={show.id} name={show.name} description={show.description} />);

    return <div>
      <ul>{mappedShows}</ul>
    </div>
  }
}
