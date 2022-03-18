# Checkout from git:
    git clone <url>
    cd reward-points

# Testing:
    mvn test

# Running the app:
    mvn spring-boot:run 


# APIs With Examples:
* [GET] /retailer/getAllTransactions - gets all transactions
* [GET] /retailer/customer-id/104 - gets all transactions belonging to customer 101
* [GET] /retailer/get-reward-points?amount=230 - gets reward points based on amount USD 230
* [GET] /retailer/get-reward-points-by-customer-id/101 - gets reward points based on the transactions done by customer with id 101
* [GET] /retailer/4 - gets the transaction with id 4
* [POST with payload] / - saves a transactions

# Sample Postman collection:
* src/test/resources/Rewards-Service.postman_collection.json


#Default Configuration (defines the break points and multipliers for the rewards):
* firstThreshold=50
* firstThresholdMultiplier=1
* secondThreshold=100
* secondThresholdMultiplier=2

### Dependencies
* spring-boot-starter-web
* lombok
* spring-boot-starter-test (test scope)