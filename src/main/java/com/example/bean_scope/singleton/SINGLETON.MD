# Singleton Scope

- It's a default scope of bean.
- Only one instance will be get created per bean.
- same instance will be used all over the application to fill dependencies.
- Eagerly initialized by **IOC** (means at the time of application startup, object get created).

every bean is singleton by default.
But we can specify it manually as well.

- using @Scope("singleton")
- using @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)

*note* : at the time of api call spring will not create another object it will use same object.

