# 1- Sinav girisi yap
# 2- silme islemi yap


Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully

  Scenario: Create and Delete Exams
    And Click on the element in the left Nav
      | entranceExamsOne   |
      | setupTwo |
      | entranceExamsTwo  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput | Funda6 |

    And Click on the element in the Form Content
      | academicPeriod |
      | academicPeriod1  |
      | gradeLevel  |
      | gradeLevel2  |


    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in the left Nav
      | entranceExamsOne   |
      | setupTwo |
      | entranceExamsTwo  |


    And User delete item from Dialog
      | funda6 |

    Then Success message should be displayed

