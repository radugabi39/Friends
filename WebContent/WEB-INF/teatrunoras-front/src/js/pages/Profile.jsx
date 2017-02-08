import React from "react"
import { connect } from "react-redux"

import { fetchUserProfile } from "../actions/profileActions";

@connect((store) => {
  return {
    userProfile: store.userProfile.userProfile,
  }
})

export default class Profile extends React.Component {
	componentDidMount() {
    this.props.dispatch(fetchUserProfile());
  }

	render() {
		const {userProfile} = this.props;
		let reviewsList = [];
		let itemsList = [];
		if (typeof userProfile.revList !== 'undefined') {
			reviewsList = userProfile.revList.map(
				review => 
					<li>
						<div>
							<div>
		            {review.descrReview}
		          </div>
						</div>
					</li>
			);		
		}

		if (typeof userProfile.itemList !== 'undefined') {
			itemsList = userProfile.itemList.map(
				item => 
					<li>
						<div>
							<div>
				           {item.name}
				         </div>
							<div>
				           {item.price} Puncte
				         </div>
							<div>
				           {new Date(item.purchaseDate).toUTCString()}
				         </div>
						</div>
					</li>
			);		
		}

		return (
			<div>
				<div className="page-header">
	        <h1>{userProfile.name}</h1>

	        <div>
	        	<span><i>{userProfile.noPoints} Puncte</i></span>
	        </div>
	      </div>

	      <div>
	      	<h2>Reviews</h2>
	      	<ul>{reviewsList}</ul>
	      </div>

	      <div>
	      	<h2>Purchased Items</h2>
	      	<ul>{itemsList}</ul>
	      </div>

      </div>
		)
	}
}