
import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

public class Example5 {

    public static <? extends Number> List<?>arrayToList(?[] a){
        return Arrays.stream(a).collect(Collectors.toList());
    }   SVE TO ŠTO SAM ZAMISLIO, NIJE IZVODLJIVO!!
}
