import java.util.*;

class Box<T> {
    private T value;
    Box(T value) { this.value = value; }
    T get() { return value; }
    void set(T v) { value = v; }
    public String toString() { return "Box[" + value + "]"; }
}

class Pair<K, V> {
    private K key; private V value;
    Pair(K k, V v) { key = k; value = v; }
    K getKey() { return key; }
    V getValue() { return value; }
    public String toString() { return "(" + key + ", " + value + ")"; }
}

class NumberBox<T extends Number> {         
    private T num;
    NumberBox(T n) { num = n; }
    double doubled() { return num.doubleValue() * 2; }
}

public class Practical7 {
    // generic method
    static <T> void printArray(T[] arr) {
        for (T t : arr) System.out.print(t + " ");
        System.out.println();
    }
  
    static <T extends Comparable<T>> T maxOf(T a, T b) { return a.compareTo(b) >= 0 ? a : b; }

    
    static double sum(List<? extends Number> list) {
        double s = 0;
        for (Number n : list) s += n.doubleValue();
        return s;
    }
  
    static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 3; i++) list.add(i);
    }
   
    static void printAll(List<?> list) { for (Object o : list) System.out.print(o + " "); System.out.println(); }

    public static void main(String[] args) {
        Box<Integer> bi = new Box<>(10);
        Box<String> bs = new Box<>("Hello");
        System.out.println(bi + " " + bs);
        

        Pair<String, Integer> p = new Pair<>("Age", 19);
        System.out.println(p + " key=" + p.getKey() + " value=" + p.getValue());

        Integer[] ia = {1, 2, 3}; String[] sa = {"a", "b"}; Double[] da = {1.5, 2.5};
        printArray(ia); printArray(sa); printArray(da);

        System.out.println("max(5,9)=" + maxOf(5, 9) + ", max(\"apple\",\"mango\")=" + maxOf("apple", "mango"));

        System.out.println(new NumberBox<>(21).doubled() + " " + new NumberBox<>(2.5).doubled());
       

        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> dbls = Arrays.asList(1.5, 2.5);
        System.out.println("sum ints = " + sum(ints) + ", sum doubles = " + sum(dbls));

        List<Number> nums = new ArrayList<>();
        List<Object> objs = new ArrayList<>();
        addNumbers(nums); addNumbers(objs);
        printAll(nums); printAll(objs);
    }
}
