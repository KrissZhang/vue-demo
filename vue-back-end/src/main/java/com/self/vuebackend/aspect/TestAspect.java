package com.self.vuebackend.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 测试切面
 */
@Aspect
@Component
@Slf4j
public class TestAspect {

    /**
     * 切点
     */
    @Pointcut("execution(public * com.self.vuebackend.module.test.controller.*.*(..))")
    public void testAspect(){

    }

    public void before(){
        log.info("切点执行前...");
    }

    public void after(){
        log.info("切点执行后...");
    }

}
