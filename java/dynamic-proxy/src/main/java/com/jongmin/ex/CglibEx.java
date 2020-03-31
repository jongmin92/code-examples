package com.jongmin.ex;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibEx {

    public static void main(String[] args) {
        final MethodInterceptor handler = new MethodInterceptor() {
            final DefaultRepository defaultRepository = new DefaultRepository();

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                    throws Throwable {
                final Method targetInstanceMethod = defaultRepository.getClass().getMethod(method.getName(),
                                                                                           method.getParameterTypes());

                if (targetInstanceMethod.getAnnotation(Transactional.class) != null) {
                    System.out.println("Transaction In");
                    Object invoke = method.invoke(defaultRepository, args);
                    System.out.println("Transaction Out");
                    return invoke;
                }

                return method.invoke(defaultRepository, args);
            }
        };

        Repository repository = (Repository) Enhancer.create(Repository.class, handler);

        repository.noTransaction();
        repository.yesTransaction();
    }
}
