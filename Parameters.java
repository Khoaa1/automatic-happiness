import java.util.*;

public class Parameters {
    public void changeString(String s) {
        s = "Farvel";
    }

    public String changeStringForReal(String s) {
        s = "Farvel";
        return s;
    }

    public void changeInteger(Integer i) {
        i = 24;
    }

    public void changeInt(Integer i) {
        i = 24;
    }

    public void changeList(List<String> l) {
        l.add("Farvel");
    }

    public void changeArr(int[] a) {
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
    }

    public void test() {
        String test_string = "Hej";
        changeString(test_string);
        System.out.println(test_string); //Should print?

        //Typically you would change it like this:
        test_string = changeStringForReal(test_string);
        System.out.println(test_string); //Should print?

        //int has an object type, is it the same case?
        Integer test_Integer = new Integer(42);
        changeInteger(test_Integer);
        System.out.println(test_Integer); //Should print?

        //The same, in particular, goes for the primitive type
        int test_int = 42;
        changeInt(test_int);
        System.out.println(test_int); //Should print?

        //Actually you can auto-box the primitive type:
        changeInteger(test_int); //it compiles
        //And the other way around?
        changeInt(test_Integer); //auto-unboxing

        //What about collections/lists?
        List<String> test_list = new ArrayList<>();
        test_list.add(test_string); //Should print?
        changeList(test_list);
        System.out.println(test_list); //Should print?

        //And (primitive) arrays?
        int[] test_arr = new int[]{1, 2, 3};
        changeArr(test_arr);
        for(int i : test_arr) { //Should print?
            System.out.print(i + " "); 
        }
    }
}