Feature: Тест для тестирования модуля "Рабочий календарь"
При клике на календарь отображается информация о календаре

@accept
@spr
#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля Рабочий календарь
    Given Выбрать Рабочий календарь
    When Клик на год календаря
    And Выбрать 2016 год
    Then Отобразился 2016 год
