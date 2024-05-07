package pro.sky.homework215.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.homework215.exception.InvalidIndexException;
import pro.sky.homework215.exception.InvalidStringListException;
import pro.sky.homework215.exception.NoStringException;
import pro.sky.homework215.exception.NoStringListException;

public class StringListImplTest {

    private final StringListImpl stringList = new StringListImpl();
    private final StringListImpl stringList2 = new StringListImpl();
    private final StringListImpl stringList3 = new StringListImpl();
    private final StringListImpl stringList4 = new StringListImpl();
    private final StringListImpl stringList5 = new StringListImpl();

    @Test
    void shouldAddWithoutIndexCorrect() {

        //        Тест: добавлен первый элемент (в исходный массив)
        Assertions.assertEquals("String 01", stringList.add("String 01"));
        //        Тест: второй элемент
        Assertions.assertEquals("String 02", stringList.add("String 02"));
        //        Тест: третий элемент
        Assertions.assertEquals("String 03", stringList.add("String 03"));
        //        Тест: четвертый элемент
        Assertions.assertEquals("String 04", stringList.add("String 04"));
        //        Тест: пятый элемент (размер массива увеличен )
        Assertions.assertEquals("String 05", stringList.add("String 05"));

        //        Тест: (null)
        Assertions.assertThrows(NoStringException.class, () -> stringList.add(null));
    }

    @Test
    void shouldAddWithIndexCorrect() {
//                  Подготовка
        String sTest = stringList.add("String 01");

        //        Тест: добавлен первый элемент (в исходный массив)
        Assertions.assertEquals("String 01", stringList.add(0, "String 01"));
        //        Тест: второй элемент
        Assertions.assertEquals("String 02", stringList.add(1, "String 02"));
        //        Тест: третий элемент
        Assertions.assertEquals("String 03", stringList.add(2, "String 03"));
        //        Тест: четвертый элемент
        Assertions.assertEquals("String 04", stringList.add(3, "String 04"));
        //        Тест: пятый элемент (размер массива увеличен )
        Assertions.assertEquals("String 05", stringList.add(4, "String 05"));

        //        Тест: (превышен размер массива)
        Assertions.assertThrows(InvalidIndexException.class, () -> stringList.add(10, "String 11"));
        //        Тест: (превышен размер занятой части массива)
        Assertions.assertThrows(InvalidIndexException.class, () -> stringList.add(8, "String 09"));

        //        Тест: (null)
        Assertions.assertThrows(NoStringException.class, () -> stringList.add(1, null));
    }

    @Test
    void shouldSetCorrect() {
//                  Подготовка
        String s1Test = stringList.add("String 01");
        String s2Test = stringList.add("String 02");
        String s3Test = stringList.add("String 03");
        String s4Test = stringList.add("String 04");
        String s5Test = stringList.add("String 05");

        //        Тест: (превышен размер массива)
        Assertions.assertThrows(InvalidIndexException.class, () -> stringList.set(10, "String 11"));
        //        Тест: (превышен размер занятой части массива)
        Assertions.assertThrows(InvalidIndexException.class, () -> stringList.set(8, "String 09"));

        //        Тест: (null)
        Assertions.assertThrows(NoStringException.class, () -> stringList.set(1, null));
    }

    @Test
    void shouldRemoveWithoutIndexCorrect() {
//                  Подготовка
        String s1Test = stringList.add("String 01");
        String s2Test = stringList.add("String 02");
        String s3Test = stringList.add("String 03");
        String s4Test = stringList.add("String 04");
        String s5Test = stringList.add("String 05");

        //        Тест: удаление элемента
        Assertions.assertEquals("String 01", stringList.remove("String 01"));
        //        Тест: удаление элемента
        Assertions.assertEquals("String 03", stringList.remove("String 03"));
        //        Тест: удаление элемента
        Assertions.assertEquals("String 05", stringList.remove("String 05"));

        //        Тест: (элемент не найден)
        Assertions.assertThrows(NoStringException.class, () -> stringList.remove("String 09"));

        //        Тест: (null)
        Assertions.assertThrows(NoStringException.class, () -> stringList.remove(null));
    }

    @Test
    void shouldRemoveWithIndexCorrect() {
//                  Подготовка
        String s1Test = stringList.add("String 01");
        String s2Test = stringList.add("String 02");
        String s3Test = stringList.add("String 03");
        String s4Test = stringList.add("String 04");
        String s5Test = stringList.add("String 05");

        //        Тест: удаление элемента
        Assertions.assertEquals("String 01", stringList.remove(0));
        //        Тест: удаление элемента
        Assertions.assertEquals("String 03", stringList.remove(1));
        //        Тест: удаление элемента
        Assertions.assertEquals("String 05", stringList.remove(2));

        //        Тест: (элемент не найден)
        Assertions.assertThrows(InvalidIndexException.class, () -> stringList.remove(8));

    }

    @Test
    void shouldConteinsCorrect() {
//                  Подготовка
        String s1Test = stringList.add("String 01");
        String s2Test = stringList.add("String 02");
        String s3Test = stringList.add("String 03");
        String s4Test = stringList.add("String 04");
        String s5Test = stringList.add("String 05");

        //        Тест: поиск элемента
        Assertions.assertTrue(stringList.contains("String 01"));
        //        Тест: поиск элемента
        Assertions.assertTrue(stringList.contains("String 03"));
        //        Тест: поиск элемента
        Assertions.assertTrue(stringList.contains("String 05"));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertFalse(stringList.contains("String 07"));

    }

    @Test
    void shouldIndexOfCorrect() {
//                  Подготовка
        String s1Test = stringList.add("String 01");
        String s2Test = stringList.add("String 02");
        String s3Test = stringList.add("String 03");
        String s4Test = stringList.add("String 04");
        String s5Test = stringList.add("String 05");

        //        Тест: поиск элемента
        Assertions.assertEquals(0, stringList.indexOf("String 01"));
        //        Тест: поиск элемента
        Assertions.assertEquals(2, stringList.indexOf("String 03"));
        //        Тест: поиск элемента
        Assertions.assertEquals(4, stringList.indexOf("String 05"));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertEquals(-1, stringList.indexOf("String 07"));

    }

    @Test
    void shouldLastIndexOfCorrect() {
//                  Подготовка
        String s1Test = stringList.add("String 01");
        String s2Test = stringList.add("String 02");
        String s3Test = stringList.add("String 03");
        String s4Test = stringList.add("String 04");
        String s5Test = stringList.add("String 05");

        //        Тест: поиск элемента
        Assertions.assertEquals(0, stringList.lastIndexOf("String 01"));
        //        Тест: поиск элемента
        Assertions.assertEquals(2, stringList.lastIndexOf("String 03"));
        //        Тест: поиск элемента
        Assertions.assertEquals(4, stringList.lastIndexOf("String 05"));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertEquals(-1, stringList.lastIndexOf("String 07"));

    }

    @Test
    void shouldGetCorrect() {
//                  Подготовка
        String s1Test = stringList.add("String 01");
        String s2Test = stringList.add("String 02");
        String s3Test = stringList.add("String 03");
        String s4Test = stringList.add("String 04");
        String s5Test = stringList.add("String 05");

        //        Тест: поиск элемента
        Assertions.assertEquals("String 01", stringList.get(0));
        //        Тест: поиск элемента
        Assertions.assertEquals("String 03", stringList.get(2));
        //        Тест: поиск элемента
        Assertions.assertEquals("String 05", stringList.get(4));

        //        Тест: поиск элемента (элемент не найден)
        Assertions.assertThrows(InvalidIndexException.class, () -> stringList.get(8));

    }

    @Test
    void shouldEqualsCorrect() {
//                  Подготовка
        String s11Test = stringList.add("String 01");
        String s12Test = stringList.add("String 02");
        String s13Test = stringList.add("String 03");
        String s14Test = stringList.add("String 04");
        String s15Test = stringList.add("String 05");

        String s21Test = stringList2.add("String 01");
        String s22Test = stringList2.add("String 02");
        String s23Test = stringList2.add("String 03");
        String s24Test = stringList2.add("String 04");
        String s25Test = stringList2.add("String 05");

        String s31Test = stringList3.add("String 01");
        String s32Test = stringList3.add("String 02");
        String s33Test = stringList3.add("String 03");
        String s34Test = stringList3.add("String 04");
        String s35Test = stringList3.add("String 05");
        String s36Test = stringList3.add("String 06");
        String s37Test = stringList3.add("String 07");

        String s41Test = stringList4.add("String 11");
        String s42Test = stringList4.add("String 22");
        String s43Test = stringList4.add("String 13");
        String s44Test = stringList4.add("String 14");
        String s45Test = stringList4.add("String 15");

        //        Тест: сравнение массивов
        Assertions.assertTrue(stringList.equals(stringList2));

        //        Тест: сравнение массивов (не совпадают)
        Assertions.assertFalse(stringList.equals(stringList3));
        //        Тест: сравнение массивов (не совпадают)
        Assertions.assertFalse(stringList.equals(stringList4));

        //        Тест: (null)
        Assertions.assertThrows(NoStringListException.class, () -> stringList.equals(null));

    }

    @Test
    void shouldSizeCorrect() {
//                  Подготовка
        String s11Test = stringList.add("String 01");
        String s12Test = stringList.add("String 02");
        String s13Test = stringList.add("String 03");
        String s14Test = stringList.add("String 04");
        String s15Test = stringList.add("String 05");

        String s21Test = stringList2.add("String 01");
        String s22Test = stringList2.add("String 02");
        String s23Test = stringList2.add("String 03");
        String s24Test = stringList2.add("String 04");
        String s25Test = stringList2.add("String 05");

        String s31Test = stringList3.add("String 01");
        String s32Test = stringList3.add("String 02");
        String s33Test = stringList3.add("String 03");
        String s34Test = stringList3.add("String 04");
        String s35Test = stringList3.add("String 05");
        String s36Test = stringList3.add("String 06");
        String s37Test = stringList3.add("String 07");

        String s41Test = stringList4.add("String 11");
        String s42Test = stringList4.add("String 22");
        String s43Test = stringList4.add("String 13");
        String s44Test = stringList4.add("String 14");
        String s45Test = stringList4.add("String 15");
        String s46Test = stringList4.add("String 16");

        //        Тест: размер массива
        Assertions.assertEquals(5, stringList.size());
        //        Тест: размер массива
        Assertions.assertEquals(5, stringList2.size());
        //        Тест: размер массива
        Assertions.assertEquals(7, stringList3.size());
        //        Тест: размер массива
        Assertions.assertEquals(6, stringList4.size());

    }

    @Test
    void shouldIsEmptyCorrect() {
//                  Подготовка
        String s11Test = stringList.add("String 01");
        String s12Test = stringList.add("String 02");
        String s13Test = stringList.add("String 03");

        //        Тест: проверка массива
        Assertions.assertFalse(stringList.isEmpty());
        //        Тест: проверка массива (пустой)
        Assertions.assertTrue(stringList5.isEmpty());

    }

    @Test
    void shouldClearCorrect() {
//                Подготовка
        String s11Test = stringList.add("String 01");
        String s12Test = stringList.add("String 02");
        String s13Test = stringList.add("String 03");

        //        Выполнение
        stringList.clear();

        //        Тест: проверка
        Assertions.assertTrue(stringList.isEmpty());

    }

    @Test
    void shouldToArrayCorrect() {
//                Подготовка
        String s11Test = stringList.add("String 01");
        String s12Test = stringList.add("String 02");
        String s13Test = stringList.add("String 03");

        //        Выполнение
        String[] newStringArray = stringList.toArray();

        //        Тест: проверка
        Assertions.assertEquals(stringList.get(0), newStringArray[0]);
        Assertions.assertEquals(stringList.get(1), newStringArray[1]);
        Assertions.assertEquals(stringList.get(2), newStringArray[2]);

        //        Тест: проверка массива (пустой)
        Assertions.assertThrows(InvalidStringListException.class, () -> stringList5.toArray());

    }

}
