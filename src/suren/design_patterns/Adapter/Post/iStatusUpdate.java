package suren.design_patterns.Adapter.Post;

public interface iStatusUpdate {
    void getUserToken(String userId);
    void postUpdate(String message);
}
