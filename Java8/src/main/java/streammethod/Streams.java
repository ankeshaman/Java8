package main.java.streammethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

    //Ways to create Stream :
    //Method 1 : using List
    List<Integer> list= Arrays.asList(1,2,3,4,5);
    Stream<Integer> streamOfInt = list.stream();

    //Method 2 : using Arrays
    int[] arr={1,2,3,4,5};
  //  Stream<Integer> strewmArr = (Stream<Integer>) Arrays.stream(arr);

    //Method 3 : using Stream.of
    Stream<Integer> val = Stream.of(1,2,3,4,5);

    //Method 4 : using iterate(generating range of values)
    //it will give infinite range of values
    Stream<Integer> rangeOfVal = Stream.iterate(0,(n)->n+1);
    Stream<Integer> limitVal = Stream.iterate(0,(n)->n+1).limit(100);

    //Method 5 : using Generate
    Stream<Integer> generateVal = Stream.generate(()->(int)Math.random()*100);

}
