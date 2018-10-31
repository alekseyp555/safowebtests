$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/ContrAgents.feature");
formatter.feature({
  "name": "Тест для тестирования модуля \"Контрагенты\"",
  "description": "Залогиненный пользователь должен видеть список контрагентов\nПри клике на контрагента должны отображаться Общие сведения, Дополнительно, Лимиты, Договора, Банковские реквизиты",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Проверка модуля контрагенты",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@accept"
    },
    {
      "name": "@deb"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Выбрать Контрагенты",
  "keyword": "Given "
});
formatter.match({
  "location": "ContrAgentsTests.выбрать_Контрагенты()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Клик Применить",
  "keyword": "When "
});
formatter.match({
  "location": "ContrAgentsTests.клик_Применить()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Список контрагентов появился",
  "keyword": "Then "
});
formatter.match({
  "location": "ContrAgentsTests.список_контрагентов_появился()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Выбрать контрагента",
  "keyword": "Then "
});
formatter.match({
  "location": "ContrAgentsTests.выбрать_контрагента()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Загрузились свойства контрагента",
  "keyword": "Then "
});
formatter.match({
  "location": "ContrAgentsTests.загрузились_свойства_контрагента()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Клик Общие сведения, Дополнительно, Лимиты, Договора, Банковские реквизиты контрагента",
  "keyword": "Then "
});
formatter.match({
  "location": "ContrAgentsTests.клик_Общие_сведения_Дополнительно_Лимиты_Договора_Банковские_реквизиты_контрагента()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});