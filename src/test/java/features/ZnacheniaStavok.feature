Feature: Тест для тестирования модуля "Значения ставок"
Залогиненный пользователь должен видеть список типов ставок
При клике на ставку отображается информация

@accept
@spr
#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля Значения ставок
    Given Выбрать Значения ставок
    When Клик на прогнозные курсы валют для лимитов
    Then Загрузилась информация про ставки
