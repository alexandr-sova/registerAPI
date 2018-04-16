Feature: This test are created for registration and authorisation testing.

  Scenario Outline: Testing Registration
    Given EMAIL <email>
    And PWD <pwd>
    And PHONE <phone>
    And BIRTHDATE <birthdate>
    And DESCRIPTION <description>
    And COUNTRY <country>
    And CITY <city>
    And STATE <state>
    And ZIP <zip>
    And STREET <street>
    When we are requesting registration
    Then RESULT should be <result>
    And DETAILS should be <details>

    Examples:
    | email    | pwd   | phone       | birthdate               | description| country| city    | state | zip    | street     | result| details|
    | a@wq.com | 111wqa| +37123232323| 1988-06-25T00:00:00.000Z| Rock'n'Roll| US     | New York| Gorgia| LV-1001| Brivibas 10| true  | none   |
    |          | 111aaa| +37123444333| 1988-06-25T00:00:00.000Z| Best way   | UK     | London  | LD    | BOX-12 | Baker 12   | false | Field email missed|
    | s@e.com  |       | +37123444333| 1988-04-16T00:00:00.000Z| Best way   | UK     | London  | LD    | BOX-12 | Baker 12   | false | Field pwd missed|
    | av@wo.com| 111wqa| +37123232323| 1998-06-25T00:00:00.000Z| Rock'n'Roll| US     | New York| Gorgia| LV-1001| Brivibas 10| false | Field birthDate bad format|


  Scenario Outline: Testing Authorisation
    Given LOGIN <login>
    And PASSWORD <pwd>
    When we are requesting authorisation
    Then RESULT should be <result>
    And DETAILS should be <details>

    Examples:
    | login    | pwd  | result | details           |
    | a@b.com  |111aaa| true   |AAABBBCCCDDDEEE==  |
    | a@we.com |111aaa| false  |Failed to authorize|
    | a@b.com  |111222| false  |Failed to authorize|
    | a@wq.com |111333| false  |Failed to authorize|



