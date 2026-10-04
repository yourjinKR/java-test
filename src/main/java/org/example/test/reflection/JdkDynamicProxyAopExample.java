package org.example.test.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyAopExample {
    public static void main(String[] args) {
        PaymentService target = new KakaoPaymentService();

        PaymentService proxy = (PaymentService) Proxy.newProxyInstance(
                PaymentService.class.getClassLoader(),
                new Class[]{PaymentService.class},
                new PaymentInvocationHandler(target)
        );

        proxy.pay();
    }
}


interface PaymentService {
    void pay();
}

class KakaoPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("카카오 간편 결제");
    }
}

class PaymentInvocationHandler implements InvocationHandler {

    private final Object target;

    public PaymentInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before");
        Object result = method.invoke(target, args);
        System.out.println("After");
        return result;
    }
}