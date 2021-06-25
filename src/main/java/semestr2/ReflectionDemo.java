package semestr2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

public class ReflectionDemo {

    public static int numberOfTypes(ArrayList<Object> list) {
        int sum = 0;
        for (Object object : list) {
            if (object instanceof Human) {
                sum++;
            }
        }
        return sum;
    }

    public static ArrayList<String> publicMethod(Object object) {
        ArrayList<String> listPublicMethod = new ArrayList<String>();
        for (Method method : object.getClass().getDeclaredMethods()) {
            if ((Modifier.isPublic(method.getModifiers()))) {
                listPublicMethod.add(method.getName());
            }
        }
        return listPublicMethod;
    }

    public static ArrayList<String> nameOfSuperClass(Object object) {
        ArrayList<String> nameOfSuperClass = new ArrayList<String>();
        Class cl = object.getClass().getSuperclass();
        while (!(cl == null)) {
            nameOfSuperClass.add(cl.getSimpleName());
            cl = cl.getSuperclass();
        }
        return nameOfSuperClass;
    }

    public static int listUseExecute(ArrayList<Object> list) {
        int sum = 0;
        for (Object object : list) {
            if (object instanceof Executable) {
                ((Executable) object).execute();
                sum++;
            }
        }
        return sum;
    }

    public static boolean getter(Method method) {
        return (Modifier.isPublic(method.getModifiers()) &&
                !(Modifier.isStatic(method.getModifiers())) &&
                method.getParameters().length == 0 &&
                method.getName().startsWith("get") &&
                !(method.getReturnType().equals(void.class)));
    }

    public static boolean setter(Method method) {
        return (Modifier.isPublic(method.getModifiers()) &&
                !(Modifier.isStatic(method.getModifiers())) &&
                method.getParameters().length == 1 &&
                method.getName().startsWith("set") &&
                method.getReturnType().equals(void.class));
    }

    public static ArrayList<String> getAndSet(Object object) {
        ArrayList<String> listGetAndSet = new ArrayList<>();
        for (Method method : object.getClass().getMethods()) {
            if (getter(method) || setter(method)) {
                listGetAndSet.add(method.getName());
            }
        }
        return listGetAndSet;
    }
    private int test(){
        return 1;
    }
}
