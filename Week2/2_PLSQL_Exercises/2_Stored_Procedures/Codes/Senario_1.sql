CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
        WHERE AccountType = 'Savings';
END;
/

EXEC ProcessMonthlyInterest;

-- to check:-
SELECT * FROM Accounts WHERE AccountType = 'Savings';