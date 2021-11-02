package cs.daniel.assignmenttwojson;

public class Model {
    String imageUrl;
    String user;
    String like;

    public Model(String imageUrl, String user, String like) {
        this.imageUrl = imageUrl;
        this.user = user;
        this.like = like;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
