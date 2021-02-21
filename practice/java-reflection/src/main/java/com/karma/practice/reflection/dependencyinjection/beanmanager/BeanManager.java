package com.karma.practice.reflection.dependencyinjection.beanmanager;

import com.karma.practice.reflection.annotations.Injects;
import com.karma.practice.reflection.annotations.Provides;
import com.karma.practice.reflection.dependencyinjection.orm.EntityManager;
import com.karma.practice.reflection.dependencyinjection.orm.ManagedEntityManager;
import com.karma.practice.reflection.dependencyinjection.provider.H2ConnectionProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BeanManager {

   private static BeanManager beanManager = new BeanManager();
   private  Map<Class<?>,Supplier<?>> registry = new HashMap<>();
    public static BeanManager getInstance() {
        return beanManager;
    }
    private  BeanManager() {
       List<Class<?>> clsses = new ArrayList<>();
       clsses.add(H2ConnectionProvider.class);
        for (Class<?> clss:
             clsses) {
            Method[] methods = clss.getDeclaredMethods();
            for (Method method:
                 methods) {
               Provides provides = method.getAnnotation(Provides.class);
               if (provides!=null){
                    Class<?> retunType = method.getReturnType();
                   Supplier<?> supplier = () -> {
                     try{
                       if (!Modifier.isStatic(method.getModifiers())) {
                           Object obj = clss.getConstructor().newInstance();
                           return method.invoke(obj);
                       }else{
                           return method.invoke(null);
                       }
                     }catch (Exception e){
                         throw new RuntimeException(e);
                     }
                   };
                   registry.put(retunType,supplier);
               }
            }

        }
    }
    public  <T> T getInstance(Class<T> clss) {
        try {
            T t = clss.getConstructor().newInstance();

            Field[] fields = clss.getDeclaredFields();
            for (Field field:
                 fields) {
                Injects injects = field.getAnnotation(Injects.class);
                if (injects!=null){
                    Class<?> injectedFieldType = field.getType();
                    Supplier<?> supplier = registry.get(injectedFieldType);
                    Object objectToInject = supplier.get();
                    field.setAccessible(true);
                    field.set(t,objectToInject);
                }
            }
            return t;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
