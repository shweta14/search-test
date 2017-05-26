Feature: Springer Nature - Search Tests for GUI


  Background:
    Given I go to Springer website
    And I visit Springer Link page


  Scenario Outline: Happy path search tests, simple search texts
    When I enter the search term <SEARCH_TERM>
    Then I see atleast <EXPECTED_NUMBER_OF_RESULTS> search results
    And I see below link <RESULT> with <HREF-LINK> in search results
    Examples:
      | SEARCH_TERM                | EXPECTED_NUMBER_OF_RESULTS | RESULT | HREF-LINK |
      |                            | 10781671                   |        |           |
      | molecular neurobiology     | 46161                      |        |           |
      | molecular                  | 1746641                    |        |           |
      | neurobiology               | 95,339                     |        |           |
      | molecular AND neurobiology | 46161                      |        |           |
      | 555$$$555tfgfdgd           | 0                          |        |           |



