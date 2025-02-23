package main.java.streammethod;


import java.util.function.Consumer;

public class Consumers {

    //Consumer<Integer>
    //Note : Consumer is a functional Interface which has one abatract method
    //         i.e., Accept and one Default method i.e., andThen
    //         both can take any argument(String,Integer, Boolean etc)
    //         it only takes the val and dont give anything

    // Consumer to display a number
    Consumer<Integer> display = (a -> System.out.println(a));

    // Implement display using accept()
    //display.accept(10);

    Consumer<String> consum=(str)->System.out.println(str);
    //consum.

	/*Consumer<String> cons1=(str)->System.out.println(str);
	cons1.accept("Jai Sri Ram");
	Consumer<String> cons2=(str)->System.out.println(str);

	//It(andThen) will 1st print cons2.accept and then cons1.accept
	//andTHen is a default method in COnsumer and Accept is abstract method
	cons2.andThen(cons1).accept("Jai Hanuman");*/


}
