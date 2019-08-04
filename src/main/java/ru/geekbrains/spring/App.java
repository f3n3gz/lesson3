package ru.geekbrains.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ((AnnotationConfigApplicationContext) context).close();
//        final EntityManager entityManager = Persistence.createEntityManagerFactory("sample")
//                                            .createEntityManager();
//        entityManager.close();
    }
}
