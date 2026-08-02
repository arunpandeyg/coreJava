package practice.p;
@FunctionalInterface
public interface Practice5 {
    public void add();

    
    default String sayHi() {
        return "hi";
    }

    static boolean isTrue() {
        return true;
    }
}
