import React from "react"
import { connect } from "react-redux"

import { fetchTweets } from "../actions/tweetsActions"

@connect((store) => {
  return {
    tweets: store.tweets.tweets,
  };
})
export default class Shows extends React.Component {
  fetchTweets() {
    this.props.dispatch(fetchTweets())
  }

  render() {
    const { tweets } = this.props;

    if (!tweets.length) {
      return <button onClick={this.fetchTweets.bind(this)}>load tweets</button>
    }

    const mappedTweets = tweets.map(tweet => <li>{tweet.text}</li>)

    return <div>
      <ul>{mappedTweets}</ul>
    </div>
  }
}
