Feature: Тест для тестирования модуля "Бизнес продукты"
Залогиненный пользователь должен видеть бизнес продукты
При клике на бизнес продут должны загружаться: "Описание продукта, схема обслуживания, сроки, тарифный план,лимитная политика, верификация

@accept
@debug

#Background:
#Пользователь должен быть залогинен в системе

  Scenario: Проверка модуля бизнес продукты
   Given клик на кнопку Пуск
   And выбрать справочники
   When выбрать Бизнес-продукты
   Then страницы с бизнес продуктами загрузилась
   Then выбрать Агентский факторинг без права регресса
   Then загрузились страницы: описание продукта, схема обслуживания, сроки, тарифный план, лимитная политика, верификация

