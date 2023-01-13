package password_manager.credential;

import java.util.Objects;

/**
 * A Credentials represents a Single record with a title and optional username and/or password
 */
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

    /**
    * can't contain ; or \n because these characters are reserved for csv generation
     */
    public void setTitle(String title) throws Exception {
        if (!fieldContentIsSafe(title)) {
            throw new Exception("Contains invalid char: ';'");
        }
        this.title = title;
    }

    /**
     * can't contain ; or \n because these characters are reserved for csv generation
     */
    public void setPassword(String password) throws Exception {
        if (!fieldContentIsSafe(password)) {
            throw new Exception("Contains invalid char: ';'");
        }
        this.password = password;
    }

    /**
     * can't contain ; or \n because these characters are reserved for csv generation
     */
    public void setUsername(String username) throws Exception {
        if (!fieldContentIsSafe(username)) {
            throw new Exception("Contains invalid char: ';'");
        }
        this.username = username;
    }

    /**
    * Check if a field contains ; or \n
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credential that = (Credential) o;
        return title.equals(that.title) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, username, password);
    }
}
