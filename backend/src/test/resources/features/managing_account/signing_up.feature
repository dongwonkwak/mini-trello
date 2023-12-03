Feature: Signing up to the Mini Trello

  Scenario: Registering online for a new Mini Trello account
    Given Jane is not a Mini Trello Member
    When she registers for a new account
    Then she became a Mini Trello member