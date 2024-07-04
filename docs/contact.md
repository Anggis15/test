#Contact API spec

##Create Contact

Endpoint: POST /api/user/v1/create

Request Body:
```json
{
  "address": "jambi",
  "userId": "1"
}
```

##Get all contact filter by user_id

Endpoint : GET /api/contact/v1/getbyuser/{userId}

##Get all contact 

Endpoint : /api/contact/v1/getall

