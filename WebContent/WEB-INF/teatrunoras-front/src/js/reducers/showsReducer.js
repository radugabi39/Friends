export default function reducer(state={
    shows: [
      {
        id: 1,
        name: "Moartea unui comis voiajor",
        description: "Piesa cu un comis voiajor care se duce."
      },
      {
        id: 2,
        name: "Cafeneaua",
        description: "Piesa cu Malaele, in care Malaele il joaca pe Malaele tanar, prezent si viitor."
      },
      {
        id: 3,
        name: "Omul perna",
        description: "Perne si crime."
      },
    ],
  }, action) {

    switch (action.type) {
      case "FETCH_SHOWS": {
        return {...state};
      }

      case "FETCH_SHOW": {
        return {
          shows: state.shows.filter(show => show.id == action.payload)
        };
      }
    }

    return state;
}
