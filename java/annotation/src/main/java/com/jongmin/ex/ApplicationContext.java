package com.jongmin.ex;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ApplicationContext {

    private static final Map<Class<?>, Object> clazzs = new HashMap<>();

    public static <T> T get(Class<T> clazz) throws Exception {
        return (T) clazzs.computeIfAbsent(clazz, key -> {
            final T instance;

            try {
                instance = createInstance(key);
                clazzs.put(key, instance);

                Arrays.stream(clazz.getDeclaredFields())
                      .forEach(field -> {
                          field.setAccessible(true);

                          if (field.getAnnotation(Inject.class) != null) {
                              try {
                                  field.set(instance, get(field.getType()));
                              } catch (Exception e) {
                                  throw new RuntimeException(e);
                              }
                          }
                      });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return instance;
        });
    }

    private static <T> T createInstance(Class<?> clazz) throws Exception {
        final Constructor<T> constructor = (Constructor<T>) clazz.getConstructor(null);
        return constructor.newInstance(null);
    }
}
