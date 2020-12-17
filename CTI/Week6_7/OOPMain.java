package Week6_7;

import java.util.ArrayList;

public class OOPMain {
    
    public static void main(String[] args) {
        
        int a = (int) 4.2;
    }


}

class Animal {

    private int var1;

    public Animal() {

    }

    public void setVar1(int newVar1) {
        this.var1 = newVar1;
    }

    public int getVar1() {
        return this.var1;
    }

}

class Cat extends Animal {

    private int a;

    public Cat() {
        super();
    }

}

class Dog extends Animal {

    public Dog() {
        super();
    }

}

class Bird extends Animal {

    public Bird() {
        super();
    }

}