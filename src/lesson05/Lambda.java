package lesson05;

interface Executable {
    void execute(int a, int b);
}

class Runner {
    public void run(Executable e) {
        e.execute(10, 25);
    }
}

public class Lambda {
    public static void main(String[] args) {
        Runner r = new Runner();
        r.run((x, y) -> System.out.println(x + y));
    }
}
