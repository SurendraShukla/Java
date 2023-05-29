package me.surendra.learning.functional_interface;

interface SupplierAndConsumer<T>{
    T consumeAndThenSupply(T t1, T t2);
}
