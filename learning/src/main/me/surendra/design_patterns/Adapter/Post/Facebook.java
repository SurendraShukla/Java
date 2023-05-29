package me.surendra.design_patterns.Adapter.Post;

public class Facebook {

    public void getUserToken(String userId) {
        System.out.println("Facebook userId is "+userId);
    }

    public void postUpdate(String message) {
        System.out.println("Posted message:'"+message+"' on Facebook.");
    }

}
