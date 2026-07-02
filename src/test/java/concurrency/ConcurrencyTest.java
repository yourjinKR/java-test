package concurrency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConcurrencyTest {
    private static long count = 0;

    @Test
    void likeToggleTest() throws InterruptedException {
        // given
        int mxCnt = 1000;

        for (int i = 0; i < mxCnt; i++) {
            new Thread(() -> {
                count++;
                System.out.println(count);
            }).start();
        }

        Thread.sleep(100);
        assertThat(count).isEqualTo(mxCnt);
    }

}
