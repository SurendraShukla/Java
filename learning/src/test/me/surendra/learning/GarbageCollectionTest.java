package me.surendra.learning;

import org.junit.Test;

public class GarbageCollectionTest {

    @Test
    public void shouldGarbageCollect() {
        GarbageCollection outer = new GarbageCollection();
        GarbageCollection.Inner inner = outer.new Inner();

        // out instance is no more used and should be garbage collected !!!
        // However this will not happen as inner instance is still alive i.e used, not null !
        // and outer will be kept in memory until inner is destroyed
        outer = null;

        // Uncommenting below line will allow garbage collector to destroy outer variable
        // inner = null;

        //kick out garbage collector
        System.gc();

    }

}
