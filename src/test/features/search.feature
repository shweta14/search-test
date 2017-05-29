Feature: Springer Nature - Search Tests for GUI


  Background:
    Given I go to Springer website
    And I visit Springer Link page


  Scenario Outline: Happy path search tests, simple search texts with preview mode enabled
    When I enter the search term <SEARCH_TERM>
    Then I see atleast <EXPECTED_NUMBER_OF_RESULTS> search results
    And I see below link <RESULT> in search results

    Examples:
      | SEARCH_TERM                      | EXPECTED_NUMBER_OF_RESULTS | RESULT                                                                                       |
      |                                  | 10781671                   | Blind Identification of Output-Only Systems and Structural Damage via Sparse Representations |
      | molecular neurobiology           | 46161                      | Molecular Neurobiology                                                                       |
      | molecular AND neurobiology       | 46161                      | Molecular Neurobiology                                                                       |
      | molecular                        | 1746641                    | Molecular Spectra and Molecular Structure                                                    |
      | neurobiology                     | 95339                      | Neurobiology                                                                                 |
      | neurobiology*                    | 95339                      | Neurobiology                                                                                 |
      | neur?biology                     | 95339                      | Neurobiology of Asperger Syndrome                                                                                 |
      | neurobiology  or   molecular     | 1797160                    | Comparative Molecular Neurobiology                                                           |
      | Identification near structural   | 17703                      | Identification Methods for Structural Health Monitoring                                      |
      | Identification near/1 structural | 3664                       | Identification and structural elucidation of ozonation transformation products of estrone    |
      | random1                          | 0                          |                                                                                              |



