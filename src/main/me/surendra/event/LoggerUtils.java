package me.surendra.event;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.FieldPosition;
import java.text.MessageFormat;

public class LoggerUtils {

    private static final FieldPosition POSITION = new FieldPosition(0);
    private static final int ARG_INCREMENT = 32;

    public static String format(final CharSequence message, final Object... args) {
        if (Size.isEmpty(args)) {
            return Size.isEmpty(message) ? "" : message.toString();
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Throwable) {
                args[i] = expand((Throwable) args[i]);
            }
        }

        final String m;
        if (Size.isEmpty(message)) {
            m = buildPlaceholderMessage(args.length);
        } else {
            m = message.toString();
        }

        final StringBuffer buf = new StringBuffer(m.length() + ARG_INCREMENT * args.length);
        try {
            new MessageFormat(m).format(args, buf, POSITION);
        } catch (final Exception e) {
            return buildLogFormatErrorMessage(message, args, e);
        }
        return buf.toString();
    }

    private static String expand(final Throwable t) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);

        t.printStackTrace(pw);

        pw.close();

        return sw.toString();
    }

    private static String buildLogFormatErrorMessage(
        final CharSequence message,
        final Object[] args,
        final Exception e) {
        final StringBuilder buf = new StringBuilder(args.length * ARG_INCREMENT);
        final StringSequence comma = new StringSequence("", ", ");

        buf.append("Message [").append(message).append("] Values [");

        for (final Object arg : args) {
            buf.append(comma.next()).append("[").append(arg).append("]");
        }

        buf.append("] LOG FORMAT EXCEPTION [").append(e).append("]");

        return buf.toString();
    }


    /**
     * Generates a placeholder message that will show each argument.
     *
     * @param argLength the number of arguments.
     *
     * @return a string like "{0}, {1}, {2}" (if argLength is 3).
     */
    private static String buildPlaceholderMessage(final int argLength) {
        final StringBuilder buf = new StringBuilder(argLength * ARG_INCREMENT);
        final StringSequence comma = new StringSequence("", ", ");

        for (int i = 0; i < argLength; i++) {
            buf.append(comma.next()).append("[{").append(i).append("}]");
        }

        return buf.toString();
    }

    private static class StringSequence {

        private final String[] sequence;
        private final int sequenceLength;
        private final String lastString;
        private int index = 0;

        /**
         * Constructor.
         *
         * @param sequence the string sequence in order.
         */
        StringSequence(final String... sequence) {
            this.sequence = sequence;
            sequenceLength = size(sequence);

            // Compute the last string that we'll return once we've exceeded the sequence length.
            // This prevents us from having to look up the last string repeatedly, since in normal
            // usage the last string is going to be the one that is used most often.
            lastString = sequenceLength > 0 ? sequence[sequenceLength - 1] : "";
        }

        <T> int size(final T[] objectArray) {
            return (objectArray != null) ? objectArray.length : 0;
        }

        /**
         * @return the current string in the sequence and advance to the next string.
         *         Returns the last string forever once the sequence has been exhausted.
         */
        String next() {
            final String value;

            if (index >= sequenceLength) {
                value = lastString;
            } else {
                value = sequence[index];
                index++;
            }

            return (value != null) ? value : "";
        }
    }
}
