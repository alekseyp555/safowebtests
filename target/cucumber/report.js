$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/NachisleniyaTarifnieDok.feature");
formatter.feature({
  "name": "Тест для тестирования модуля \"Начисления и тарифные документы\"",
  "description": "Залогиненный пользователь должен видеть список тарифныз документов, излишне начисленные комиссии, начисления\nПри выборе диапазона дат с 01.07.по 30.10.2018 должны отображатсья тарифные документы за этот период\nПри клике на излишне начисленные комиссии и выборе компании должна отображаться детализация",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Проверка модуля Начисления и тарифные документы",
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
  "name": "Выбрать Начисления и тарифные документы",
  "keyword": "Given "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.выбрать_Начисления_и_тарифные_документы()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Выбрали дату с 01.09.2018",
  "keyword": "When "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.выбрали_дату_с(LocalDate)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Клик Применить начисления",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Список документов загрузился",
  "keyword": "Then "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.список_документов_загрузился()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Выбрать счет",
  "keyword": "Then "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.выбрать_счет()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Загрузились комиссии за обработку документов",
  "keyword": "Then "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.загрузились_комиссии_за_обработку_документов()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Клик Излишне начисленные комиссии",
  "keyword": "Then "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.клик_Излишне_начисленные_комиссии()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Выбрать компанию",
  "keyword": "Then "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.выбрать_компанию()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Детализация загрузилась",
  "keyword": "Then "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.детализация_загрузилась()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Клик на Начисления",
  "keyword": "Then "
});
formatter.match({
  "location": "NachisleniyaTarifnieDokTests.клик_на_Начисления()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});