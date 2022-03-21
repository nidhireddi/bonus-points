# Checkout from git:
    git clone https://github.com/nidhireddi/bonus-points
    cd bonus-points
    
# Build Project in local
    mvn clean install

# Testing:
    mvn test

# Running the app:
    mvn spring-boot:run 


# APIs With Examples:
* [GET] /retailer/getAllTransactions - gets all transactions
* [GET] /retailer/customer-id/104 - gets all transactions belonging to customer 101
* [GET] /retailer/get-bonus-points?amount=230 - gets bonus points based on amount USD 230
* [GET] /retailer/get-bonus-points-by-customer-id/101 - gets bonus points based on the transactions done by customer with id 101
* [GET] /retailer/4 - gets the transaction with id 4
* [POST with payload] / - saves a transactions

# Sample Postman collection:
* src/test/resources/Bonus-Service.postman_collection.json


#Default Configuration (defines the break points and multipliers for the bonus):
* firstThreshold=50
* firstThresholdMultiplier=1
* secondThreshold=100
* secondThresholdMultiplier=2

### Dependencies
* spring-boot-starter-web
* lombok
* spring-boot-starter-test (test scope)
