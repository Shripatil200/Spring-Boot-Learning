# Spring Bean Scopes



## List of Bean Scopes

| Scope Name   | Type        | Description |
|-------------|------------|-------------|
| singleton   | Core        | One instance per Spring container (default) |
| prototype   | Core        | New instance for every request |
| request     | Web         | One instance per HTTP request |
| session     | Web         | One instance per HTTP session |
| application | Web         | One instance per ServletContext |


## application Scope (Web Applications)
## Use When

- Data must be shared across all users

- Data is application-wide and read-mostly

## Typical Use Cases

- Global configuration

- Application-wide caches

- Reference data

## Avoid When

- Data is user-specific

- Frequent updates are required

## Difference from Singleton

- application scope is tied to ServletContext, not Spring container.

