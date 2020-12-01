Feature: Something is a Glass

  Background:
    * url standardUrl

  Scenario: Fehlschlag 1 wegen fehlenden Daten
    Given path 'glasses'
    When method GET
    Then status 201

  Scenario: Fehlschlag 2 wegen fehlenden Daten
    Given path 'glasses'
    When method GET
    Then status 200

  Scenario: Erfolgreich
    Given path 'glasses'
    When method GET
    Then status 200

  Scenario: Fehlschlag wegen fehlenden Daten
    Given path 'glasses'
    When method POST
    Then status 400

  Scenario: Erfolgreich
    Given path 'glasses'
    When method POST
    Then status 201

  Scenario: Fehlschlag wegen fehlenden Daten
    Given path 'glasses'
    When method PUT
    Then status 400

  Scenario: Erfolgreich
    Given path 'glasses'
    When method PUT
    Then status 200

  Scenario: Fehlschlag wegen fehlenden Daten
    Given path 'glasses'
    When method DELETE
    Then status 400

  Scenario: Erfolgreich
    Given path 'glasses'
    When method DELETE
    Then status 204