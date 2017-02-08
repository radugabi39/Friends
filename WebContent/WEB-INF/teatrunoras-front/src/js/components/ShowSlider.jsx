import React from "react";
import ImageGallery from 'react-image-gallery';
import { connect } from "react-redux";
import { fetchShowsByReviews } from "../actions/showsActions";
import { IndexLink, Link } from "react-router";

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
      for (var i=0; i < 4; i++) {
        let linkText = (
          <div className="sliderLinkText">
            <div className="sliderLinkTextDesc">{showsByReviews.list[i].description}</div>
            <div className="sliderLinkTextName"><span>{showsByReviews.list[i].name}</span></div>
          </div>
        );
        let link = <Link to={"show/" + showsByReviews.list[i].id} className="sliderLink">{linkText}</Link>
        mappedShowsByReviews.push({
          original: showsByReviews.list[i].avatarURL,
          thumbnail: showsByReviews.list[i].avatarURL,
          description: link
          // description: showsByReviews.list[i].name + '. ' + showsByReviews.list[i].description,
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
