Feature: Тест для тестирования модуля "Мониторинг Риски"
  Залогиненный пользователь должен видеть модуль Мониторинг Риски
  После выбора Монииторинг Риски отображается Активные задачи(новые, в работе, исполнено), реестр, мониторинг ПА

  @accept
  @operations


#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля Мониторинг Риски
    Given Выбрать модуль Мониторинг Риски
    When Выбрать в работе
    Then Задачи в работе загрузились
    Then Выбрать исполнено
    Then Выбрать реестр
    Then Выбрать мониторинг ПА