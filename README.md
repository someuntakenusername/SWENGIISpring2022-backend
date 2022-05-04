# Team Blue Flannel - Backend



How To Run Application


1) Make sure front-end cors server step is complete (see Team Blue Flannel - Frontend Read Me)
2) If you are running this application locally on your computer (not pushing to our heroku, skip to set 6)
3) Change all instances of the string "https://blueflannel-cors.herokuapp.com" in this repository to the url that you are running your cors server on
4) Create postgres database using --> docker run --name postgres-db -e POSTGRES_PASSWORD=sam -p 5432:5432 -d postgres
5) If you did not use the exact command above, change the application.properties file to match your database configuration
6) Start application or push to heroku
