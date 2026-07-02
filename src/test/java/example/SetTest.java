package example;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("set 크기 확인")
    void checkSize() {
        assertThat(numbers.size())
                .isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("set 값 있는지 확인")
    @ValueSource(ints = {1,2,3,4})
    void contains(int value) {
        assertThat(numbers.contains(value))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("set에 없는 값 확인")
    @ValueSource(ints = {5,6,7,8})
    void containsInvalidValue(int value) {
        assertThat(numbers.contains(value))
                .isFalse();
    }
}
