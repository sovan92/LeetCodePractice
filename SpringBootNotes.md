## Bean Scopes 

- @Scope(BeanDefination.SCOPE_PROTOTYPE)
  Used for heavy env in multi thrrading .
  Not the default scope .

 - @Scope(BeanDefination.SCOPE_SINGLETON)

 - REQUEST - Web application

 - SESSION - Web application

 - APPLICATION - web application

 - Where to use singleton scoped beans.
   -cMost used bean scope in multiple threads.
   - Most suitable for service communication .
   - It shouldn't contain data . Like UserData . ... Like UserService shouldn't have user fiedl variable .
   - Can cause race condition .
   - For data pojo don't create a Bean.
  
   - If there is issue in creation of Bean in eager initialzation , server starting will fail .  


## Lazy Initialization vs Eager Initialization . 

@Lazy - for lazy initialization , when we access for the first time, the bean is created. 
By Default eager initialization . 

## AOP  
- Simple piece of code , like audting, security and logging .
- Sping AOP in spring core frame work , cross cutting concern like transaction management , logging auditing, security etc.
- Generally works on non functional requirements .
- It takes plug and play role.
- Spring under the hood uses aspect oriented programing .
- What - What logic you want to put . (Logging, auditing , security checks) (Aspect)
- When the aspect needs to executed (before method execution, or after a method execution) (Advice)
- Which - Pointcut , which method you want to intercept. (Pointcut)
- Join point - which is the triggering event that will execute the aspect. In java it is always start of the method .
- Target Object - It's bean which calls the method or the pointcut .
- Example - Developer wants  (1)some logic to be executed (2)before each (3)execution of method , (4)playMusic() present inside the bean (5)VehicleServices.
  - Some logic (1) - Aspects
  - before (2) - Advice to springboot
  - execution (3) - Join point , (start of the method)
  - playMusic() (4) - pointcut .
  - VehicleService (5) - Target object .     

