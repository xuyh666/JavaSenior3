package com.erhu.java.collection;

import java.io.Serializable;

public class Person implements Comparable, Serializable {
    private static final long serialVersionUID = 41234124367710L;

    private  String name;
    private  int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
             Person p = (Person) o;
            int i = this.name.compareTo(((Person) o).name);
            if(i == 0){
                return Integer.compare(this.getAge(),p.getAge());
            }else{
                return this.name.compareTo(((Person) o).name);
            }
        }else {
            throw new RuntimeException("输入的参数不匹配");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
