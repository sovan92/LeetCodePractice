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
- What - What logic you want to put . (Logging, auditing , security checks)
- When the aspect needs to executed (before method execution, or after a method execution)
- Which - Pointcut , which method you want to intercept. 

