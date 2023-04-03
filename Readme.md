## About the Application
This application finds which bus lines have the most bus stops on
their route, and lists the top 10 as clear text. Application also lists the names of every
bus stop of the bus line that has the most stops. Bus stops are not sorted in any order.

### This application fetches the relevant data by calling below APIs
http://www.trafiklab.se/api/sl-hallplatser-och-linjer-2

## How to build and run the application
#### build with  - mvn clean install
#### run com.ab.assignment.sbab.busstop.BusstopApplication
#### open your Browser and run - http://localhost:8080/getBusTops
OR curl -GET http://localhost:8080/get from terminal


