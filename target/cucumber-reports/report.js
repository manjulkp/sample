$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/Login.feature");
formatter.feature({
  "name": "Login feature",
  "description": "  I want to verify login ",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Validate user flow of  onboarding screen",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am in Welcome screen",
  "keyword": "Given "
});
formatter.match({
  "location": "Login_Step.i_am_in_Welcome_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});