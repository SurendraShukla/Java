package me.surendra.learning.spring.boot.hello;

import org.springframework.stereotype.Component;

@Component
public class Processor1 implements Processor {
    @Override
    public void applyStatus(final String str) {
        System.out.println("Processor1" + str);
    }
}
