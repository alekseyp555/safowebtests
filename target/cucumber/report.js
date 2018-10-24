$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/SmokeModulBusinessProd.feature");
formatter.feature({
  "name": "Тест для тестирования модуля \"Бизнес продукты\"",
  "description": "Залогиненный пользователь должен видеть бизнес продукты\nПри клике на бизнес продут должны загружаться: \"Описание продукта, схема обслуживания, сроки, тарифный план,лимитная политика, верификация",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Проверка модуля бизнес продукты",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@accept"
    },
    {
      "name": "@debug"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "клик на кнопку Пуск",
  "keyword": "Given "
});
formatter.match({
  "location": "SmokeModulBusinessProdTests.клик_на_кнопку_Пуск()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "выбрать справочники",
  "keyword": "And "
});
formatter.match({
  "location": "SmokeModulBusinessProdTests.выбрать_справочники()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "выбрать Бизнес-продукты",
  "keyword": "When "
});
formatter.match({
  "location": "SmokeModulBusinessProdTests.выбрать_Бизнес_продукты()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "страницы с бизнес продуктами загрузилась",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeModulBusinessProdTests.страницы_с_бизнес_продуктами_загрузилась()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "выбрать Агентский факторинг без права регресса",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeModulBusinessProdTests.выбрать()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "загрузились страницы: описание продукта, схема обслуживания, сроки, тарифный план, лимитная политика, верификация",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeModulBusinessProdTests.загрузились_страницы_описание_продукта_схема_обслуживания_сроки_тарифный_план_лимитная_политика_верификация()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});