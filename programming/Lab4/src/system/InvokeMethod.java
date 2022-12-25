package system;

import actions.topersons.Action;
import actions.toactionable.ItemAction;
import interfaces.Actionable;
import real.objects.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class InvokeMethod {
    public static void invoke(Object action, String method, Object whoDoIt, Object[] parameters) {
        Class<?>[] parametersType = null;
        if (parameters != null) {
            parametersType = new Class<?>[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                parametersType[i] = parameters[i].getClass();
            }
        }
        try {
            Method runAction = action.getClass().getMethod(method, parametersType);
            if (action instanceof Action) {
                ((Action) action).setWhoDoIt((Person) whoDoIt);
            }
            else {
                ((ItemAction) action).setWhoDoIt((Actionable) whoDoIt);
            }
            runAction.setAccessible(true);
            runAction.invoke(action, parameters);
            runAction.setAccessible(false);
        } catch (InvocationTargetException e) {
            System.out.println("CANT INVOKE METHOD 1");
        } catch (NoSuchMethodException e) {
            System.out.println("CANT INVOKE METHOD 2");
        } catch (IllegalAccessException e) {
            System.out.println("CANT INVOKE METHOD 3");
        }
    }
}
