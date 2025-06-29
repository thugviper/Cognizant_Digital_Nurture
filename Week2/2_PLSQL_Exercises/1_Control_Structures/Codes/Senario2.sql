SET SERVEROUTPUT ON;
BEGIN
  FOR cust IN (
    SELECT CustomerID
    FROM Customers
    WHERE Balance > 10000 AND IsVIP = 'FALSE'
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'TRUE'
    WHERE CustomerID = cust.CustomerID;

    DBMS_OUTPUT.PUT_LINE('CustomerID ' || cust.CustomerID || ' marked as VIP.');
  END LOOP;

  COMMIT;
END;
/
