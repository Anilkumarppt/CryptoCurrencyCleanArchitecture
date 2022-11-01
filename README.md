
# Clean Architecture Pattern

## Getting Started 

In this Project, I’d like to show you a clean architecture example in an Android app. The main ideas of this pattern, however, can be adapted to every platform and language. Good architecture should be independent of details like platform, language, database system, input, or output.
The layers are the main core of a clean architecture. In our app, we will use three layers: presentation, domain, and model. Each layer should be separated and shouldn’t need to know about other layers. It should exist in its own world and, at most, share a small interface to communicate.

## Layer responsibilities:

* Domain:Contains the business rules of our app. It should provide use cases which reflect the features of our app.

* Presentation:Presents data to the user and also collects necessary data like the username. This is a kind of input/output.

* Model: Provides data for our app. It is responsible for obtaining data from external sources and save them to the database, cloud server, etc.
        Some of intresting questions while we learn about Clean Architecture pattern

* What are these Use Cases/interactors supposed to do?

* Why can’t I call directly the repository from the Presenter/ViewModel?

* Why should I have a Use Case that does nothing other than just calling a Repository, isn’t this an overkill for my app?

* Do I really need a Use Case for each repository method?

### More Details about Clean Architecture follow the below Link

  https://proandroiddev.com/why-you-need-use-cases-interactors-142e8a6fe576
