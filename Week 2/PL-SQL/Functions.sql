-- Scenario 1

CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END CalculateAge;
/


-- Scenario 2

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_loan_amount NUMBER, p_interest_rate NUMBER, p_duration_years NUMBER) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_monthly_installment NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 1200;
    v_monthly_installment := p_loan_amount * v_monthly_rate / (1 - POWER(1 + v_monthly_rate, -p_duration_years * 12));
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/


-- Scenario 4

CREATE OR REPLACE FUNCTION HasSufficientBalance(p_account_id NUMBER, p_amount NUMBER) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    RETURN v_balance >= p_amount;
END HasSufficientBalance;
/
