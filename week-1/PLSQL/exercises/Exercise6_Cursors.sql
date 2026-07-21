-- Scenario 1: GenerateMonthlyStatements
DECLARE
    CURSOR c_statements IS
        SELECT t.TransactionID, t.Amount, t.TransactionType, a.CustomerID
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE TO_CHAR(t.TransactionDate,'MM-YYYY') = TO_CHAR(SYSDATE,'MM-YYYY');
    v_rec  c_statements%ROWTYPE;
    v_name Customers.Name%TYPE;
BEGIN
    OPEN c_statements;
    LOOP
        FETCH c_statements INTO v_rec;
        EXIT WHEN c_statements%NOTFOUND;
        SELECT Name INTO v_name FROM Customers WHERE CustomerID = v_rec.CustomerID;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' | ' || v_rec.TransactionType || ' | Amount: ' || v_rec.Amount);
    END LOOP;
    CLOSE c_statements;
END;
/

-- Scenario 2: ApplyAnnualFee
DECLARE
    CURSOR c_accounts IS SELECT AccountID FROM Accounts;
    v_account_id Accounts.AccountID%TYPE;
    v_fee        NUMBER := 50;
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id;
        EXIT WHEN c_accounts%NOTFOUND;
        UPDATE Accounts SET Balance = Balance - v_fee WHERE AccountID = v_account_id;
    END LOOP;
    CLOSE c_accounts;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee applied to all accounts.');
END;
/

-- Scenario 3: UpdateLoanInterestRates
DECLARE
    CURSOR c_loans IS SELECT LoanID, InterestRate FROM Loans;
    v_loan_id NUMBER;
    v_rate    NUMBER;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan_id, v_rate;
        EXIT WHEN c_loans%NOTFOUND;
        UPDATE Loans SET InterestRate = v_rate + 0.5 WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE c_loans;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated per new policy.');
END;
/