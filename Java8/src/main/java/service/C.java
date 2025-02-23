package main.java.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.service.exception.ArithmeticExeptionClass;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new B();
		String car="", bus = "petrol";   
		car = car + bus;   
		System.out.println(car);
		try {
			a.m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread thread = new Thread(new Runnable() {
		    public void run() {
		        System.out.println("Hello World!");
		    }
		});
		
		//Runnable runnable = ()->System.out.println("Hello World!");
		Runnable runnable = null;
		Thread thread2 = new Thread(runnable);
		thread2.run();
		
		Thread thread3 = new Thread(
		    ()->System.out.println("Hello World!")
		);
		thread3.run();
		
		Thread thread4 = new Thread(
		    ()->{
		    	for(int i=0;i<5;i++) {
		    		System.out.print(i+" ");
		    	}
		    }
		);
		thread4.run();
		
		List<String> list=Arrays.asList("abc","def","Ghi","jkl");
		//list.stream().map((str)->str.charAt(1)).forEach(System.out::println);
		//list.stream().flatMap(str -> Stream.of(str.charAt(2))).forEach(System.out::println);
		List<Integer> val = Arrays.asList(2,4,1,7,5,2,7,5);
		int maxVal = val.stream().map((x)->x*2).min((a1,b)->b-a1).get();
		System.out.println(maxVal);
		int countVal = (int) val.stream().filter((x)->x%2==0).count();
		System.out.println(countVal);
		
		//anyMatch
		boolean bol = list.stream().anyMatch((str)->str.charAt(0)>='A' && str.charAt(0)<='Z');
        System.out.println(bol);
        
        Stream<String> stream1 = Stream.of("abc", "for");
        Stream<String> stream2 = Stream.of("def", "ghi");
        Stream.concat(list.stream(), stream2).forEach(System.out::println); 
        
        val.stream().filter((x)->x%2==0).collect(Collectors.toList());
        
        Map<Object, List<Integer>> groupingByRes = val.stream().collect(Collectors.groupingBy((x)->x));
        groupingByRes.forEach((keys,vals)->System.out.println(keys+" "+vals));
        
        Long count = val.stream().collect(Collectors.counting());
        System.out.println(count);
        
        String str = list.stream().collect(Collectors.joining("!"));
        System.out.println(str);
       
        try {
            int res = ArithmeticExeptionClass.divide(5,0);
        }
        catch(ArithmeticException e) {
            System.out.println("Exception thrown ; "+e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e2) {
        	System.out.println("Exception thrown ; "+e2.getMessage());
        }
        
        System.out.println("Hello");
        
        int[] arr={10,20,20,30,30,40};
        //List<Integer> l=
        Arrays.stream(arr).distinct().forEach((x)->System.out.println(x));//collect(Collectors.toList());
        //System.out.println(l);
		
	}

}
