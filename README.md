# Realtor Platform

A platform where realtors can display all the properties they have available to their clients.

## How to run:

1. Clone the Project locally
2. Run the Back-end project using an IDE

## Paths working:

    CREATE REALTOR: **POST** -> http://localhost:8080/realtor

    {
      "name": "username",
      "imageURL": "https://user_image_url",
      "email": "user.email@exemple.com",
      "phoneNumber": "000000000"
    }
----
    UPDATE REALTOR: **PUT** -> http://localhost:8080/realtor

    {
      "id": 1,
      "phoneNumber": "000000000"
    }
----
    LIST REALTORS: **GET** -> http://localhost:8080/realtor
----
    CREATE RESIDENCE: **POST** -> http://localhost:8080/residence

    {
        "realtorId": 1,
        "CEP": "00000000",
        "residenceKind": "HOUSE",
        "address": "Addres exemple",
        "addressComplement": "complement exemple",
        "totalBedrooms": 2,
        "totalBathrooms": 1
    }
----
    LIST RESIDENCE TYPES: **GET** -> http://localhost:8080/residence/type

## Future improvements:

- [ ] Add all the basic paths to both the realtor and residence
- [ ] Add the Front-end

## Authors:

- [Jonas Felix](https://github.com/Jonas-petty)
- [José Marcos](https://github.com/cacos00)
