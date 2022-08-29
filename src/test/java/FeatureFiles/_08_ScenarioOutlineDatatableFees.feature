# Daha once Create a Fee, delete Fee Seneryosunu asagidaki 5 farkli degerler icin calistiriniz



Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully


  Scenario Outline: Create a Fee, delete Fee
    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | fees          |

    And Click on the element in the Dialog
      | addButton  |

    And User sending the keys in Dialog Content
      | nameInput       | <name>    |
      | codeInput       | <code>    |
      | integrationCode | <intCode> |
      | priority        | <priority>    |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | <name>  |

    And Success message should be displayed


    Examples:
      | name               | code   | intCode  |  priority |
      | Funda  Akhan       | 5      | 555      | 250       |
      | Burcu  Turkmen     | 6      | 666      | 150       |
      | Cagri  Temel       | 7      | 777      | 350       |
      | Ugur Inanmaz       | 8      | 888      | 450       |
