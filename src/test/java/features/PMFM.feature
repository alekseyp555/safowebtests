Feature: Тест для тестирования модуля "Проверочные массивы финансового мониторинга"
Залогиненный пользователь должен видеть список ФИО
При клике на Террористы/Организация, Территория террористической активности, ФАТФ, Оффшоррные зоны, Виды деятельности, Банковские счета отображаются данные

@accept
@deb

#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля Проверочные массивы финансового мониторинга
    Given Выбрать ПМФМ
    When Клик ФИО
    Then Выбрать Территория террористической активности
    Then Клик Турция
    Then Клик ФАТФ
    Then Клик Корея, КНДР
    Then Клик Оффшорные зоны
    Then Клик Белиз
    Then Клик Виды деятельности
    Then Клик Деятельность, связанная со скупкой
    Then Клик Банковские счета
    Then Клик счет