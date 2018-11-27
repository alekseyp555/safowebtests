Feature: Тест для тестирования модуля "BPM"
  Залогиненный пользователь должен видеть BPM
  После выбора BPM должны отображаться: все заявки, заявки доступные к изменениям, заявки на исполнении, отчеты, настройки, руководство пользователя

  @accept
  @deb
  @operations

#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля BPM
    Given Выбрать модуль BPM
    When Выбрать все заявки
    Then Загрузились все заявки

