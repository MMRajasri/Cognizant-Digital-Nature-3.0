--Scenario 1

CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_from_account_id NUMBER, p_to_account_id NUMBER, p_amount NUMBER) IS
    v_from_balance NUMBER;
BEGIN
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id;
    
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    ELSE
        UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account_id;
        UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account_id;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END SafeTransferFunds;
/


-- Scenario 2

CREATE OR REPLACE PROCEDURE UpdateSalary(p_employee_id NUMBER, p_percentage NUMBER) IS
BEGIN
    UPDATE Employees SET Salary = Salary + (Salary * p_percentage / 100) WHERE EmployeeID = p_employee_id;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/


--Scenario 3

CREATE OR REPLACE PROCEDURE AddNewCustomer(p_customer_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) 
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/
