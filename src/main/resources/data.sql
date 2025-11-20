-- Customers
INSERT INTO customer (id, full_name, age, profession, gross_annual_income, address, smoker)
VALUES (1, 'Jhon White', 35, 'Employee', 35000, 'Via Roma 1, Milano', false),
       (2, 'Jim Green', 50, 'Freelancer', 60000, 'Piazza Duomo 5, Milano', true),
       (3, 'Laura Bianchi', 25, 'Student', 10000, 'Via Garibaldi 10, Torino', false);

-- Policies
INSERT INTO policy (id, type, name, base_premium, coverage_amount, description, min_age, max_age)
VALUES (1, 'LIFE', 'Secure Life', 500, 100000, 'Basic life coverage for young adults', 18, 40),
       (2, 'LIFE', 'Golden Years Life', 1200, 200000,
        'Life coverage for seniors with higher capital', 41, 65),
       (3, 'HEALTH', 'Total Health', 800, 50000, 'Full health coverage, including dental', 18, 60);

-- Claims
INSERT INTO claim (id, policy_id, estimated_damage_value, description, status)
VALUES (1, 1, 5000, 'Claim for minor accident', 'PENDING_APPROVAL'),
       (2, 2, 150000, 'Life insurance claim request', 'APPROVED');