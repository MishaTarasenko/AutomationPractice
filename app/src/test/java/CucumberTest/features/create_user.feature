Feature: User Creation

  Scenario: Creating a user with invalid email
    Given a user with email "invalid-email" and age "25"
    When I try to create the user
    Then the user creation should fail with message "Invalid email address"

  Scenario: Creating a user with age less than 18
    Given a user with email "validemail@example.com" and age "17"
    When I try to create the user
    Then the user creation should fail with message "User must be at least 18 years old"

  Scenario: Creating a user with valid email and age
    Given a user with email "valid.email@example.com" and age "25"
    When I try to create the user
    Then the user creation should succeed