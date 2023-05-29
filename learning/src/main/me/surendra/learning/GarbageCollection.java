package me.surendra.learning;

public class GarbageCollection {

    public class Inner { }

    public GarbageCollection.Inner inner(){
        return new GarbageCollection.Inner();
    }

    @Override
    protected void finalize() throws Throwable {
        // as you know finalize is called by the garbage collector due to destroying an object instance
        System.out.println("I am destroyed !");
    }

}
