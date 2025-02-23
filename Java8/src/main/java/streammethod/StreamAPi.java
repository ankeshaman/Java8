package main.java.streammethod;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPi {

    List<Integer> val = Arrays.asList(2,4,5,6,7,8,9,10);
    List<String> list=Arrays.asList("abc","def","Ghi","jkl");
    //Filter
    List<Integer> filterVal = val.stream().filter((x)->x%2==0).collect(Collectors.toList());

    //Map
    List<Integer> mapedVal = val.stream().filter((x)->x%2==0).map((x)->x*2).collect(Collectors.toList());

    //Skip :
    List<Integer> skipVal = val.stream().map((x)->x*2).skip(1).collect(Collectors.toList());

    //Distinct :
    List<Integer> distinctVal = val.stream().map((x)->x*2).distinct().collect(Collectors.toList());

    //Sorted :
    List<Integer> sortedVal = val.stream().map((x)->x*2).sorted((a,b)->b-a).collect(Collectors.toList());

    //Limit : limiting to a maxsize
    List<Integer> limitedVal = val.stream().map((x)->x*2).limit(3).collect(Collectors.toList());

    //Peek :
    List<Integer> peekVal = val.stream().map((x)->x*2).peek(System.out::println).collect(Collectors.toList());

    //Max :
    int maxVal = val.stream().map((x)->x*2).max((a,b)->a-b).get();

    //Min :
    int minVal = val.stream().map((x)->x*2).min((a,b)->a-b).get();

    //COunt :
    int countVal = (int) val.stream().filter((x)->x%2==0).count();

    //anyMatch :
    boolean bol = list.stream().anyMatch((str)->str.charAt(0)>='A' && str.charAt(0)<='Z');

    //findFirst :
    Optional<Integer> first = val.stream().findFirst();

    //concat ;
    Stream<String> stream1 = Stream.of("abc", "for");
    Stream<String> stream2 = Stream.of("def", "ghi");
    //Stream.concat(stream1, stream2).forEach(element -> System.out.println(element));
    //Stream.concat(stream1,stream2).forEach(System.out::println);
    int[] arr={1,1,2,3,2};

    //boxed is used to collect stream of Integer after converting int to Integer
    //toCOllection expects a supplier as an argument. Supplier only returns doesnt taking any input
    Set<Integer> hs=Arrays.stream(arr).boxed().collect(Collectors.toCollection(()->new TreeSet<>()));
    Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toCollection(TreeSet::new));

    Queue<Integer> q=Arrays.stream(arr).filter(x->(x==0)).boxed().collect(Collectors.toCollection(()->new LinkedList<>()));

    String[] str = Arrays.stream(arr).mapToObj(Integer::toString).toArray(String[]::new);

    //Counting fr of element
    String[] strCh={"d","b","c","b","c","a","z"};
    long k=2;
    //Taking out the kth distinct element
    Map<String, Long> mCollect2 = Arrays.stream(strCh).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    List<String> mCollect3 = mCollect2.keySet().stream().filter((key) -> mCollect2.get(key) == 1).skip(k).limit(1)
            .collect(Collectors.toList());
    //System.out.println(mCollect3);

}
