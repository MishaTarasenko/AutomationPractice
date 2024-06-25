Feature: User Creation

  Scenario Outline: Creating a user
    Given a user with email "<email>" and age "<age>"
    When I try to create the user
    Then the user creation should <result> with message "<message>"

    Examples:
      | email                  | age | result   | message                              |
      | invalid-email          | 25  | fail     | Invalid email address                |
      | validemail@example.com | 17  | fail     | User must be at least 18 years old   |
      | validemail@example.com | 25  | succeed  |                                      |