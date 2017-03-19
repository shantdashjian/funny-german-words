# funny-german-words
A web application that lists some funny German words. Users can add a new word, display it, update it, and delete it.

![alt text](funny-german-words.png "FunnyGermanWords")

## In This Document:
1. [Application URL](#application-url)
2. [How to Use the Application](#how-touse-the-application)
3. [Architecture and Technologies Used](#architecture-and-technologies-used)

## Application URL
http://www.shaundashjian.com:8080/FunnyGermanWords/

## How to Use the Application
* When first accessing the website, a collection of interactive thumbnails are displayed with a navigation bar at the top of the page
* Hover over a thumbnail to see the funny German word and its literal translation
* Click on the thumbnail to open a detailed description of the word
* In the navigation bar, click on Add to add a new funny word. 
  * This displays a form that you could fill in, providing the word in German, its literal translation, a description, and a picture URL
  * When done, click Add to add the new word. A confirmation message will display
* In the navigation bar, click on List to see a list of all fnny German words available
  * This displays a list with an Edit and Delete buttons for each item
  * Click the Edit button to edit the details of the German word
  * Click the Delete button to delete the word from the list

## Architecture and Technologies Used
The application uses the [Spring Web MVC framework](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) with JSP for the view layer. Development was Test-Driven using JUnit.

  * **The View Layer:**
The JSP uses [Bootstrap](http://getbootstrap.com).
<hr>

[Up](README.md)
