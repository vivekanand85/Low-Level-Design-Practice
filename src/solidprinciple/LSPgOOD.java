package solidprinciple;

public class LSPgOOD {

}


interface Bird1 {
    void eat();
}

interface FlyingBird extends Bird1 {
    void fly();
}

class Sparrow1 implements FlyingBird {
    public void fly() { System.out.println("Sparrow flying!"); }
    public void eat() { System.out.println("Sparrow eating!"); }
}

class Penguin1 implements Bird1 {
    public void eat() { System.out.println("Penguin eating!"); }
    // No fly() — and that's perfectly fine ✅
}