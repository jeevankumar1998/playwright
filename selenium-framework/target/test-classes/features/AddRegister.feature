Feature: VMS POS Register 
  
  @smoke
  Scenario Outline: Login and add POS register.
    Given User enters username "<username>" and clicks Next
    And User enters password "<password>" and clicks Login
    When User adds a new POS register on site with bridge  and store  and register
    Then New register should be added successfully

Examples:
  | username   | password |
  | aut.distributor.prod+r1_e4@gmail.com  | enduser_4_prod@een  | 
 