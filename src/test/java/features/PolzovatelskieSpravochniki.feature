Feature: Тест для тестирования модуля "Пользовательские справочники"
Залогиненный пользователь должен видеть список пользовательских справочников
При клике на справочник отображается информация

@accept
@spr
#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля Пользовательские справочники
    Given Выбрать Пользовательские справочники
    When Клик Справочник банков
    Then Загрузилась информация про банки
