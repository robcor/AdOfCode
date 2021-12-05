import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaTest {

    @Test
    void listRemove(){
        List<Long> l = Arrays.asList(0l,1l, 2l,3l,4l);
        List<Long> ld = new ArrayList<>(  );
        ld.addAll( l );

        ld.remove(1);
        ld.remove(3);

    }
}
