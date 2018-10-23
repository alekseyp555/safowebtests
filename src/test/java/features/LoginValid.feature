Feature: Login feature File

  Scenario: Login scenario for SAFO Web
    Given navigate to SAFO web page
    When user logged using username as "ABPak@sbfc.ru" as password "Makaka123"
    Then title SAFO modules page should be displayed