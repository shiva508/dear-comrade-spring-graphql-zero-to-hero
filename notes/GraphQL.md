query {
  allCustomers{
    id,
    name,
    profile {
      id
    }
  }
}


query {
  findByCustomerId(id: 508){
    id,
    name,
    profile {
      id
    }
  }
}

query {
  welcomeUser(user:"Shiva")
}

query {
  welcome
}

query {
  comradeById(id:408){
    id
    name
  }
}

query {
  comrades{
    id,
    name
  }
}
 mutation {
  addComrade(name: "Shiva")
  {
  id,name
	}
}

<-------DGS-------->
query{
  shows {
    title
    releaseYear
  }
}
