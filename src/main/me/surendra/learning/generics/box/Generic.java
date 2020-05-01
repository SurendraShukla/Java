package me.surendra.learning.generics.box;

class Generic<T> {
    protected T t;

    public void setObj(T t) {
        this.t = t;
    }

    public T getObj() {
        return t;
    }

    public static void main(String[] args) {

        System.out.println(" ");

        Generic<Integer> integerBox = new Generic<>();
        System.out.println(integerBox);

        System.out.println(" ");
        Class<?>[] dontKnow = new Class<?>[]{};
        System.out.println(dontKnow.getClass());
        System.out.println(dontKnow);
        System.out.println(" ");
    }

}
