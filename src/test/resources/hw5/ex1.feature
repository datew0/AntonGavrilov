Feature: User can interact with inputs on Different Elements page
  @controls
  Scenario: User can set checkboxes, radios and select dropdown
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then Browser title is "Home Page"
    And Name is "ROMAN IOVLEV"
    When I click on "Service" button in Header
    And I click on "Different elements" button in Service dropdown
    And I select elements on Different Elements page
      | Water |
      | Wind |
    And I select materials on Different Elements page
      | Selen |
    And I select "Yellow" in dropdown menu on Different Elements page
    Then I can see log entries
      | Yellow |
      | Selen  |
      | Wind   |
      | Water  |
