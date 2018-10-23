$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/LoginValid.feature");
formatter.feature({
  "name": "Login feature File",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login scenario for SAFO Web",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@accept"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "navigate to SAFO web page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginValidTests.navigate_to_SAFO_web_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logged using username as \"ABPak@sbfc.ru\" as password \"Makaka123\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginValidTests.user_logged_using_username_as_as_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "title SAFO modules page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginValidTests.title_SAFO_modules_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/SmokeHierarchyLimit.feature");
formatter.feature({
  "name": "Тест для тестирования модуля \"Иерархия лимитов\"",
  "description": "Залогиненный пользователь должен видеть список лимитов\nПри клике на лимит должны отображаться вкладка общие, дополнительно",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Проверка модуля иерархия лимитов",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@accept"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Выбрать Иерархия лимитов",
  "keyword": "Given "
});
formatter.match({
  "location": "SmokeHierarchyLimitTests.выбрать_Иерархия_лимитов()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "выбрали лимит",
  "keyword": "When "
});
formatter.match({
  "location": "SmokeHierarchyLimitTests.выбрали_лимит()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "загрузились свойства лимитов: Общие, дополнительно",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeHierarchyLimitTests.загрузились_свойства_лимитов_Общие_дополнительно()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/SmokeModulBusinessProd.feature");
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