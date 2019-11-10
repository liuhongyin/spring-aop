# spring aop learn project
- 切面：（Aspect) 一个关注点的模块化，就比较笼统的一个概念，关注点可能横切多个对象。若不理解请往后看图片理解，对应的注解有@Aspect。
- 连接点：（Joinpoint) 在程序执行过程中某个特定的点，一个连接点总是代表一个方法的执行。
- 通知：（Advice) 通知表示在一个连接点执行的具体的动作，比如After Before 表明通知的具体动作
- 切入点：（Pointcut）通过一个表达式去表明我所定义的通知在那个地点具体执行。
- 前置通知：（Before advice）表明在连接点执行之前执行的动作。
- 后置通知：（After returning advice）在某个连接点完成后的通知，比如一个方法没有抛出任何异常，正常返回。
- 环绕通知：（Around Advice) 环绕可以看作是包含前置通知和后置通知的一个通知，先了解，后面具体理解。
- 异常通知：（After throwing advice) 在方法异常推出时候执行的通知。
- 最终通知：（After advice) 在连接点退出时候执行的通知。不论是正常退出还是异常退出。


```
2019-11-10 11:28:24.150  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : aroundAdvice start
2019-11-10 11:28:24.150  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : beforeAdvice start
2019-11-10 11:28:24.150  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : requestURL,http://localhost:8080/login
2019-11-10 11:28:24.151  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : remoteIP,0:0:0:0:0:0:0:1
2019-11-10 11:28:24.151  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : params,[liuhongyin, sdfas]
2019-11-10 11:28:24.151  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : beforeAdvice end
2019-11-10 11:28:24.158  INFO 11673 --- [nio-8080-exec-2] c.l.s.controller.LoginController         : username,liuhongyin
2019-11-10 11:28:24.159  INFO 11673 --- [nio-8080-exec-2] c.l.s.controller.LoginController         : password,sdfas
2019-11-10 11:28:24.159  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : aroundAdvice return, success
2019-11-10 11:28:24.159  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : aroundAdvice end
2019-11-10 11:28:24.159  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : after start
2019-11-10 11:28:24.159  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : after end
2019-11-10 11:28:24.159  INFO 11673 --- [nio-8080-exec-2] c.l.springaop.aop.LoginLogAspect         : afterReturning,success
```
