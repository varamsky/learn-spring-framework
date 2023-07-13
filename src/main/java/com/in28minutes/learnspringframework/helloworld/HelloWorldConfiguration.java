package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Records eliminate verbosity in creating Java Beans
 * Public accessor methods, constructor, equals, hashcode and toString() are automatically created
 * Released in Java 16
 */
record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        /*
        @Bean indicates that this method creates a Bean to be managed by the Spring Container

        The @Bean annotation creates a Bean class for name with
        - a public default constructor,
        - private instance variables,
        - getters and setters for instance variables
        - needs to be serializable(should implement java.io.Serializable)
        @Bean has similarities with Record but
        Records are IMMUTABLE whereas,
        Beans are MUTABLE
        */
        return "Ranga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("BakerStreet", "London");
    }

    @Bean(name = "address3")
    // this is needed in using the Bean by Parameters(for example, in the person3Parameters)
    public Address address3() {
        return new Address("Motinagar", "Hyderabad");
    }

    @Bean(name = "address4")
    @Qualifier("address4Qualifier") // @Primary and @Qualifier have similar usage, they help in prioritizing a Bean when multiple Beans of matching Types are available
    public Address address4() {
        return new Address("Ramnagar", "Ranchi");
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address()); // relationship between Beans name, age, address and person2MethodCall
    }

    @Bean
    @Primary
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    public Person person4Qualifier(String name, int age, @Qualifier("address4Qualifier") Address address) {
        return new Person(name, age, address);
    }
}
