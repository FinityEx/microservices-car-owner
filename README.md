# microservices-car-owner

The "car" microservice communicates with the "owner" microservice using OpenFeign in order to establish whether or not the car already has an owner and the POST request can be processed.

If so, the "car" microservice publishes a message to rabbitmq exchange that is then consumed by the "confirmation" microservice logging this fact into console.

The project uses:

-Postgres (for local testing purposes)

-OpenFeign

-RabbitMQ

-Eureka (disabled for kubernetes)

-Zipkin


The project includes both docker and kubernetes configuration files.
