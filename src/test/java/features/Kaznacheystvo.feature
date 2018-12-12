Feature: Тест для тестирования модуля "Казначейство"
  Залогиненный пользователь должен видеть модуль Казначейство
  После выбора модуля Казнаачейство должны отображаться источники, транши по заявкам, транши к погашению, платежи, маржа, платежный календарь, справочник банков

  @accept
  @operations
  @deb

#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля Казначейство
    Given Выбрать модуль Казначейство
    When Выбрать источник
    Then Транши отобразились
    Then Выбрать транши по заявкам
    Then Транш по заявкам загрулись
    Then Выбрать платежи
    Then Платежи отобразились
    Then Выбрать маржа
    Then Маржа отобразилась
    Then Выбрать платежный календарь
    Then Выбрать справочник банков
