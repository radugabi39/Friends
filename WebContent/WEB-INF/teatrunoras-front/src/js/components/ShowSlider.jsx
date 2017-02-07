import React from "react";
import ImageGallery from 'react-image-gallery';
import { connect } from "react-redux";
import { fetchShowsByReviews } from "../actions/showsActions";

@connect((store) => {
  return {
    showsByReviews: store.shows.showsByReviews,
  };
})

export default class ShowSlider extends React.Component {
  componentDidMount() {
    this.props.dispatch(fetchShowsByReviews());
  }

  handleImageLoad(event) {
    // console.log('Image loaded ', event.target)
  }

  render() {
    const { showsByReviews } = this.props;

    var mappedShowsByReviews = [];
    if (typeof showsByReviews.list === 'undefined') {
      mappedShowsByReviews = [];
    }
    else {
      console.log(showsByReviews);
      for (var i=0; i < 4; i++) {
        mappedShowsByReviews.push({
          original: showsByReviews.list[i].avatarURL,
          thumbnail: showsByReviews.list[i].avatarURL,
          description: showsByReviews.list[i].name + '. ' + showsByReviews.list[i].description,
        });
      }
    }
    const images = mappedShowsByReviews;    

    return (
      <ImageGallery
        items={images}
        slideInterval={2000}
        onImageLoad={this.handleImageLoad}/>
    );
  }
}
