package com.training.examples.base;

import org.junit.Test;

public class InitializationTest {

    @Test
    public void hideValue() {
        Parent parent = new Child();
        parent.printValue();
        System.out.println("sout value parent: " + parent.value);

        System.out.println("");

        Child child = new Child();
        child.printValue();
        System.out.println("sout value child: " + child.value);
        child.printValueParent();
    }

    class Parent {
        int value = 1;

        {
            System.out.println("Parent init block");
        }

        public Parent() {
            System.out.println("Parent constructor");
        }

        public void printValue() {
            System.out.println("Parent value is: " + this.value);
        }

        public void printValueShadow() {
            int value = 3;
            System.out.println("Parent value is: " + value);
        }

    }

    class Child extends Parent {
        int value = 2;

        {
            System.out.println("Child init block");
        }

        public Child() {
            System.out.println("Child constructor");
        }

        public void printValue() {
            System.out.println("Child value is: " + this.value);
        }

        public void printValueParent() {
            System.out.println("Child.Parent value is: " + super.value);
        }
    }
}
