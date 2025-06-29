CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_dest_account   IN NUMBER,
    p_amount         IN NUMBER
)
IS
    
    insufficient_funds EXCEPTION;

    v_balance NUMBER;
BEGIN
  
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_source_account
    FOR UPDATE;

   
    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Debit source account
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_source_account;

    -- Credit destination account
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_dest_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('✅ Transfer successful: ' || p_amount || ' transferred from Account ' || p_source_account || ' to Account ' || p_dest_account);

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ransfer failed: Insufficient funds in source account (Account ' || p_source_account || ').');
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: One of the accounts does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/
