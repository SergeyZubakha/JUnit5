package ru.alarsec;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class FindEquipmentTest {

    @CsvSource({
            "молния-24, Световой оповещатель Молния-24 С",
            "гром-12,   Комбинированный оповещатель Гром-12 К исп.3"
    })
    @ParameterizedTest(name = "При вводе в поиск {0} на старнице присутствует текст {1}")
    @DisplayName("Проверка поисковой выдачи")
    void findEquipment(String value, String text) {

        open("https://alarsec.ru/");
        $("#s").setValue(value).pressEnter();
        $(".ast-row").shouldHave(Condition.text(text));
        sleep(10000);

    }

    @CsvFileSource(resources = "/FindEquipmentTest.csv")
    @ParameterizedTest(name = "При вводе в поиск {0} на старнице присутствует текст {1}")
    @DisplayName("Проверка поисковой выдачи")
    void findEquipmentWithFileSource(String value, String text) {

        open("https://alarsec.ru/");
        $("#s").setValue(value).pressEnter();
        $(".ast-row").shouldHave(Condition.text(text));
        sleep(10000);

    }

    @ValueSource(strings = {"молния-24", "гром-12"})
    @ParameterizedTest(name = "При вводе в поиск {0} на странице присутствуют результаты поиска")
    @DisplayName("Проверка поисковой выдачи")
    void findEquipmentShouldNotBeEmpty(String value) {

        open("https://alarsec.ru/");
        $("#s").setValue(value).pressEnter();
        $$(".ast-row").shouldHave(CollectionCondition.sizeGreaterThan(0));
        sleep(10000);

    }


}
