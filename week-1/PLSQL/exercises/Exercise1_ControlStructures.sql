-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% interest discount to loans for customers above 60
BEGIN
   FOR rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
       IF TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
           UPDATE Loans
           SET InterestRate = InterestRate - (InterestRate * 0.01)
           WHERE CustomerID = rec.CustomerID;

           DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || rec.CustomerID);
       END IF;
   END LOOP;
   COMMIT;
END;
/

-- Scenario 2: Mark customers with Balance > 10000 as VIP
BEGIN
   FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
       IF rec.Balance > 10000 THEN
           UPDATE Customers
           SET IsVIP = 'TRUE'
           WHERE CustomerID = rec.CustomerID;

           DBMS_OUTPUT.PUT_LINE('CustomerID ' || rec.CustomerID || ' marked VIP');
       END IF;
   END LOOP;
   COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due in the next 30 days
BEGIN
   FOR rec IN (
       SELECT c.Name, l.EndDate
       FROM Customers c
       JOIN Loans l ON c.CustomerID = l.CustomerID
       WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
   ) LOOP
       DBMS_OUTPUT.PUT_LINE('Reminder to ' || rec.Name || ': Loan due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
   END LOOP;
END;
/