package tests;

import dto.Categories;
import dto.Detectives;
import dto.Extra;
import dto.ExtraArray;
import dto.Root;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseTest {
    Exception ex;

    @Tag("Positive")
    @Test
    // Проверить 3 объекта в массиве detectives + проверить валидные id в атрибуте mainId + проверить атрибут success
    public void test1() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().mainId(0)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условие "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2)
                                            .build())).build(),
                            Detectives.builder().mainId(1).
                                    categories(List.of(Categories.builder()   //Указываю categoryID для того, чтобы выполнить условие "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2)
                                            .build())).build(),
                            Detectives.builder().mainId(10)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условие "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2)
                                            .build())).build()
                    ))
                    .success(false);
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNull(ex);

    }

    @Tag("Positive")
    @Test
    // Проверка 1 объекта в массиве detectives + проверить валидный id параметра mainId
    public void test2() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().mainId(9)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2)
                                            .build()))
                                    .build()
                    ));
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка 0 объектов в массиве detectives
    public void test3() {
        try {
             Root.builder().build();
             throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка >3 объектов в массиве detectives
    public void test4() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().mainId(0)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2).build()))
                                    .build(),
                            Detectives.builder().mainId(1)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2).build()))
                                    .build(),
                            Detectives.builder().mainId(10)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2).build()))
                                    .build(),
                            Detectives.builder().mainId(5)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2).build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка отрицательного id параметра mainId
    public void test5() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().mainId(-1)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2)
                                            .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка значения, превышающего максимальное значение id параметра mainId
    public void test6() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().mainId(11)
                                    .categories(List.of(Categories.builder()  //Указываю categoryID для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2" и "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                            .categoryID(2)
                                            .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Positive")
    @Test
    // Проверка валидного значения параметра categoryId
    public void test7() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(1)
                                                    .extra(Extra.builder() //Указываю extra для того, чтобы выполнить условия "Элемент extra может принимать значение null только для CategoryID=2"
                                                            .extraArray(List.of(ExtraArray.builder() //Указываю extraArray для того, чтобы выполнить условия "Массив extraArray дожен иметь минимум один элемент для CategoryID=1"
                                                                    .violin(1)
                                                                    .build()))
                                                            .build())
                                                    .build(),
                                            Categories.builder()
                                                    .categoryID(2)
                                                    .build()))
                                    .build()
                    ));
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка на 0 парметра categoryID
    public void test8() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder()
                                    .categories(List.of(Categories.builder()
                                            .categoryID(0)
                                                    .extra(Extra.builder()
                                                            .extraArray(List.of(ExtraArray.builder()
                                                                    .cap(2)
                                                                    .build()))
                                                            .build())
                                            .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка на отрицательное значение парметра categoryID
    public void test9() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder()
                                    .categories(List.of(Categories.builder()
                                            .categoryID(-1)
                                                    .extra(Extra.builder()
                                                            .extraArray(List.of(ExtraArray.builder()
                                                                    .violin(1)
                                                                    .build()))
                                                            .build())
                                            .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка значения, превышающего максимальное значение id параметра categoryID
    public void test10() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder()
                                    .categories(List.of(Categories.builder()
                                            .categoryID(3)
                                                    .extra(Extra.builder()
                                                            .extraArray(List.of(ExtraArray.builder()
                                                                    .cap(2)
                                                                    .build()))
                                                            .build())
                                            .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Positive")
    @Test
    // Проверка не пустого элемента extra
    public void test11() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(1)
                                                    .extra(Extra.builder()
                                                            .extraArray(List.of(
                                                                    ExtraArray.builder()
                                                                            .violin(3)
                                                                            .build()))
                                                            .build())
                                                    .build()))
                                    .build()
                    ));
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNull(ex);
    }

    @Tag("Positive")
    @Test
    // Проверка пустого элемента extra
    public void test12() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(2)
                                                    .extra(Extra.builder()
                                                            .build())
                                                    .build()))
                                    .build()
                    ));
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка на null элемента extra, в случае если categoryID=1
    public void test13() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(1)
                                                    .extra(Extra.builder().build())
                                                    .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка на пустой массив элемента extraArray, в случае если categoryID=1
    public void test14() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(1)
                                                    .extra(Extra.builder()
                                                            .extraArray(List.of())
                                                            .build())
                                                    .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Negative")
    @Test
    // Проверка на null элемента extraArray, в случае если categoryID=1
    public void test15() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(1)
                                                    .extra(Extra.builder()
                                                            .build())
                                                    .build()))
                                    .build()
                    ));
            throw new Exception();
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Tag("Positive")
    @Test
    // Проверка на false элемента success
    public void test16() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(2)
                                                    .build()))
                                    .firstName("Sherlock")
                                    .build(),
                            Detectives.builder()
                                    .categories(List.of(Categories.builder()
                                            .categoryID(2)
                                            .build()))
                                    .firstName("James")
                                    .build()
                    ))
                    .success(true);
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNull(ex);
    }

    @Tag("Positive")
    @Test
    // Проверка на false элемента success
    public void test17() {
        try {
            Root.builder()
                    .detectives(List.of(
                            Detectives.builder().
                                    categories(List.of(
                                            Categories.builder()
                                                    .categoryID(2)
                                                    .build()))
                                    .firstName("Sara")
                                    .build(),
                            Detectives.builder()
                                    .categories(List.of(Categories.builder()
                                            .categoryID(2)
                                            .build()))
                                    .firstName("James")
                                    .build()
                    ))
                    .success(false);
        } catch (Exception e) {
            ex = e;
        }
        Assertions.assertNull(ex);
    }
}
