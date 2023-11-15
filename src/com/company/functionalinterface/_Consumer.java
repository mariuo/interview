package com.company.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args){

        greetCustomer(new Customer("Maria", "99999999"));
        greetCustomerConsumer.accept((new Customer("ALex", "55555")));
        greetCustomerConsumerV2.accept((new Customer("Jao", "55555")), false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out.println("Hello "+ customer.customerName
            + ", thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "****"));
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello "+ customer.customerName
            + ", thanks for registering phone number " + customer.customerPhoneNumber);
    static void greetCustomer(Customer customer){
        System.out.println("Hello "+ customer.customerName + ", thanks for registering phone number " + customer.customerPhoneNumber);
    }
    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;
        Customer(String customerName, String customerPhoneNumber){
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
