Feature: Upload Invoice

  Background: Login to the Application


  Scenario Outline: User can reject an Invoice via ‘Actions’ button in case All tab is selected and
  Invoice Status is Review

    Given Login to the Application
    Then Navigate to invoice page
    Then Search for invoice with "<Name>" "Review"
    And Click on Action button to an invoice has "<Name>"
    And Click on reject option
    Then Enter "<Rejection_Reason>" in the rejection reason field
    And Click on reject invoice button
    Then Validate toast message will appear to the user "Invoice rejected successfully"
    And  Invoice record should disappear from the All tab under the "<Name>" "Review"
    Then Number besides the All tab & Number in the Footer & Count of rows in the All tab & Total count fetched from API should be matched
    Then Navigate to archive page
    And Invoice "<Name>" record should appear in the archive page under rejected tab in the First Row and Status should be "Rejected"
    Then Number besides the Rejected tab and the Number in the Footer and number of Records should be matched
    And Submitted by column should contains Uploader First Name + Last Name "<Name>"
    Then  The entered "<Rejection_Reason>" should be appearing  "<Name>" "Rejected"

    Examples:
      | Name           | Rejection_Reason |
      | Shehab Invoice | Invalid Info     |


