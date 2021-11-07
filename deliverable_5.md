## Description
The system we are developing is an app, called “foodWeb”, which will simplify searching and sharing recipes. The problem of the inefficient organization of recipes negatively affects those looking to plan their meals or cook; the impact of which is inefficient time spent looking for recipes and money spent on unnecessary ingredients. For those who are actively looking for new recipes, FoodWeb is a meal organization app that allows users to find, organize, and share recipes. Unlike cookbooks, Google, or social media, our product focuses on an ever-expanding library of recipes as the main content source the user interacts with. The server will hold an Api for pre-existing recipes users can search through as well as new ones they will be able to create. The server will also hold the list of ingredients and the user’s personalized saved list. The client-side of the system will develop a live feed that users can interact with and see new recipes that have just been uploaded/ Here the users are also able to search through the recipe Api and their personal “pantry” or saved list of recipes/ingredients. 

## Architecture
We are using a 2-layer architecture for the client, with layers for UI and for interaction with the database and server-side code.

![Architecture](Sketches&Diagrams\architecture_diagram.jpg)

## Class Diagram
![Class Diagram](Sketches&Diagrams\class_diagram_d5.jpg)

## Sequence Diagram


## Design Patterns
Bridge Pattern: This design pattern allows the main feed to be update by both the user and the moderator

![Design Pattern 1](Sketches&Diagrams\design_pattern_1.jpg)

Composite

![Design Pattern 1](Sketches&Diagrams\design_pattern_2.jpg)

## Design Principles
Single responsibility principle: [SearchRecipe.java](https://github.com/CS386Group2/FoodWeb/blob/main/Client/app/src/main/java/group2/foodWeb/recipes/SearchRecipe%20(2).java) : a method that only loops through a database and searches for a match. 

open/closed principle: [Recipe.java](https://github.com/CS386Group2/FoodWeb/blob/main/Client/app/src/main/java/group2/foodWeb/recipes/Recipe.java): This piece of code/class follows the open-closed principle because it is designed as a function to upload recipes, so it is open for use but the source code will not be changed, so it is closed for modification.