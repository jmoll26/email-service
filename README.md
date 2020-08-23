# jm-email-service
Basic API for obtaining a count based on a list of provided email addresses.

This application provides a basic set of filtering/reducing logic to obtain a count of unique email addresses based on a provided un-filtered list.

**Prerequisites:** [Java 11](https://www.oracle.com/java/technologies/javase-downloads.html#JDK11)

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/jmoll26/jm-email-service.git
cd zsearch
```

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the server, cd into the `server` folder and run:
 
```windows
mvnw spring-boot:run
```
 
## Links
Links to use email-service application
* Email reducer API (POST - http:://localhost:8080/email/reduce)
```
{
    "userId": "jmoll",
    "addresses": ["test.email@gmail.com",
                  "test.email@gmail.com",
                  "test.email+spam@gmail.com",
                   "testemail@gmail.com"
    ]
}
```


## Help

PPlease send any questions to jmoll26@gmail.com
