# microservices-car-owner

The "car" microservice communicates with the "owner" microservice using OpenFeign in order to establish whether or not the car already has an owner and the POST request can be processed.

The project uses:

-Postgres (for local testing purposes)

-Zipkin

-OpenFeign

-Eureka (disabled for kubernetes)


The project includes both docker and kubernetes configuration profiles.
