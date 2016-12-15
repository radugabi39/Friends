import React from "react"
import { connect } from "react-redux"

@connect((store) => {
  return {
    shows: store.shows.shows,
  };
})
export default class Shows extends React.Component {
  render() {
    const { shows } = this.props;
    const mappedShows = shows.map(show => <li>{show.name}</li>);

    return <div>
      <ul>{mappedShows}</ul>
    </div>
  }
}
