export default function reducer(state={
    shows: [
      {
        id: 1,
        name: "Moartea unui comis voiajor",
        descriere: "Mare descriere, patroane."
      },
      {
        id: 2,
        name: "Cafeneaua",
        descriere: "Mare descriere, patroaneeeeee."
      },
      {
        id: 3,
        name: "Omul perna",
        descriere: "Perne si crime."
      },
    ],
  }, action) {

    switch (action.type) {
      case "FETCH_SHOWS": {
        return {...state}
      }
    }

    return state
}
