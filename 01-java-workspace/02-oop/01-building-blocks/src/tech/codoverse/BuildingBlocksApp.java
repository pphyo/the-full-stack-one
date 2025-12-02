package tech.codoverse;

import java.util.Arrays;
import static java.lang.IO.*;

import static java.util.Collections.max;
import java.sql.Date;

public class BuildingBlocksApp {

    // default or implicit constructor
    // public BuildingBlocksApp() {super();}

    void main() {
        creationObjects();
    }

    @SuppressWarnings("deprecation")
    void creationObjects() {
        try {
            // 1 normal way
            Player withNewKeyword = new Player();
            IO.println("With new keyword: " + withNewKeyword);

            // 2 call Player's no arg const
            Object withNewInstancev1 = Class.forName("tech.codoverse.Player").newInstance();
            IO.println("With forName: " + withNewInstancev1);

            // Object withNewInstancev2 = withNewKeyword.getClass().newInstance();
            // Object withNewInstancev3 = Player.class.newInstance();

            Player withConstructorNewInstance = Player.class
                    .getDeclaredConstructor(String.class, int.class, double.class)
                    .newInstance("", 0, 0);
            IO.println("With Constructor.newInstance: " + withConstructorNewInstance);

            var withClone = withNewKeyword.clone();
            IO.println("With clone(): " + withClone);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void launch(String... labels) {
        int[] array = { 5, 3, -5, 4, 6, 9, 1 };
        println(Arrays.toString(array));

        Arrays.sort(array);

        println("Sorted Array: " + Arrays.toString(array));

        int foundIndex = Arrays.binarySearch(array, -5);
        println(foundIndex);

        var sqlDate = new Date(10L);
        println(sqlDate.getClass());

        java.util.Date utilDate = new java.util.Date();
        println(utilDate.getClass());

        int max = max(Arrays.asList(5, 3, -5, 4, 6, 9, 1));
        println(max);
    }

}