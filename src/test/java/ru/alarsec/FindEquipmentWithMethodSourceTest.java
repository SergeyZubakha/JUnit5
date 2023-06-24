package ru.alarsec;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindEquipmentWithMethodSourceTest {

    static Stream<Arguments> categoryShouldHaveCards() {

        return Stream.of(
                Arguments.of("Источники питания", List.of("Бесперебойные с выходным напряжением 12 В", "Бесперебойные с выходным напряжением 24 В", "Бесперебойные с выходным напряжением 48 В",
                        "Бесперебойные с выходным напряжением 220 В", "Бесперебойные с выходным напряжением 380 В", "Источники питания для котлов", "Резервные с выходным напряжением 12 В", "Резервные с выходным напряжением 24 В",
                        "Аккумуляторы и термостаты", "Батарейки", "Стабилизированные (небесперебойные)", "Специализированные", "Инверторы", "Стабилизаторы напряжения", "Дополнительное оборудование", "Дополнительное оборудование для ИБП 220 В", "Дополнительное оборудование для ИБП 380 В")),
                Arguments.of("Средства пожаротушения", List.of("Огнетушители", "Модули порошковые", "Модули пожаротушения тонкораспыленной водой",
                        "Модули газопорошкового пожаротушения", "Беспроводная система пожаротушения", "Изделия коммутационные", "Вентили пожарные", "Стволы пожарные",
                        "Щиты пожарные", "Шкафы пожарные", "Сигнально-осветительные приборы", "Журналы, знаки и плакаты пожарной безопасности и охраны труда", "Средства защиты органов дыхания",
                        "Пожаротушение для 19\" шкафов", "Оборудование для газового пожаротушения", "Оборудование для аэрозольного пожаротушения", "Системы пожаротушения кухонного оборудования",
                        "Установки распыления", "Типовые решения «Пожаротушение»"))
        );

    }

    @ParameterizedTest
    @MethodSource
    void categoryShouldHaveCards(String category, List<String> equipment) {

        open("https://www.tinko.ru/");
        $("#blockCatalogMenu").$((byText(category))).click();
        $$(".sidebar-nav-list li").filter(visible).shouldHave(CollectionCondition.texts(equipment));

    }
}

