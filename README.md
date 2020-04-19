# Coding Exercise

This is the coding exercise project

# Setup/Pre-Requisties

* Java 8
* Maven
* Eclipse/Intellij/STS

# Starting the app

To start the application, goto root directory of the `codingexercise` and execute command `mvn spring-boot:run`

`~/application-development/codingexercise $mvn spring-boot:run`
* Use url `http://localhost:8080/game/5/2` for valid output
* Use url `http://localhost:8080/game/0/2` for error scenario

###### Generic url `http://localhost:8080/game/{number}/{position}` where number = number of children playing the game and position = kth position which gets elimimated

 

# Test Cases
* ChildrenGameControllerTest
* ChildrenGameServiceTest
* ChildrenGameValidatorTest