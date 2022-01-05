package bowling.engine;

import java.util.Arrays;
import java.util.List;

import bowling.engine.collection.FirstClassList;
import bowling.engine.collection.FirstClassMutableList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class FirstClassMutableListTest {
    static final class TestMutableList extends FirstClassMutableList<TestObject> {
        public TestMutableList(List<TestObject> collection) {
            super(collection);
        }

        public static TestMutableList of(TestObject ... elements) {
            return new TestMutableList(Arrays.asList(elements));
        }
    }

    @Test
    public void append() {
        final FirstClassList<TestObject> testList = TestMutableList.of(TestObject.OBJ1);
        final FirstClassList<TestObject> appended = testList.append(TestObject.OBJ2);
        assertThat(appended.size()).isEqualTo(2);
        assertThat(appended.collect()).containsExactly(TestObject.OBJ1, TestObject.OBJ2);
        assertThat(appended).isEqualTo(TestMutableList.of(TestObject.OBJ1, TestObject.OBJ2));

        assertThat(testList).isEqualTo(TestMutableList.of(TestObject.OBJ1, TestObject.OBJ2));
        assertThat(testList).isEqualTo(appended);
        assertThat(testList == appended).isTrue();
    }

    @ParameterizedTest(name = "append failed: {arguments}")
    @NullSource
    public void appendFailed(TestObject obj) {
        final FirstClassList<TestObject> testList = TestMutableList.of(TestObject.OBJ1);
        assertThatIllegalArgumentException().isThrownBy(() -> testList.append(obj));
    }
}
