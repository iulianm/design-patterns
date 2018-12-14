package com.design.patterns.creational.builder.builder;

/* Fluent Builder Inheritance with Recursive Generics */

class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends com.design.patterns.creational.builder.builder.PersonBuilder<SELF>> {
    protected com.design.patterns.creational.builder.builder.Person person = new com.design.patterns.creational.builder.builder.Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public com.design.patterns.creational.builder.builder.Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends com.design.patterns.creational.builder.builder.PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}


public class DemoBuilder {

    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        com.design.patterns.creational.builder.builder.Person iulian = pb
            .withName("Iulian")
            .worksAt("Developer")
            .build();
        System.out.println(iulian);
    }

}
