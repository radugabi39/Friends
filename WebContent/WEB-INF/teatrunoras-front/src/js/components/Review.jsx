// import React from "react";

// export default class Review extends React.Component {
//   constructor(props) {
//     super(props);

//     this.handleSelectChange = this.handleSelectChange.bind(this);
//     this.handleSelectSubmit = this.handleSelectSubmit.bind(this);
//   }

//   handleSelectChange(event) {
//     this.props.onChange(event.target.value, this.props.id); 
//   }

//   handleSelectSubmit(event) {
//     this.props.onSubmit();
//     event.preventDefault();
//   }

//   render() {
//     const reviewId = this.props.id;
//     var selectValue = 1;
//     if (this.props.selectValues[reviewId] !== undefined) {
//       selectValue = this.props.selectValues[reviewId]
//     }

//     return (
//       <li>
//         <div>
//           <h5>Review with RATING ({this.props.rating}) and ID ({reviewId})</h5>

//           <form id={'form-review' + reviewId} onSubmit={this.handleSelectSubmit}>
//             <label>
//               Pick rating:
//               <select className="form-control" value={selectValue} onChange={this.handleSelectChange}>
//                 <option value="1">1</option>
//                 <option value="2">2</option>
//                 <option value="3">3</option>
//                 <option value="4">4</option>
//                 <option value="5">5</option>
//               </select>
//             </label>
//             <input className="btn btn-primary" type="submit" value="Vote" />
//           </form>

//           <div>
//             {this.props.description}
//           </div>
//         </div>
//       </li>
//     );
//   }
// }