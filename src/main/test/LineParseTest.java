import command.Echo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.StringUtils.parseCommand;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/10
 */
public class LineParseTest {

    @Test
    void testBackslash() {
        //
        // > echo 'shell\\\ntest'
        // Expected: "shell\\\ntest"
        assertThat(parse("echo 'shell\\\\\\ntest'"))
                .containsExactly("echo", "shell\\\\\\ntest");


        assertThat(parse("echo \"before\\   after\""))
                .containsExactly("echo", "before\\   after");

        assertThat(parse("echo shell\\ \\ \\ \\ \\ \\ hello"))
                .containsExactly("echo", "shell      hello");

        assertThat(parse("echo example\\nscript"))
                .containsExactly("echo", "examplenscript");

        assertThat(parse("echo \"/tmp/foo/f\\n40\""))
                .containsExactly("echo", "/tmp/foo/f\\n40");

        assertThat(parse("echo \"/tmp/foo/f\\67\""))
                .containsExactly("echo", "/tmp/foo/f\\67");

        assertThat(parse("echo \"/tmp/foo/f'\\'47\""))
                .containsExactly("echo", "/tmp/foo/f'\\'47");
        assertThat(parse("echo \"hello'script'\\\\n'world\""))
                .containsExactly("echo", "hello'script'\\n'world");

        assertThat(parse("echo \"hello\\\"insidequotes\"script\\\""))

                .containsExactly("echo", "hello\"insidequotesscript\"");
    }

    String[] parse(String input) {

        return  parseCommand(  input);
    }

}
