Feature: User

  Scenario Outline: fetch all
    Given getAll
    And getById

    Examples:
      | id | email | full_name | password |
      | 1 | atomsah00@gmail.com | atom sah | $2a$10$T9MIjapJpdwriQYM/caVB.GJPfMqsevLuAy24eEJLXwRQ2loj76O.$2a$10$DJC.USOP7s16mIYKlDymX.etyvnqf481zR8jQgWjMtNI.aUq9Tbr6 |
  Scenario Outline: for post
    Given post data
    And verify
    Then finally

    Examples:
      | id | email | full_name | password |
      | 1 | atomsah00@gmail.com | atom sah | $2a$10$T9MIjapJpdwriQYM/caVB.GJPfMqsevLuAy24eEJLXwRQ2loj76O.$2a$10$DJC.USOP7s16mIYKlDymX.etyvnqf481zR8jQgWjMtNI.aUq9Tbr6 |