--Scenario 1

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR rec IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') 
    LOOP
        UPDATE Accounts 
        SET Balance = Balance + (Balance * 0.01), LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;
    END LOOP;
END ProcessMonthlyInterest;
/


--Scenario 2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_department VARCHAR2, p_bonus_percentage NUMBER) IS
BEGIN
    UPDATE Employees 
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;
END UpdateEmployeeBonus;
/


-- Scenario 3

CREATE OR REPLACE PROCEDURE TransferFunds(p_from_account_id NUMBER, p_to_account_id NUMBER, p_amount NUMBER) IS
    v_from_balance NUMBER;
BEGIN
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id;
    
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20003, 'Insufficient funds in the source account.');
    ELSE
        UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account_id;
        UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account_id;
    END IF;
END TransferFunds;
/
