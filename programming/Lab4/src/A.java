public class A {
    public Object createObject(String name) throws Exception {
        Class clazz = Class.forName(name);
        var obj = clazz.getConstructor().newInstance();
        return obj;
    }
}
