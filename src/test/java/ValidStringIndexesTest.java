import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ValidStringIndexesTest {

    @Test
    public void shouldGetCorrectSize() {
        ValidStringIndexes validStringIndexes = new ValidStringIndexes(0, 3);
        Assert.assertEquals(4, validStringIndexes.getSize());

        ValidStringIndexes validStringIndexes1 = new ValidStringIndexes(0, 1);
        Assert.assertEquals(2, validStringIndexes1.getSize());

        ValidStringIndexes validStringIndexes2 = new ValidStringIndexes(1, 2);
        Assert.assertEquals(2, validStringIndexes2.getSize());
    }
}
