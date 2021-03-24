package kg.megacom;

import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final int coef = 10000000;

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        fillSet(hashSet, linkedHashSet);
        System.out.println(ANSI_GREEN + "Анализ работы метода Math.random().\n" + ANSI_RESET +
                ANSI_YELLOW + "\nПроверка 1: " + ANSI_RESET + "процент унакальных значений при генерации 10_000_000 чисел." +
                ANSI_YELLOW + "\nМетодика: " + ANSI_RESET + "генерируется 10_000_000 чисел, в допустимом диапазоне от 0 до 9_999_999" +
                "\nрезультаты записываются в HashSet, затем подсчитывая количество полученных уникальных значений" +
                "\nвысчитываю процент уникальных значений");
        float res1 = hashSet.size() / (coef / 100);
        System.out.println(ANSI_RED + "Результат (округленно до целых): " + Math.round(res1) + "%" + ANSI_RESET);

        System.out.println(ANSI_YELLOW + "\nПроверка 2: " + ANSI_RESET + "Поиск количества случаев, что соседние элементы множества различаются друг от друга не более чем на 10" +
                ANSI_YELLOW + "\nМетодика: " + ANSI_RESET + "генерируется 10_000_000 чисел, в допустимом диапазоне от 0 до 9_999_999" +
                "\nрезультаты записываются в LinkedHashSet, соседние элементы сравниваются друг с другом, " +
                "\nесли соседние элементы различаются друг от друга не больше чем на 10, счетчик событий увеличивается");
        chainSize(linkedHashSet);

        System.out.println(ANSI_YELLOW + "\nПроверка 3: " + ANSI_RESET + "анализ распределения значений генерируемых значений" +
                ANSI_YELLOW + "\nМетодика: " + ANSI_RESET + "генерируется 10_000_000 чисел, в допустимом диапазоне от 0 до 9_999_999" +
                "\nрезультаты записываются в HashSeе. Диавпазон от  до 9_999_999 делится на 20 равных частей " +
                "\nи наглядно демонстрируется, сколько уникальных значений попало в диапазон. Данная проверка продемонстрирует" +
                "\nкак распределяются результаты MathRandom: по Гауссовскому  или по нормальному распределению.\n");
        System.out.println(ANSI_RED + "Результат: " + ANSI_RESET);
        chart(hashSet);

    }

    static void fillSet(Set<Integer> set1, Set<Integer> set2) {
        for (int i = 0; i < coef; i++) {
            int temp = (int) (Math.random() * coef);
            set1.add(temp);
            set2.add(temp);
        }
    }

    static void chainSize(Set<Integer> set) {
        int max = 1;
        Integer previus = 0;
        Integer current = 0;
        for (Integer set1 : set) {
            current = set1;

            if (current <= previus + 10 && current >= previus - 10) {
                max++;
            }
            previus = current;
        }
        if (max > 1) {
            System.out.println(ANSI_RED + "Результат : " + max + " раз соседние уникальные значения различались на 10 и менее " +
                    "\nиз множества равного " + set.size() + " элементам" + ANSI_RESET);
        } else
            System.out.println(ANSI_RED + "Результат : не было последовательных уникальных значений, различающихся не более чем на 10" + ANSI_RESET);
    }


    static void chart(Set<Integer> set) {
        int[][] array = new int[20][1];

        for (Integer set1 : set) {
            switch (set1 / (coef / 20)) {
                case (0) -> array[0][0]++;
                case (1) -> array[1][0]++;
                case (2) -> array[2][0]++;
                case (3) -> array[3][0]++;
                case (4) -> array[4][0]++;
                case (5) -> array[5][0]++;
                case (6) -> array[6][0]++;
                case (7) -> array[7][0]++;
                case (8) -> array[8][0]++;
                case (9) -> array[9][0]++;
                case (10) -> array[10][0]++;
                case (11) -> array[11][0]++;
                case (12) -> array[12][0]++;
                case (13) -> array[13][0]++;
                case (14) -> array[14][0]++;
                case (15) -> array[15][0]++;
                case (16) -> array[16][0]++;
                case (17) -> array[17][0]++;
                case (18) -> array[18][0]++;
                case (19) -> array[19][0]++;
            }
        }
        for (int i = 0; i < 20; i++) {
            System.out.print("От " + Math.abs((coef / 20) * (i + 1) - coef) + " До " + (Math.abs((coef / 20) * i - coef) - 1) + ":  ");
            System.out.println(ANSI_CYAN + array[i][0] + " значений в множестве" + ANSI_RESET);


        }

    }

}
