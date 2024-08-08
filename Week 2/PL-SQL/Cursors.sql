-- Scenario 1

BEGIN
    FOR rec IN (SELECT AccountID, SUM(Amount) AS TotalAmount 
                FROM Transactions 
                WHERE TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE)
                GROUP BY AccountID) 
    LOOP
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || rec.AccountID || ' Total Transactions: ' || rec.TotalAmount);
    END LOOP;
END;
/


-- Scenario 2

BEGIN
    FOR rec IN (SELECT AccountID, Balance FROM Accounts) 
    LOOP
        UPDATE Accounts 
        SET Balance = Balance - 100, LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;
    END LOOP;
END;
/


-- Scneario 3

BEGIN
    FOR rec IN (SELECT LoanID, InterestRate FROM Loans) 
    LOOP
        UPDATE Loans 
        SET InterestRate = InterestRate + 0.5 
        WHERE LoanID = rec.LoanID;
    END LOOP;
END;
/
