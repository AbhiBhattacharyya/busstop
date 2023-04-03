## About the Application
This application finds which bus lines have the most bus stops on
their route, and lists the top 10 as clear text. Application also lists the names of every
bus stop of the bus line that has the most stops. Bus stops are not sorted in any order.

### This application fetches the relevant data by calling below APIs
http://www.trafiklab.se/api/sl-hallplatser-och-linjer-2

## How to build and run the application
#### build with  - mvn clean install
#### run below command from terminal after build from project root directory
java -jar target/busstop-0.0.1-SNAPSHOT.jar

#### open your Browser and run - http://localhost:8099/getBusTops
OR curl -GET http://localhost:8099/getBusTops from terminal

### Troubleshoot

This application runs on port 8099.
If any of your local application running on the same port please modify the property server.port
in application.properties. Set it to any available port and re-build the applicatuon.



