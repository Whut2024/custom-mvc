# 基本组件

1. **InitBinder**
2. **ModelFactory**
3. **ArgumentResolver**
4. **ReturnalueHandler**
5. **ControllerAdvice**
6. **MessageConverter**
7. **HandlerMethod**



# 中间件

1. **HandlerMapping**
2. **HandlerAdapter**
3. **ExceptionResolver**



**这三个中间件在 bean 的初始化时会载入基本组件**



# 聚合类 DispatcherServlet



## initStrategies

**收集容器中的中间件**

 **context 将 Bean 扫描进入容器**

**DispatcherServlet 在 SpringBoot 中已经按照 AutoConfiguration 类配置，可以在第一次请求或者提前初始化，**

**初始化时会主要加载 context 容器中的 HandlerMapping，HandlerAdapter 和 HandlerExceptionResolver 然后存储在 DispatcherServlet 对象中  （initStrategies方法）**

**HandlerMapping 在 afterPropertiesSet 方法中从 context 容器获取 Controller Bean，解析封装出 HandlerMethod 对象，存储在 Map 内部**

**HandlerAdapter 在 afterPropertiesSet 方法中会首先检查 context 容器中是否有自定义的 ControllerAdvice Bean，如果存在就会解析 ControllerAdvice Bean 中的方法，收集 initBinder, Model 和 RequestBody 三种增强方法存储到 adapter 对象的 list 属性中**

 **三种基础组件 ArgumentResolver, InitBinderArgumentResolver 和 ReturnValueHandler 对于这三种组件的每一种，如果没有自定义的 Bean，就会执行获取相应默认 resolver 或者 handler 的方法（一般都是默认方法获取），这些默认方法中会调用获取自定义添加的 resolver 和 handler 的方法**

**ExceptionResolver 在 afterPropertiesSet 方法中的初始化逻辑和 HandlerAdapter 几乎是一样的**

**这三个主要组件会以 list 的形式分别存储在 DispatcherServlet 对象中**



## doDispatcher

**一个非JSP请求进入服务器后，会被直接转发到 DispatcherServlet，DispatcherServlet 会遍历调用 RequestMapping 来获取 HandlerMethodChain 对象，然后再遍历调用 Adapter 来获取合适的 Adapter 对象，接着执行 chain 中的 Interceptor 的 preHandler 方法，后用 adapter 对象来执行 handler method，handler method 会在 adapter 中 被添加增强 argument resolver，return value handler 和 init binder 来封装成 servlet invocable handler method ，在处理器执行前会 经历 Controller Advice 的全局的 model，init binder 和 request body 增强，在经历 参数处理，参数类型转换，然后 handler 执行，其返回值会被 return value handler 处理，然后被 Controller Advice 的 ResponseBody 全局增强，接着执行 chain 的 Interceptor 的 postHandler 方法，如果通过则会进行可能的异常处理处理器进行异常处理，然后执行 ControllerAdvice 的符合条件的 ExceptionHandler 方法，最后执行可能的视图渲染和 chain 中的 Interceptor 的 afterCompletion 方法**





# 编写流程

1. **完成各个接口的定义**
2. **完成中间件对基础件的收集逻辑**
3. **完成中间件的处理逻辑**
4. **完成 dispatcher 的初始化方法**
5. **完成 doDispatcher 方法**