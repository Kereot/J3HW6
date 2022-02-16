import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Homework1 {

    public int[] getTailNoList(int[] arr, int point) {
        if (arr.length == 0) { // Т.к. по заданию передаётся "непустой" массив.
            throw new IllegalArgumentException();
        }

        int a = 0;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[arr.length - 1] == point) {
                return new int[]{};
            }
            if (arr[i] == point) {
                a = i;
                break;
            }
            if (i == 0) {
                throw new RuntimeException();
            }
        }

        return Arrays.copyOfRange(arr, a + 1, arr.length);
    }

    public int[] getTail(int[] arr, int point) { // Изначально это был мой первый вариант, но приведение к int пришлось погуглить.
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] == point) {
                break;
            } else {
                list.addFirst(arr[i]);
            }
            if (i == 0) {
                throw new RuntimeException();
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getTailAlt (int[] arr, int point) { // Захотелось попробовать с .lastIndexOf без fori, но конвертация int <-> Integer стандартными средствами здесь показала себя ещё более страшной.
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());

        int a = list.lastIndexOf(point);
        if (a == -1) {
            throw new RuntimeException();
        }
        int[] tail = list.subList(a + 1, list.size()).stream().mapToInt(Integer::intValue).toArray();

        return tail;
    }
}
