package solidprinciple;

public class LSPbad {

}


class Bird {
    public void fly() {
        System.out.println("Flying!");
    }
}

class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow flying!");
    }
}

class Penguin extends Bird {
    public void fly() {
        throw new RuntimeException("Penguins can't fly!");  // 💥
    }
}