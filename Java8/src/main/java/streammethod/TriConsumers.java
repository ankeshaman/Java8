package main.java.streammethod;

@FunctionalInterface
public interface TriConsumers<T,U,V,W> {

    void accept(T a,U b,V c,W w);

}
