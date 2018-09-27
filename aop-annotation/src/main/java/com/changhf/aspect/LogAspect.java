package com.changhf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * 日志切面类,@Order值越小，优先级越高
 *
 * @author changhf
 */
@Order(2)
@Aspect
@Repository("logAspectBean")
public class LogAspect {
    // 定义切入点，切入点的id就是这个方法的名字
    @Pointcut("execution(* com.changhf.*.*(..))")
    // @Pointcut("execution(* del*(..))")
//    @annotation(com.cxh.study.aop.controller.UserAccessAnnotation) 拦截含有这个注解的方法
    private void allMethod() {
    }

    // 针对指定的切入点表达式选择的切入点应用前置通知
    // @Before("allMethod()")
    public void before(JoinPoint call) {
        //JoinPoint可以帮我们做一些细节
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println("【注解-前置通知】:" + className + "类的" + methodName + "方法开始了");
    }

    // 访问命名切入点来应用后置通知
    // @AfterReturning("allMethod()")
    public void afterReturn() {
        System.out.println("【注解-后置通知】:方法正常结束了");
    }

    // 应用最终通知
    // @After("allMethod()")
    public void after(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        List<Object> list = Arrays.asList(call.getArgs());
        System.out.println("【注解-最终通知】:不管方法有没有正常执行完成," + "一定会返回的；" + className + "类的" + methodName + "参数为：" + list);
    }

    // 应用异常抛出后通知
    // @AfterThrowing("allMethod()")
    public void afterThrowing() {
        System.out.println("【注解-异常抛出后通知】:方法执行时出异常了");
    }

    // 应用周围通知
    @Around("allMethod()")
    public Object doAround(ProceedingJoinPoint call) throws Throwable {
        Object result = null;
        // 相当于前置通知
        this.before(call);
        try {
            result = call.proceed();
            // 相当于后置通知
            this.afterReturn();
        } catch (Throwable e) {
            // 相当于异常抛出后通知
            this.afterThrowing();
            throw e;
        } finally {
            // 相当于最终通知
            this.after(call);
        }
        return result;
    }
}