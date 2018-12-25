Feature: Тест для тестирования модуля "BPM"
  Залогиненный пользователь должен видеть BPM
  После выбора BPM должны отображаться: все заявки, заявки доступные к изменениям, заявки на исполнении, отчеты, настройки, руководство пользователя

  @accept
  @operations
@deb

#Background:
#Пользователь должен быть залогинен в системе
#Пользователь должен быть с правами BPM

  Scenario: Проверка модуля BPM
    Given Выбрать модуль BPM
    When Выбрать все заявки
    Then Загрузились все заявки

