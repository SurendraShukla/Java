package me.surendra.learning.spring.boot.hello;

import org.springframework.stereotype.Component;

@Component
public class Processor2 implements Processor {
    @Override
    public void applyStatus(final String str) {
        System.out.println("Processor2" + str);
    }
}
