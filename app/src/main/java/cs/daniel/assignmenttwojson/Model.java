package cs.daniel.assignmenttwojson;

public class Model {
    String imageUrl;
    String like;
    String user;

    public Model(String imageUrl, String like, String user) {
        this.imageUrl = imageUrl;
        this.like = like;
        this.user = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
