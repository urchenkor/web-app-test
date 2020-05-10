# web-app-test
RESTfull web app

The time for automatic translation into status "AWAY" can be changed in StatusRefresherService.java STATUS_REFRESH_TIME (ms)

1.create person
POST method to localhost/8080/persons
json request example:
      {
      "name":"person_name",            // String @Not Null
      "email":"person@email.ua",       // String @Email
      "phoneNumber":"9-999-999-99-99"  // String @Not Null
      }

json response example:
      {
      "id": 1
      }
      
2.get person data
GET method to localhost/8080/persons/{id}

json response example:
      {
      "id": 1,
      "name": "person_name",
      "status": "ONLINE",
      "email": "person@mail.ua",
      "phoneNumber": "8-999-999-99-99"
      }

3.update person status
PATCH to localhost/8080/persons
json request example:
      {
      "id":person_id",                  //Long @Not null
      "status":"person_status"          //StatusEnum {ONLINE, OFFLINE, AWAY} @Not null
      }
      
json response example:
      {
      "id": 1,
      "beforeUpdateStatus": "AWAY",
      "afterUpdateStatus": "ONLINE"
      }



