
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnagramsSetTest {


    @Test
    public void check_Anagrams() {
        boolean test = true;
        Assert.assertEquals(test, true);
    }

    @Test
    public void givenFileName_whenUsingFileUtils_thenFileData() throws IOException {
        String expectedData = "Hello world";
        Path path = Paths.get("C:\\Users\\Alien Ware\\Documents\\java\\file_test.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        Assert.assertEquals(expectedData, line);
    }

    @Test
    public void Check_First_Not_Anagrams() {
        List<String> anagrams = new ArrayList<>();
        anagrams.add("race");
        anagrams.add("care");
        anagrams.add("hearth");
        boolean status;

        String stringOne = anagrams.get(1).replaceAll("\\s", "");
        String stringTwo = anagrams.get(2).replaceAll("\\s", "");

        if (stringOne.length() != stringTwo.length()) {
            status = false;
        } else {
            char[] ArrayS1 = stringOne.toLowerCase().toCharArray();
            char[] ArrayS2 = stringTwo.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }

        Assert.assertFalse(status);
    }

    @Test
    public void Check_First_With_A_List() {
        List<String> anagrams = new ArrayList<>();
        anagrams.add("race");
        anagrams.add("care");
        boolean status;

        String stringOne = anagrams.get(0).replaceAll("\\s", "");
        String stringTwo = anagrams.get(1).replaceAll("\\s", "");

        if (stringOne.length() != stringTwo.length()) {
            status = false;
        } else {
            char[] ArrayS1 = stringOne.toLowerCase().toCharArray();
            char[] ArrayS2 = stringTwo.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        if (status) {
            System.out.println(stringOne + " and " + stringTwo + " are anagrams");
        }

        Assert.assertTrue(status);
    }


    @Test
    public void Check_With_All_Words_A_List() {
        List<String> anagrams = new ArrayList<>();
        anagrams.add("race");
        anagrams.add("care");


        List<String> listOfAnagrams = new ArrayList<>();
        System.out.println("Antes" + anagrams);

        for (int x = 0; x < anagrams.size(); x++) {
            anagrams.get(x).replaceAll("\\s", "");
        }
        System.out.println("Despues" + anagrams);

        List<String> reverseAnagrams = new ArrayList<>(anagrams);
        Collections.reverse(reverseAnagrams);
        boolean first = true;

        for (String x : anagrams) {
            for (String y : reverseAnagrams) {
                first = areAnagrams(x, y, listOfAnagrams, first);
            }
        }
        System.out.println(listOfAnagrams);

    }

    private boolean areAnagrams(String stringOne, String stringTwo, List<String> listOfAnagrams, boolean firstTime) {
        if (firstTime) {
            anagrams(stringOne,stringTwo,listOfAnagrams);
        }else{
            if (listOfAnagrams.contains(stringOne + stringTwo)) {
                anagrams(stringOne,stringTwo,listOfAnagrams);
            }
        }

        return false;
    }

    private void anagrams(String stringOne, String stringTwo, List<String> listOfAnagrams) {
        boolean status = false;
        if (stringOne.length() != stringTwo.length()) {
            status = false;
        } else {
            char[] ArrayS1 = stringOne.toLowerCase().toCharArray();
            char[] ArrayS2 = stringTwo.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        if (status) {
            listOfAnagrams.add(stringOne + " " + stringTwo);
        }
    }



}
