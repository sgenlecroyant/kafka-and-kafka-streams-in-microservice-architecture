#### This project demonstrates how Apache Kafka can be leveraged in the microservice architecture following the **Asynchronous Request-Reply** and avoid relying on the classic **Synchrous Http Request-Response** to improve performance and have the high throughput.

** I will be implementing Big Data Processing in this project with one of the emrging technologies, ____Kafka Streams__, to process the business logic from the data flowing in the system.


---
4 Service Apps are involved in this project:

* the __MainOrder-App__: For Customers' Orders
* The __Trend Service App__: For to find trending products in a particular region, country, just any target location
* The __Storage App__: For storage services, sending data into the database, data warehouse, we will be using MySQL and Elasticsearch, plus Kibana for later visualization
* The __Reward Service App__: For rewarding purposes, we can use __Email Services__, __WhatsApp__, and any other service to notify the customers and let them know about their prizes

```
Technologies used in this project:

1. Spring Web
2. Spring Data JPA
3. MySQL
4. Elasticsearch
5. Apache Kafka
6. Kafka Streams
7. H2 Database for the development environment
```