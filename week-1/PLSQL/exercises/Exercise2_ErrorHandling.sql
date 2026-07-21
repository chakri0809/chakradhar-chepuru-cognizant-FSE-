CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_id      IN NUMBER,
    p_name    IN VARCHAR2,
    p_dob     IN DATE,
    p_balance IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog(ErrorMessage, ErrorDate)
        VALUES ('Duplicate CustomerID: ' || p_id, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ' || p_id || ' already exists');
END;
/