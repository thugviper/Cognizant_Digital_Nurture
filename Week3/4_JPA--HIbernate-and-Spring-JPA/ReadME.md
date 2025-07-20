# Hands-on 4: Difference Between JPA, Hibernate, and Spring Data JPA

## Exploring JPA, Hibernate, and Spring Data JPA
This document presents  distinctions between **JPA**, **Hibernate**, and **Spring Data JPA** 
through concise explanations and real-world code illustrations.

## What is JPA?
Java Persistence API (JPA) is an official Java standard (JSR 338) for object-relational mapping. JPA itself is only a set of interfaces—it doesn’t do any database 
operations directly. You use JPA to annotate classes (like @Entity, @Id, etc.) to map Java objects to database tables.

Implementations: Hibernate implements JPA, but so do EclipseLink, OpenJPA, and others.

### What is Hibernate?
Hibernate is a full-fledged ORM framework for Java and one of the main JPA providers.
Besides fulfilling the JPA contract, Hibernate adds features (like HQL, multi-level caching, etc.).
You have to write more code for session and transaction management unless using a higher-level abstraction.

### Simple Hibernate Example:
```java
public int saveEmployee(Employee emp) {
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    int id = (int) session.save(emp);
    tx.commit();
    session.close();
    return id;
}
```

### What is Spring Data JPA?
Spring Data JPA provides an even higher-level abstraction over JPA and Hibernate.
It allows you to work with repositories, eliminating much of the routine implementation work.
Spring Data JPA manages sessions, transactions, and offers advanced query generation via method names.

### Simple Spring Data JPA Example:
```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Spring automatically creates this method!
    List<Employee> findByName(String name);
}
```

## Key Differences

| Feature                        | **JPA** (Java Persistence API)                | **Hibernate**                                   | **Spring Data JPA**                          |
|---------------------------------|-----------------------------------------------|-------------------------------------------------|----------------------------------------------|
| **Type**                       | Specification / API                           | ORM Implementation / JPA Provider               | Spring Abstraction Layer over JPA            |
| **Provides Implementation**     | No                                         | Yes                                          | No (requires JPA provider like Hibernate)  |
| **Session/Transaction Handling**| Managed via EntityManager (manual setup)      | Explicit Session/Transaction API (manual)       | Automatic (managed by Spring)                |
| **Boilerplate Code**            | Moderate (DAO patterns, entity manager ops)   | Higher (manual session, transaction handling)   | Minimal (Repositories, auto-queries)         |
| **Query Support**               | JPQL (Java Persistence Query Language)        | JPQL, HQL, Native SQL, Criteria API             | Method-name based queries, JPQL, custom SQL  |
| **Advanced Features**           | None (standard spec only)                     | Caching, custom mappings, custom types, more    | Pagination, sorting, auditing, auto-impl.    |
| **Repository Layer**            | Not included                                  | Not included                                    | Built-in (CrudRepository, JpaRepository, etc)|
| **Typical Vendor**              | Oracle (specification)                        | Red Hat                                         | Spring Team                                  |
| **Portability**                 | High (vendor agnostic)                        | Moderate (tied to Hibernate, but JPA compliant) | High (vendor independent via JPA)            |
| **Use-case**                    | Defining entity mappings, vendor choice       | Direct low-level ORM, advanced DB features      | Ultra-fast business CRUD/repo development    |

---


## Summary List/Core Takeaways
JPA tells you what to do, not how—a blueprint.
Hibernate enacts the blueprint with additional tools.
Spring Data JPA makes database operations easier, hides much of the plumbing, and amplifies productivity.
