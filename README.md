# order
SpringBoot + Hibernate + MYSQL (simple RESTful endpoint that uses GOOGLE Map APIs)

*Prerequisite to run this app
A. *running MYSQL database
B. *db user: root/123456 (can use any other user existing user just update at the application.properties file
C. *database schema name 'order' ; attached start.sh in root project folder will be use to create schema and user if error kindly create manually [ schema: order , user: root/123456 ]
D. *ensure and update the below required values in property file located in '\src\main\resources\application.properties'
    spring.datasource.username=root 
    spring.datasource.password=123456
    google.api.key=<*REQUIRED VALID USE GOOGLE KEY>
E. *DO NOT FORGET THE VALUE FOR VALID GOOGLE API KEY as mentioned above
F. IDE with bundled maven plugin recommended Eclipse for Java EE developer

Steps to run:

1. Import as existing maven project into ecplise IDE
2  Right click on the root project folder and do MAVEN > UPDATE PROJECT ; please wait till all dependencies is loaded. 
3. Ensure MYSQL is running with the schema: order , and user specified in application (mentioned in above section C.)
4. Update application.properties as mentioned  above section D,E.
5. Run application Go to : order/OrderApplication.java do right click and RUN AS JAVA APPLICATION
6. Console should show springboot logger with the error and at the bottom should mentioned the running  Tomcat and port
7. In the browser access http://localhost:8080/swagger-ui.html 
8. Sample application documentation  should show, click on [ order-controller : Order Controller ] 3 endpoint should be available.

TO TEST:
* Sample Google Map Coordinates (you may use this sample input duting testing): 
	- 7.131429, 125.613342
	- 7.097355, 125.599271
* Use SWAGGER UI as mentioned above section 8. just click on each project node and specify params as needed then click button TRY IT OUT.
* You may also use POSTMAN or any familiar webservice testing tool with the below details:
- OrderList endpoint
	- uri and params: http://localhost:8080/orders?page=1&limit=2'
	- method : GET
	
- PlaceOrder endpoint
	- uri: http://localhost:8080/orders
	- params (json array [string]) : {
					  "destination": [
					   7.090817, 125.606352
					  ],
					  "origin": [
						7.089987, 125.605633
					  ] }
	- method: POST
	
- TakeOrder endpoint
	- uri: http://localhost:8080/orders
	- params:
		-   int: order#
		- json : { "status": "TAKEN" }
	- method: PATCH
