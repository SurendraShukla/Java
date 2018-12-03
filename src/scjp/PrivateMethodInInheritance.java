class ParentClass {

    private String overrideMethod() {
        return "Parent class override method";
    }

    public String callOverrideMethodFromParent() {
        return this.overrideMethod();
    }

    public String methodCallFromParent() {
        return this.callOverrideMethodFromParent();
    }
}


class ChildClass extends ParentClass {

    public String overrideMethod() {
        return "child class fun";
    }

    public String methodCallFromChild() {
        return this.callOverrideMethodFromParent();
    }

}


public class PrivateMethodInInheritance{

     public static void main(String []args){
        ChildClass obj = new ChildClass();
        System.out.println(obj.methodCallFromChild());
     }
}
