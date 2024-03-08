# Marketplace
## Table of Contents
* [General purpose](#general-purpose)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Contact](#contact)

## General purpose
>TBA


## Technologies Used
>TBA


## Features
Currently implemented user endpoints:
1. User registration:
````
#POST
/rest-api/register 
<-- Consumes RegistrationTo entity
--> Returns User profile as ProfileTo entity
````
See [RegistrationTo](src/main/java/com/teamchallenge/marketplace/dto/user/RegistrationTo.java), [ProfileTo](src/main/java/com/teamchallenge/marketplace/dto/user/ProfileTo.java).
2. User profile:
````
#GET
/rest-api/users/{id}
<-- Consumes desired user id
--> Returns User profile as ProfileTo entity
````
3. User order history:
````
#GET
/rest-api/users/{id}/history
<-- Consumes desired user id
--> Returns user order history as UserHistoryTo entity
````
See [UserHistoryTo](src/main/java/com/teamchallenge/marketplace/dto/user/UserHistoryTo.java).
4. User favorites:
````
#GET
/rest-api/users/{id}/favorites
<-- Consumes desired user id
--> Returns user favorites as UserFavoritesTo entity 
````
See [UserFavoritesTo](src/main/java/com/teamchallenge/marketplace/dto/user/UserFavoritesTo.java).
## Setup
1. Clone project via Git.
2. Install and run [Docker](https://www.docker.com/).
3. Run command ```docker-compose up -d``` in project directory.

## Contact
- [Linkedin](https://www.linkedin.com/in/denys-filonenko-6a8632163/)
- [Email](mailto:filonenko.denys94@gmail.com)
