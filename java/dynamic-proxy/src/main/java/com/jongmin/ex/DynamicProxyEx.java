package com.jongmin.ex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyEx {

    public static void main(String[] args) {
        Repository repository = (Repository)
                Proxy.newProxyInstance(Repository.class.getClassLoader(),
                                       new Class[] { Repository.class },
                                       new InvocationHandler() {
                                           final DefaultRepository defaultRepository = new DefaultRepository();

                                           @Override
                                           public Object invoke(Object proxy,
                                                                Method method,
                                                                Object[] args)
                                                   throws Throwable {
                                               final Method targetInstanceMethod =
                                                       defaultRepository.getClass().getMethod(
                                                               method.getName(), method.getParameterTypes());
                                               if (targetInstanceMethod.getAnnotation(Transactional.class) != null) {
                                                   System.out.println("Transaction In");
                                                   final Object invoke = method.invoke(defaultRepository, args);
                                                   System.out.println("Transaction Out");
                                                   return invoke;
                                               }

                                               return method.invoke(defaultRepository, args);
                                           }
                                       });

        repository.noTransaction();
        repository.yesTransaction();
    }
}
