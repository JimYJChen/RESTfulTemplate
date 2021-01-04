//package self.test.jimtest.common.aop;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.MDC;
//import org.springframework.stereotype.Component;
//import self.test.jimtest.common.utils.JSONUtil;
//import self.test.jimtest.common.utils.SPELUtil;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Slf4j
//@Aspect
//@Component
//public class LogAOP {
//
//    private static final String JSON_KEY = "logjson";
//
////    @Pointcut("@annotation(self.test.jimtest.common.annotations.LogAnnotations)")
////    public void targetMethod() {
////    }
//
//    @SneakyThrows
//    @Around("targetMethod()")
//    public Object handlerLogMethod(ProceedingJoinPoint pjp) {
//            long startTime = System.currentTimeMillis();
//
//        Object result;
//
//        try {
//            putLogInfo2MDC(pjp);
//
//            result = pjp.proceed();
//
//            // 本次操作用时（毫秒）
//            long elapsedTime = System.currentTimeMillis() - startTime;
//            log.info("[{}]use time: {}", pjp.getSignature(), elapsedTime);
//        } finally {
//            clearMDC();
//        }
//
//        return result;
//    }
//
//    private void clearMDC() {
//        MDC.remove(JSON_KEY);
//    }
//
//    private void putLogInfo2MDC(ProceedingJoinPoint pjp) {
//        // 得到方法上的注解
//        MethodSignature signature = (MethodSignature) pjp.getSignature();
//
//        LogAnnotations logAnnotation = signature.getMethod().getAnnotation(LogAnnotations.class);
//
//        SPELUtil spel = new SPELUtil(pjp);
//
//        Map<String, Object> loginfoMap = new LinkedHashMap<>();
//
//        // 使用单字母而不是全名，是为了节省日志文件大小。
//
//        // 用户
//        //UserUtil.getUserIfLogin()
//        loginfoMap.put("U", "JIMTEST");
//
//        // 操作
//        loginfoMap.put("A", logAnnotation.action());
//
//        // 对象类型
//        loginfoMap.put("T", logAnnotation.itemType());
//
//        // 对象id，spel表达式
//        loginfoMap.put("I", spel.cacl(logAnnotation.itemId()));
//
//        // 其他参数，spel表达式
//        loginfoMap.put("P", spel.cacl(logAnnotation.param()));
//
//        MDC.put(JSON_KEY, JSONUtil.toJsonStr(loginfoMap));
//    }
//}