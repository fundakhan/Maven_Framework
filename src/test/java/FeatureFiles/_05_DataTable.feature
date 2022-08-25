Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully


    Scenario: Create Country
      And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | countries  |

      And Click on the element in the Dialog
      | addButton |

      And User sending the keys in Dialog Content
      | nameInput | fundaCountry5 |
      | codeInput | f12345        |

      And Click on the element in the Dialog
      | saveButton |

      And Success message should be displayed

      And User delete item from Dialog
       | fundaCountry5  |

      And Success message should be displayed


   Scenario: Create a Nationality
     And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | nationalities |

     And Click on the element in the Dialog
      | addButton  |

     And User sending the keys in Dialog Content
       | nameInput | fundaNat1 |


     And Click on the element in the Dialog
       | saveButton |

     And Success message should be displayed

     And User delete item from Dialog
       | fundaNat1  |

     And Success message should be displayed

# Seneryo Outline da verilen degerler icin tum seneryo her satir kadar tekrar calistiriliyordu
# DataTable da ise , sadece ilgili step icin toplu veri gonderme imkani olusuyor
   Scenario: Create a Fee, delete Fee
     And Click on the element in the left Nav
       | setupOne      |
       | parameters    |
       | fees          |

     And Click on the element in the Dialog
       | addButton  |

     And User sending the keys in Dialog Content
       | nameInput       | fundaCountry11 |
       | codeInput       | f12346         |
       | integrationCode | f123           |
       | priority        | 250            |

     And Click on the element in the Dialog
       | saveButton |

     And Success message should be displayed

     And User delete item from Dialog
       | fundaCountry11  |

     And Success message should be displayed



