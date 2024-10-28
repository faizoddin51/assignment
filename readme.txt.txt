# This repository contains the code for the given assignment

# To use the test transfer account service below stps needs to be followed
	1. Import the code to local and run the project from the below location
		C:\Users\HP\Desktop\Challenge\challenge\src\main\java\com\dws\challenge\ChallengeApplication.java
	2. use the below service to create two inmemory users 
		a.  URI : http://localhost:18080/v1/accounts/create
			Method : POST
			Body: {
				"accountId": "Source",
				"balance": 100
			  }
		b.  URI : http://localhost:18080/v1/accounts/create
			Method : POST
			Body: {
				"accountId": "Destination",
				"balance": 10
			  }
			  
	3. Use the below service to place a transfer request
		URI : http://localhost:18080/v1/accounts/transfer
		Method : POST
		Body : {
			"accountFrom": "Source","accountTo": "Destination",
			"amountToTransfer": "10"
			}
	4. After the tranfer we can validate the account balence of the source and destination as follow
		URI : http://localhost:18080/v1/accounts/Source
		URI : http://localhost:18080/v1/accounts/Destination
		Method : GET
	
# To make it production ready we have to follow the below approach
	1. Instead of using in memory app we should use a database service to story and retrive the information
	2. We have to purchase a domain hostname using whih users will be able to access the application.
	3. We can explore the options to host the app on clouds using amazon EC2 or GCP to host the applicaion.
	4. To Achive asunc communication we can impliment pub-sub tools like Kafka or Google Pub-sub
	5. We have to create a artifactory and use Docker to build and deploy the image.
	6. We can setup Jenkins pipeline to achive CI-CD.
	7. We have to create a front end app which will make use of the endpoints in REACT OR ANGULAR depending upon org standards.