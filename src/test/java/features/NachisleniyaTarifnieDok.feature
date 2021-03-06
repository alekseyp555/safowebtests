Feature: Тест для тестирования модуля "Начисления и тарифные документы"
Залогиненный пользователь должен видеть список тарифныз документов, излишне начисленные комиссии, начисления
При выборе диапазона дат с 01.09 по текущую дату должны отображатсья тарифные документы за этот период
При клике на излишне начисленные комиссии и выборе компании должна отображаться детализация

@accept
@spr
@nachisleniya

#Background:
#Пользователь должен быть залогинен в системе
#language: ru

  Scenario: Проверка модуля Начисления и тарифные документы
    Given Выбрать Начисления и тарифные документы
    When Выбрали дату 01.09.2018
    And Клик Применить начисления
    Then Список документов загрузился
    Then Выбрать счет
    Then Загрузились комиссии за обработку документов
    Then Клик Излишне начисленные комиссии
    Then Выбрать компанию
    Then Детализация загрузилась
    Then Клик на Начисления