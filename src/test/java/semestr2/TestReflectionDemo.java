package semestr2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class TestReflectionDemo {
    private Human people1 = new Human("Ivanov", "Dmitry", "Alexandrovich", 40);
    private Human people2 = new Human("Ivanov", "Vasiliy", "Pavlovich", 10);
    private Human people3 = new Human("Petrov", "Ivan", "Viktorovich", 45);
    private Student student1 = new Student("Ivanov","Ivan","Ivanovich",10,"IMiT");
    private Student student2 = new Student("Ivanov","Andrey","Olegovich",42,"Chemistry");
    private Student student3 = new Student("Ivanov","Ivan","Ivanovich",10,"History");
    private ReflectionDemo actual = new ReflectionDemo();
    private ArrayList<Object> list = new ArrayList<>();

    @Test
    public void testNumberOfTypes(){
        String str = "123456";
        Collections.addAll(list, people1, people2, people3, student1, student2, student3, str);
        assertEquals(6, ReflectionDemo.numberOfTypes(list));
    }

    @Test
    public void testPublicMethod(){
        ArrayList<String> actualList = ReflectionDemo.publicMethod(actual);
        Collections.sort(actualList);
        ArrayList<String> expected = new ArrayList<>();
        Collections.addAll(expected, "getAndSet","getter","listUseExecute","nameOfSuperClass","numberOfTypes","publicMethod","setter");
        assertEquals(expected, actualList);

    }

    @Test
    public void testNameOfSuperClass(){
        ArrayList<String> expected = new ArrayList<>();
        Collections.addAll(expected,"Human","Object");
        assertEquals(expected, ReflectionDemo.nameOfSuperClass(student1));
    }

    @Test
    public void testListUseExecute(){
        ReflectionDemo reflectionDemo = new ReflectionDemo();
        Collections.addAll(list,people1,people2,student1,student2,student3);
        assertEquals(3, ReflectionDemo.listUseExecute(list));
    }

    @Test
    public void testGetAndSet(){
        ArrayList actualList = ReflectionDemo.getAndSet(people1);
        Collections.sort(actualList);
        ArrayList<String> expected = new ArrayList<>();
        Collections.addAll(expected, "getAge","getClass","getName","getPatronymic","getSurname","setAge","setName","setPatronymic","setSurname");
        assertEquals(expected, actualList);
    }
}
