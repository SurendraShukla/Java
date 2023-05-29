package me.surendra.learning.spring.boot.hello;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.mockito.Mock;

public class ProcessHandlerTest {

    @Mock private Processor processor;

    @Test
    public void shouldDisplayProcessCount() {
        ProcessHandler processHandler = new ProcessHandler(Lists.newArrayList(processor));

        processHandler.displayProcessCount();
    }

}
