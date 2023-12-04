Project Outline
This is a proof of concept project.

The product owner wants to explore the possibility of having a MongoDB and cloud-based solution for accessing information about movies, allowing users to post or read comments on movies and managing a film schedule for cinemas.

A sample database (sample_mflix) is provided which includes details of movies, comments, "theaters" and users.

Two products are required: - A RESTful API which allows full CRUD access to the existing data for these 4 collections

Required Technologies
The persistence mechanism must be MongoDB
The database must be hosted on MongoDB Atlas using the "Shared" (free) tier hosted on AWS
The database must be based on the sample_mflix database, which is provided for use within MongoDB - this tutorial explains how to install the sample
Spring Boot must be used for the API
Spring Data MongoDB must be used for accessing the database from both the API and the Web application
The code repository for the project must be hosted on GitHub
Testing
The API itself should be internally tested using unit testing
The API Testing framework should make use of good modeling (Connection, Injection and DTOs)
The API Framework should also be internally tested
Where possible, Code coverage should be reported on
Consider using mocking when internally testing the RESTful API