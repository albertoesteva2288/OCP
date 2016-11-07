package ch.diso.ex03;

public class MultipleInheritance implements InterfaceA, InterfaceB {

    // MultipleInheritance inherits unrelated defaults for getName() from
    //   types InterfaceA and InterfaceB

    public String getName() {
        return InterfaceA.super.getName();
    }

}
