package main.java.streammethod;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Optionals {

    //Optional : its just like a box which contains values or not contains
    //How to creare optional :
    //Methos 1 : Optional.of
    Optional<String> mOptionalOf = Optional.of("Ram");
    Optional<String> optionalOf2 = Optional.of(null);

    //Methos 2 : Optiona.ofNullable() : it's used to tell that optional can also contain null val;
    Optional<String> name = Optional.ofNullable("Ram");

    //Methos to check if value is present in Optional or not :
    /*if(mOptionalOf.isPresent()){
        System.out.println(mOptionalOf.get());
    }*/

    //name.ifPresent(System.out::println);

    // Using else method to fetch the value from Optional if present else will give some default val
    String fetchedVal = name.orElse("NA");

    //using orElseThrow which can be used to throw exception if val is not present in optional box
    //it expects Supplier as argument which is a functional interface with get abstract method
    //Supplier wont take anything but will return something
    String usingThrow = name.orElseThrow(NoSuchElementException::new);

}
