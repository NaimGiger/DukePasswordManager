package password_manager.credential;

public class Credential {
    private String title;
    private String username;
    private String password;

    public Credential(String title) throws Exception {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setTitle(String title) throws Exception {
        if (!fieldContentIsSafe(title)) {
            throw new Exception("Contains invalid char: ';'");
        }
        this.title = title;
    }

    public void setPassword(String password) throws Exception {
        if (!fieldContentIsSafe(password)) {
            throw new Exception("Contains invalid char: ';'");
        }
        this.password = password;
    }

    public void setUsername(String username) throws Exception {
        if (!fieldContentIsSafe(username)) {
            throw new Exception("Contains invalid char: ';'");
        }
        this.username = username;
    }

     public boolean fieldContentIsSafe(String fieldContent) {
        for (char currentChar : fieldContent.toCharArray()) {
            if (currentChar == ';' || currentChar == '\n') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
