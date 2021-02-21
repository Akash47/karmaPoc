import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PlayWithReflection {
    public static void main(String[] args) {
        String personClassName = "com.karma.practice.reflection.model.Person";
        try {
            Class<?> personClass = Class.forName(personClassName);
            System.out.println("person class" + personClass);

            Field[] fields = personClass.getFields();
            System.out.println(" public Fields:- " + Arrays.toString(fields));

            Field[] declaredFields = personClass.getDeclaredFields();
            System.out.println("private public protected static final Fields:- " + Arrays.toString(declaredFields));

            Method[] method = personClass.getMethods();
            System.out.println("public methods:- " + Arrays.toString(method));

            Method[] declaredMethod = personClass.getMethods();
            System.out.println("private public protected static final methods:- " + Arrays.toString(declaredMethod));

            Arrays.stream(declaredMethod).
                    filter(method1 -> Modifier.isStatic(method1.getModifiers())).
                    forEach(System.out::println);


        } catch (ClassNotFoundException e) {
            System.out.println(e.getCause().toString());
        }
    }
}
