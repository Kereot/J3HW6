public class Homework2 {

    // Задание немного противоречиво.
    // Написано: "Если в нем нет хоть одной четверки ИЛИ единицы, то метод вернет false".
    // Однако в примере показано, что наличие только четверок или единиц возвращает false.
    // Получается, задание должно звучать: "Если в нем нет хоть одной четверки И единицы, то метод вернет false".
    public boolean checkPair(int[] arr, int a, int b) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != a && arr[i] != b) {
                return false;
            }
            if (arr[i] == a) {
                x++;
            }
            if (arr[i] == b) {
                y++;
            }
        }
        return x != 0 && y != 0;
    }
}
