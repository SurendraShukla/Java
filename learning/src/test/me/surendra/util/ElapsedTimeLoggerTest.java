package me.surendra.util;


import org.junit.Test;

public class ElapsedTimeLoggerTest {

    @Test
    public void test() {
        final String message = "Some Message";
        final ElapsedTimeLogger closeDoesNotGetTriggers = new ElapsedTimeLogger(message);

        try (ElapsedTimeLogger closeDoesGetTriggers = new ElapsedTimeLogger(message)) {
            try {
                Thread.sleep(500);
            } catch (final InterruptedException interruptedException) {
                System.out.println("InterruptedException:[" + interruptedException.getMessage() + "]");
            }
        } catch (final Exception exception) {
            System.out.println("Exception:[" + exception.getMessage() + "]");
        }
    }

}
