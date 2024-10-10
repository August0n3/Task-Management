package com.task.util;


import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private EntityManager manager;

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        EntityTransaction trx = manager.getTransaction();
        Boolean criador = false;
        try{
            if (!trx.isActive()) {
                trx.begin();
                trx.rollback();

                trx.begin();
                criador = true;
            }

            return ctx.proceed();

        }catch (Exception e) {
            if(trx != null && criador) {
                trx.rollback();
            }
            throw e;
        }finally {
            if(trx != null && trx.isActive() && criador) {
                trx.commit();
            }
        }

    }
}
