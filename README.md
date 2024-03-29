# Parking lot

We at [Sahaj](https://sahaj.ai) use Parking lot problem statement to jam/pair together. This repository presents base code, tests, setup instructions as well as the problem statement to get you started.

## Problem statement overview

Model a parking lot that exhibits following characterstics.

* A parking lot should be able to park and un-park vehicles
* Parking lot supports 4 vehicle types: Bikes, Trucks, Cars and SUVs
* The spot to accomodate these vehicles in Parking lots are different. They cannot be used interchangably. The number of spots for each type are fixed
* If a spot is available then a parking ticket is issued for the vehicle
* A ticket can be used to unpark the vehicle and charge will be calculated
* The fare is calculated refering PriceConfig.json and can be configured as well.
  Currently the pricing is implemented for different Places of Parking with 
  these criteria of pricing

### Mall

| Base rate | Vehicle type | Duration(Hours) |
|-----------|--------------|-----------------|
| Rs. 10    | Bike         | 1               |
| Rs. 20    | Car          | 1               |
| Rs. 50    | Truck.       | 1               |
| Rs. 20    | SUV          | 1               |
| Rs. 50    | BUS.         | 1               |

### Stadium

| Base rate | Vehicle type | Duration(Hours) |
|-----------|--------------|-----------------|
| Rs. 30    | Bike         | 0-4             |
| Rs. 60    | Bike         | 4-12            |
| Rs. 100   | Bike         | >12             |
| Rs. 60    | Car          | 0-4             |
| Rs. 120   | Car          | 4-12            |
| Rs. 200   | Car          | >12             |
| Rs. 60    | SUV          | 0-4             |
| Rs. 120   | SUV          | 4-12            |
| Rs. 200   | SUV          | >12             |

### Airport

| Base rate | Vehicle type | Duration(Hours) |
|-----------|--------------|-----------------|
| Rs. 0     | Bike         | 0-1             |
| Rs. 40    | Bike         | 1-8             |
| Rs. 60    | Bike         | 8-24            |
| Rs. 80    | Bike         | >=24 Each Day   |
| Rs. 60    | Car          | 0-12            |
| Rs. 80    | Car          | 12-24           |
| Rs. 100   | Car          | >=24 Each Day   |
| Rs. 60    | SUV          | 0-12            |
| Rs. 80    | SUV          | 12-24           |
| Rs. 100   | SUV          | >=24 Each Day   |

## Code Setup

The code can be setup in your favorite code editor. Follow instructions to set it up

### Instructions

* Install Java 11 to setup the code - Code uses Java 11 syntax for the existing code
* Project includes a `Maven` binary to install Maven locally as needed to manage dependencies
* JUnit 5 - Project uses Junit 5 tests
* `git clone https://github.com/sahajsoft/parking-lot.git`
* Open in a code editor. We prefer [IntelliJ Idea](https://www.jetbrains.com/idea/download/#section=mac), but other code editors that you are comfortable with should work as well.
* Execute JUnit tests in code editor or command line `./mvn test`
* All test cases are passing successfully
* As long as you have reached this point, you are ready to start pairing
* Refactor/update code if you think there are minor improvements can be made. This is not a pre-requisite but don't hold yourself back if you would like to do this

### Additional instructions

* Pairing helps, so please consider setting up [POP remote pairing tool](https://pop.com/) ahead of time for a seamless pairing experience
* Feel free to refactor and change code if you think it can be improved and for pairing exercise your modified version can be the starting base for new changes
* During pairing we prefer Red-Green refactor. It helps us refactor incrementally and keeps code functional at all times. If you are not familiar, please take a moment to read up on different [workflows of refactoring](https://martinfowler.com/articles/workflowsOfRefactoring/) ahead of your pairing
