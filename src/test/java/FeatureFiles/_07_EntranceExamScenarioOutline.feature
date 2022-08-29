# Bir onceki Exam Giris seneryosunu asagidaki degerler icin calistiriniz

# | ExamName           | AcademicPeriodOption     | GradeLevelOption  |
# | Math exam          | academicPeriod1          | gradeLevel2       |
# | IT exam            | academicPeriod1          | gradeLevel1       |
# | Oracle exam        | academicPeriod1          | gradeLevel4       |
# | Soft Skills exam   | academicPeriod1          | gradeLevel5       |
# | Cucumber exam      | academicPeriod1          | gradeLevel3       |



Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully

  Scenario Outline: Create and Delete Exams
    And Click on the element in the left Nav
      | entranceExamsOne   |
      | setupTwo |
      | entranceExamsTwo  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriod |
      | <AcademicPeriodOption>  |
      | gradeLevel  |
      | <GradeLevelOption>  |


    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in the left Nav
      | entranceExamsOne   |
      | setupTwo |
      | entranceExamsTwo  |


    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed


    Examples:
       | ExamName           | AcademicPeriodOption     | GradeLevelOption  |
       | Math exam          | academicPeriod1          | gradeLevel2       |
       | IT exam            | academicPeriod1          | gradeLevel1       |
       | Oracle exam        | academicPeriod1          | gradeLevel4       |
       | Soft Skills exam   | academicPeriod1          | gradeLevel5       |
       | Cucumber exam      | academicPeriod1          | gradeLevel3       |
