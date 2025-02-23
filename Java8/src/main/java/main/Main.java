package main.java.main;


import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import main.java.model.Student;
import main.java.streammethod.MethodReference;
import main.java.streammethod.TriConsumers;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        //Note : forEach expect argument as Consumer interface

        //Method Reference : used to replace lambda function
        List<String> names = Arrays.asList("Ram","abc","def");
        //using lambda function to iterate
        names.stream().forEach((x)->System.out.println(x));
        //creating list of student object using lambda function
        List<Student> mCollect = names.stream().map((x) -> new Student(x)).collect(Collectors.toList());
        //using COnstructor reference to convert names to List of student
        //to refer constructor reference replace lambda func with Class name then double ":" and then "new" keyword
        List<Student> mCollect1 = names.stream().map(Student::new).collect(Collectors.toList());
        //Method Reference(in method ref give class name ,then double ":" then method name
        names.forEach(Main::hello1);
        //if method is not static then in that how we will call method using method reference
        //we need to create obj and that obj will use to call method
        //:: = method operator
        MethodReference methodReference = new MethodReference();
        names.forEach(methodReference::consume);

        TriConsumers<String,String,String,String> ref = (a,b,c,d)->MethodReference.concatStr(a,b,c,d);
        ref.accept("Ram","Sita","Hanuman","Lakshman");

        TriConsumers<String,String,String,String> ref2 = MethodReference::concatStr;
        ref2.accept("Ram","Sita","Hanuman","Lakshman");

        // Using counting() of Collectors to count peoples with age > 60
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        //long countP=Arrays.stream(details).filter((det)->Integer.parseInt(det.substring(11,13))>60).collect(
          //         Collectors.counting());
        long countP=Arrays.stream(details).filter((det)->Integer.parseInt(det.substring(11,13))>60).count();
        System.out.println(countP);

        String[] strCh={"d","b","c","b","c","a","z"};
        long k=2;
        Map<String, Long> mCollect2 = Arrays.stream(strCh).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> mCollect3 = mCollect2.keySet().stream().filter((key) -> mCollect2.get(key) == 1).skip(k).limit(1)
                .collect(Collectors.toList());
        System.out.println(mCollect3);
        Thread thread = new Thread(
            ()->{System.out.println("Hello World");}
            /*@Override
            public void run() {

            }*/
        );
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

        int[] intArray = integerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        integerList.stream().filter((x)->x>2).forEach((x)->System.out.println(x));

        int[] bann={1,6,5};
        Set<Integer> hs=Arrays.stream(bann).boxed().collect(Collectors.toSet());


    }

    public static void hello1(String s){
        System.out.println(s);
    }

}