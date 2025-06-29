SET SERVEROUTPUT ON;
BEGIN
  FOR due_loan IN (
    SELECT l.LoanID, l.EndDate, c.Name, c.CustomerID
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: LoanID ' || due_loan.LoanID || 
      ' for customer ' || due_loan.Name || 
      ' (CustomerID: ' || due_loan.CustomerID || 
      ') is due on ' || TO_CHAR(due_loan.EndDate, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/
