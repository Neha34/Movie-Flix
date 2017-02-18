package movie.flix.model;

public class loginResponse {

    private String token;
    private String userName;
    private String userRole;
    private int userId;

    public loginResponse(final String token, final int userId, final String userName, final String userRole) {
        this.token = token;
        this.userName = userName;
        this.userRole = userRole;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
