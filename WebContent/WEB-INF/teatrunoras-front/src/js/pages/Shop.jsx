import React from "react";
import { connect } from "react-redux";

import { fetchItems } from "../actions/itemsActions";
import { buyItem } from "../actions/itemsActions.js";

@connect((store) => {
  return {
    items: store.items.items,
  }
})

export default class Shop extends React.Component {
	componentDidMount() {
    this.props.dispatch(fetchItems());
  }

  dispatchBuyItem(itemId) {
  	return this.props.dispatch(buyItem(itemId)); 
  }

  render() {
  	const {items} = this.props;
  	let itemsList = [];

  	if (typeof items.list !== 'undefined') {
			itemsList = items.list.map(
				item => 
					<li key={item.id}>
						<div>
							<div>{item.name}</div>
							<div>{item.description}</div>
							<div>{item.price}</div>
							<div>{item.stock}</div>
							<div><span className="btn btn-primary" onClick={(itemId) => this.dispatchBuyItem(item.id)}>Cumpara</span></div>
						</div>
					</li>
			);		
		}

    return (
    	<div>
    		<div className="page-header">
	        <h1>Oferte</h1>
	      </div>

	    	<ul>{itemsList}</ul>
    	</div>
    );
  }
}