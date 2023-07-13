package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // A Spring Container accepts Java objects(POJOs or Beans or Records) and Configuration
        // The Spring Container manages Spring Beans and their lifecycles

        // There are 2 types of Spring Containers:
        // 1. Bean Factory: Basic Spring Container
        // 2. Application Context: Advanced Spring Container with Enterprise-specific features like
        // - Easy to use in web applications, web services, REST API and microservices
        // - Easy internationalization
        // - Easy integration with SpringAOP
        // Application Context is the most widely used Spring Container
        // Bean Factory has less usage. It might be used in memory-constrained scenarios like IOT

        // Here, we create the
        // Records(objects) in HelloWorldConfiguration and the
        // HelloWorldConfiguration(configuration)
        // and feed it to the Spring Container AnnotationConfigApplicationContext.
        // AnnotationConfigApplicationContext is an Application Context Spring Container

        // Spring Container, Spring Context and IOC Container - all of these refer to the same thing


        // 1: Launch a Spring Context
        // 2: Configure the things that we want Spring Framework to manage -
        // HelloWorldConfiguration - @Configuration
        // name - @Bean
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        /*
        Here, the var context line doesn't show any error but, it is possible that the context is not closed in the case of an Exception and that can lead to resource leak
        Therefore, we can do something called try-with-resources

        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // move all the code that uses context here
        }

         */

        // 3: Retrieving Beans managed by Spring
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("address2"));
        System.out.println(context.getBean("person4Qualifier"));
        // retrieving Beans by type(i.e., by class)
        //System.out.println(context.getBean(Address.class)); // remove the multiple Address Beans to run this without Exception
        System.out.println(context.getBean(Person.class)); // this is similar to Address.class but, in this case person3Parameters has the @Primary annotation and this helps Spring to preference to the person3Parameters Bean

        // list all the Beans managed by the Spring Framework
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
