import { combineReducers } from "redux"

import shows from "./showsReducer"
import reviews from "./reviewsReducer"

export default combineReducers({
  shows, reviews
})
