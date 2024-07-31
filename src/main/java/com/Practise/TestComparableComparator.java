package com.Practise;

import java.lang.reflect.Array;
import java.util.*;

/*64

Use Comparable:

if the object is in your control.
if the comparing behaviour is the main comparing behaviour.
Use Comparator :

if the object is outside your control and you cannot make them implement Comparable.
when you want comparing behaviour different from the default (which is specified by Comparable) behaviour.
*/


/*
 A  object is capable of comparing
 itself with another object. The class itself must
 implements the java.lang.Comparable
 interface to compare its instances.
 */

class Actor{
    String name;
    int weight;
    int movieCount;

    Actor(String name, int weight, int movieCount){
        this.name = name;
        this.weight = weight;
        this.movieCount = movieCount;
    }
}

//comparator with lambda expression
/* * *
* Comparator<User> firstNameSorter = (o1, o2) -> o1.firstName().compareTo(o2.firstName());
* * */

public class TestComparableComparator {
  public static void main(String[] args) {
      List<Actor> ac=new ArrayList<>();
      ac.add(new Actor("A",1,1));
      ac.add(new Actor("B",2,2));
      ac.add(new Actor("C",3,3));
      ac.add(new Actor("D",4,4));
      //Collections.sort(ac);
      // collection sort will show compilation error if comparable is not implemtned


    //test comparable
      System.out.println("********TEST COMPARABLE***********");
      ArrayList<Movie> list = new ArrayList<Movie>();
      list.add(new Movie("Force Awakens", 8.3, 2015));
      list.add(new Movie("Star Wars", 8.7, 1977));
      list.add(new Movie("Empire Strikes Back", 8.8, 1980));
      list.add(new Movie("Return of the Jedi", 8.4, 1983));

      Collections.sort(list);

      System.out.println("Movies after sorting : ");
      for (Movie movie: list)
      {
          System.out.println(movie.getName() + " " +
                  movie.getRating() + " " +
                  movie.getYear());
      }
      System.out.println("********TEST COMPARATOR***********");
      ArrayList<Movie> list1 = new ArrayList<Movie>();
      list1.add(new Movie("Force Awakens", 8.3, 2015));
      list1.add(new Movie("Star Wars", 8.7, 1977));
      list1.add(new Movie("Empire Strikes Back", 8.8, 1980));
      list1.add(new Movie("Return of the Jedi", 8.4, 1983));

      // Sort by rating : (1) Create an object of ratingCompare
      //                  (2) Call Collections.sort
      //                  (3) Print Sorted list
      System.out.println("Sorted by rating");
      RatingCompare ratingCompare = new RatingCompare();
      Collections.sort(list1, ratingCompare);
      for (Movie movie: list1)
          System.out.println(movie.getRating() + " " +
                  movie.getName() + " " +
                  movie.getYear());


      // Call overloaded sort method with RatingCompare
      // (Same three steps as above)
      System.out.println("\nSorted by name");
      NameCompare nameCompare = new NameCompare();
      Collections.sort(list1, nameCompare);
      //or List.sort(nameCompare) //directly pass comparator
      for (Movie movie: list1)
          System.out.println(movie.getName() + " " +
                  movie.getRating() + " " +
                  movie.getYear());

      // Uses Comparable to sort by year
      System.out.println("\nSorted by year");
      Collections.sort(list1);
      for (Movie movie: list1)
          System.out.println(movie.getYear() + " " +
                  movie.getRating() + " " +
                  movie.getName()+" ");
  }

}

class Movie implements Comparable<Movie> {

  private double rating;
  private String name;
  private int year;

  // Constructor
  public Movie(String nm, double rt, int yr) {
    this.name = nm;
    this.rating = rt;
    this.year = yr;
  }

  // Getter methods for accessing private data
  public double getRating() {
    return rating;
  }

  public String getName() {
    return name;
  }

  public int getYear() {
    return year;
  }

  @Override
  public int compareTo(Movie movie) {
    return this.year - movie.year;
  }
    }

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie>
{
    public int compare(Movie m1, Movie m2)
    {
        if (m1.getRating() < m2.getRating()) return -1;
        if (m1.getRating() > m2.getRating()) return 1;
        else return 0;
    }
}

// Class to compare Movies by name
class NameCompare implements Comparator<Movie>
{
    public int compare(Movie m1, Movie m2)
    {
        return m1.getName().compareTo(m2.getName());
    }
}


/*
*
Comparable should be used when you compare instances of the same class.

Comparator can be used to compare instances of different classes.

Comparable is implemented by the class which needs to define a natural ordering for its objects. For example, String implements Comparable.

In case a different sorting order is required, then, implement comparator and define its own way of comparing two instances.
*
*
* https://java-journal.blogspot.com/2011/01/when-to-use-comparable-and-when-to-use.html
* */


/* Java 8 lambda way of comparing
* @FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
*
*Comparator<Integer> comparator = (i1, i2) -> Integer.compare(i1, i2);
*
*
*
*class Simpson implements Comparable<Simpson> {
    String name;

    Simpson(String name) {
        this.name = name;
    }

    @Override
    ( simpson) -> {
        return this.name.compareTo(simpson.name);
    }
}
* simpsons.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
* */