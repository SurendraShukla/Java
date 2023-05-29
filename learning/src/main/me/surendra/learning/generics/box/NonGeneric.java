package me.surendra.learning.generics.box;

// This won't work for primitive data type ( int, double,)
class NonGeneric {
    protected Object obj;

    public void setObj(Object object) {
        this.obj = object;
    }

    public Object getObj() {
        return obj;
    }
}


