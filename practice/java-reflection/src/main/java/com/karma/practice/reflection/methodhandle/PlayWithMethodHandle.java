package com.karma.practice.reflection.methodhandle;

import com.karma.practice.reflection.model.Person;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class PlayWithMethodHandle {
    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType emptyconstructorMethodType = MethodType.methodType(void.class);
        MethodHandle emptyConstructor = lookup.
                findConstructor(Person.class,emptyconstructorMethodType);

        Person person = (Person) emptyConstructor.invoke();
        System.out.println(person);

        MethodType valuedConstructorMethodType = MethodType.
                methodType(void.class,String.class,int.class);
        MethodHandle valuedConstructor = lookup.
                findConstructor(Person.class,valuedConstructorMethodType);
        Person person1 = (Person) valuedConstructor.invoke("Jemma",10);
        System.out.println(person1);

        MethodType nameGetterMethodType = MethodType.methodType(String.class);
        MethodHandle nameGetter = lookup.
                findVirtual(Person.class,"getName",nameGetterMethodType);
        String name = (String) nameGetter.invoke(person1);
        System.out.println("Person1 name is " + name);

        MethodType nameSetterNameMethodType = MethodType.methodType(void.class,String.class);
        MethodHandle nameSetter = lookup.
                findVirtual(Person.class,"setName",nameSetterNameMethodType);
        nameSetter.invoke(person1,"akash");
        System.out.println(person1);

        MethodHandles.Lookup privateLookup = MethodHandles.privateLookupIn(Person.class,lookup);
        MethodHandle nameHandle = privateLookup.findGetter(Person.class,"name", String.class);
        String nameGetterFromField = (String) nameHandle.invoke(person1);
        System.out.println(nameGetterFromField);

    }
}
