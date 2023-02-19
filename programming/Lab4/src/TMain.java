import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class TMain {
    public static void main(String[] args) throws Exception {
        A a = new A();
        var obj = a.createObject("Main");
        System.out.println(obj.getClass().getName());
    }
}
