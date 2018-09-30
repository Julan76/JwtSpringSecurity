# JwtSpringSecurity with SpringBoot 2.0.5.RELEASE
Stateless authentication with JWT

Send to get a bearer (as you want : as user or as admin) : 
`
curl -X POST \
  http://localhost:8080/login \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{"username":"user","password": "1234"
}'
`

Then in the response header, you will get a bearer : 
Authorization : 'Bearer xxx'

You can use it : 
 `
curl -X GET \
  http://localhost:8080/tasks \
  -H 'Authorization: Bearer xxx' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  `
  
  You'll be able to get a list of tasks : 
  
  `[
      {
          "id": 5,
          "taskName": "T1"
      },
      {
          "id": 6,
          "taskName": "T2"
      },
      {
          "id": 7,
          "taskName": "T3"
      },
  ]`    