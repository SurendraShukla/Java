package me.surendra.learning.spring.boot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessHandler {

    private List<Processor> processors;

    @Autowired
    public ProcessHandler(final List<Processor> processors) {
        this.processors = processors;
    }

    public String displayProcessCount() {
        return this.processors.size() + "";
    }

}
