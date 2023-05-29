package me.surendra.design_patterns.Adapter.Post;

public class Twitter {

    public void checkUserToken(String userId) {
        System.out.println("Twitter userId is "+userId);
    }

    public void setStatusUpdate(String message) {
        System.out.println("Posted message:'"+message+"' on Twitter.");
    }

}
