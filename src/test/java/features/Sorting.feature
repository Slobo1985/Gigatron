Feature: Sorting

  #Sorting options: scope, rastuci, opadajuci, rejting, naziv
  Scenario: Sort by "<sortingMethod>"

    Given I am on products page
    When I click sort by "<sortingMethod>"
    Then I should see product sorted "<sortingMethod>"

    Examples:
      | sortingMethod |
      | rastuci       |
      | opadajuci     |
      | naziv         |
#      | rejting   |
#      | scope     |