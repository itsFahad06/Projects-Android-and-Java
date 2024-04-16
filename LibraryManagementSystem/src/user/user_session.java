package user;

public class user_session {
    private static String userId;

    public static void setUserId(String userId) {
        user_session.userId = userId;
    }

    public static String getUserId() {
        return userId;
    }
}
