/**
 * 
 */
package com.jmoll.email.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author jmoll
 *
 */

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class PerformanceMonitorConfig {

	/**
	 * Pointcut to define public methods
	 */
	@Pointcut("execution(public * *(..))")
	public void publicMethods() {
		// no implementation needed for Pointcut methods
	}
	
    /**
     * Pointcut to match all public methods that are annotated with RequestMapping
     */
    @Pointcut("publicMethods() && (@annotation(org.springframework.web.bind.annotation.GetMapping) || (@annotation(org.springframework.web.bind.annotation.PostMapping)))")
    public void requestMappingMethods() {
        // no implementation needed for Pointcut methods
    }
	
    /**
     * This is a catch all pointcut, add additional pointcuts to this one with || syntax.
     */
    @Pointcut("requestMappingMethods()")
    public void performanceMonitor() {
        // no implementation needed for Pointcut methods
    }	
	
    /**
     * Create the Spring {@link PerformanceMonitorInterceptor}
     * 
     * @return a PerformanceMonitorInterceptor bean
     */
    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        final PerformanceMonitorInterceptor interceptor = new PerformanceMonitorInterceptor();
        interceptor.setLogTargetClassInvocation(false);
        
        return interceptor;
    }
    
    /**
     * Create the AOP Advisor and tie it to the {@link PerformanceMonitorInterceptor} and
     * the performanceMonitor pointcut.
     * 
     * @return a performanceMonitorAdvisor bean
     */
    @Bean
    public Advisor performanceMonitorAdvisor() {
        final AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.jmoll.email.config.PerformanceMonitorConfig.performanceMonitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }
}
