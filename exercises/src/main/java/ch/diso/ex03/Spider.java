package ch.diso.ex03;

public class Spider extends Animal {

    public Spider() {
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("The spider eats a fly.");
    }

}