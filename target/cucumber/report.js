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
});