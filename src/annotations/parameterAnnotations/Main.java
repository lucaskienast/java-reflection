package annotations.parameterAnnotations;

import annotations.parameterAnnotations.annotations.Annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class Main {

    /*
    public static void main(String[] args) {
        BestGamesFinder bestGamesFinder = new BestGamesFinder();
        Set<String> games = bestGamesFinder.getAllGames();

        Map<String, Float> gameToRating = bestGamesFinder.getGameToRating(games);
        Map<String, Float> gameToPrice = bestGamesFinder.getGameToPrice(games);

        SortedMap<Double, String> scoreToGame = bestGamesFinder.scoreGames(gameToPrice, gameToRating);
        List<String> bestGamesInDescendingOrder = bestGamesFinder.getTopGames(scoreToGame);

        System.out.println(bestGamesInDescendingOrder);
    }
     */

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        BestGamesFinder bestGamesFinder = new BestGamesFinder();
        List<String> bestGamesInDescendingOrder = execute(bestGamesFinder);
        System.out.println(bestGamesInDescendingOrder);
    }

    public static <T> T execute(Object instance) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = instance.getClass();
        Map<String, Method> operationToMethod = getOperationToMethod(clazz);
        Method finalResultMethod = findFinalResultMethod(clazz);
        return (T) executeWithDependencies(instance, finalResultMethod, operationToMethod);
    }

    private static Object executeWithDependencies(Object instance, Method currentMethod, Map<String, Method> operationToMethod) throws InvocationTargetException, IllegalAccessException {
        List<Object> parameterValues = new ArrayList<>(currentMethod.getParameterCount());

        for (Parameter parameter : currentMethod.getParameters()) {
            Object value = null;

            if (parameter.isAnnotationPresent(Annotations.DependsOn.class)) {
                String dependencyOperationName = parameter.getAnnotation(Annotations.DependsOn.class).value();
                Method dependencyMethod = operationToMethod.get(dependencyOperationName);
                value = executeWithDependencies(instance, dependencyMethod, operationToMethod);
            }

            parameterValues.add(value);
        }

        return currentMethod.invoke(instance, parameterValues.toArray());
    }

    private static Map<String, Method> getOperationToMethod(Class<?> clazz) {
        Map<String, Method> operationNameToMethod = new HashMap<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Annotations.Operation.class))
                continue;

            Annotations.Operation operation = method.getAnnotation(Annotations.Operation.class);
            operationNameToMethod.put(operation.value(), method);
        }

        return operationNameToMethod;
    }

    private static Method findFinalResultMethod(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Annotations.FinalResult.class))
                return method;
        }
        throw new RuntimeException("No method found with FinalResult annotation");
    }

}
