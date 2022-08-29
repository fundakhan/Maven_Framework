# Employee menusu icin Create - Exist - Delete bolumleri olan Seneryoyu yaziniz
# daha sonra ayni seneryoyu 5 farkli degerler icin calistiriniz


Feature: Employee Functionality

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully

    Scenario: Create and Exist and Delete Employee
      And Click on the element in the left Nav
        | humanResources |
        | employees |

      And Click on the element in the Dialog
        | addButton |

      And User sending the keys in Form Content
       | firstname | Funda |
       | lastName  | Akhan |
       | employeeId | 55522241 |

      And Click on the element in the Form Content
        | gender  |
        | employeeType |
        | qualification |

      And Click on the element in the Dialog
        | saveButton |

      Then Success message should be displayed

#      And Click on the element in the left Nav
#        | humanResources |
#        | employees |

