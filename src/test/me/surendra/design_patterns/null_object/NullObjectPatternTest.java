package me.surendra.design_patterns.null_object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NullObjectPatternTest {
    @Test
    public void shouldWorkWithNullDateInput() {
        // Raw data coming in, for example from a browser request
        final List<AddCustomerRequest> rawData = Lists.newArrayList(
            new AddCustomerRequest("name 1", 1, new Date()),
            new AddCustomerRequest("name 2", 2, null)
        );

        // Apply the Null Object pattern to prevent nulls entering the system
        final List<DataFromUIClean> cleanData = cleanUp(rawData);

        // Proceed with the required business logic to update the database
        storeDataInTheDatabase(cleanData);
    }

    private List<DataFromUIClean> cleanUp(final List<AddCustomerRequest> rawData) {
        return rawData.stream().map(d -> d.cleanVersion()).collect(Collectors.toList());
    }

    private void storeDataInTheDatabase(final List<DataFromUIClean> dataFromUI) {
        System.out.println("All dates should be non-null at this point: ");
        dataFromUI.forEach(d -> System.out.println(d.getDate()));
    }

    @JsonAutoDetect
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class AddCustomerRequest {
        private final String name;
        private final int id;
        private final Date date;

        public AddCustomerRequest(final String name, final int id, final Date date) {
            this.name = name;
            this.id = id;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public Date getDate() {
            return date;
        }

        public DataFromUIClean cleanVersion() {
            return new DataFromUIClean(name, id, date);
        }
    }

    public static class DataFromUIClean {
        private final String name;
        private final int id;
        private final DateClean date;

        DataFromUIClean(final String name, final int id, final Date date) {
            this.name = name;
            this.id = id;
            this.date = CleanDateFactory.wrap(date);
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        Date getDate() {
            return date.getDate();
        }
    }

    private interface DateClean {
        Date getDate();
    }

    private static class CleanDateFactory {
        static DateClean wrap(final Date date) {
            if (date == null) {
                return new NullDate();
            } else {
                return new RealDate(date);
            }
        }

        private static class RealDate implements DateClean {
            private final Date date;

            RealDate(final Date date) {
                this.date = date;
            }

            @Override
            public Date getDate() {
                return date;
            }
        }

        private static class NullDate implements DateClean {
            @Override
            public Date getDate() {
                return new Date(Long.MAX_VALUE);
            }
        }
    }
}
