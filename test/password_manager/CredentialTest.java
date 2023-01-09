package password_manager;

import org.junit.jupiter.api.Test;
import password_manager.credential.Credential;

import static org.assertj.core.api.Assertions.assertThat;

public class CredentialTest {
    @Test
    void stringWithSemicolon_fieldContentIsSafe_isFalse() throws Exception {
        String content = "text;text";

        Credential credential = new Credential("some title");
        boolean isSafe = credential.fieldContentIsSafe(content);

        assertThat(isSafe).isFalse();
    }

    @Test
    void stringWithBackslashN_fieldContentIsSafe_isFalse() throws Exception {
        String content = "text\ntext";

        Credential credential = new Credential("some title");
        boolean isSafe = credential.fieldContentIsSafe(content);

        assertThat(isSafe).isFalse();
    }
}
