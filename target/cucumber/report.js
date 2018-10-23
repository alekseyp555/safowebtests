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
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"(.//*[normalize-space(text()) and normalize-space(.)\u003d\u0027Описание продукта\u0027])[1]/following::span[2]\"}\n  (Session info: chrome\u003d69.0.3497.100)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.16299 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027RAND-54\u0027, ip: \u0027192.168.61.55\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.42.591088 (7b2b2dca23cca0..., userDataDir: C:\\Users\\Pak-AB\\AppData\\Loc...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:57781}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 69.0.3497.100, webStorageEnabled: true}\nSession ID: 72b4ff5be52aa71772eb144f684e2c51\n*** Element info: {Using\u003dxpath, value\u003d(.//*[normalize-space(text()) and normalize-space(.)\u003d\u0027Описание продукта\u0027])[1]/following::span[2]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\r\n\tat stepDef.SmokeModulBusinessProdTests.загрузились_страницы_описание_продукта_схема_обслуживания_сроки_тарифный_план_лимитная_политика_верификация(SmokeModulBusinessProdTests.java:56)\r\n\tat ✽.загрузились страницы: описание продукта, схема обслуживания, сроки, тарифный план, лимитная политика, верификация(src/test/java/features/SmokeModulBusinessProd.feature:16)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});