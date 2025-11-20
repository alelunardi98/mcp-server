DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS policy;
DROP TABLE IF EXISTS claim;

CREATE TABLE customer
(
    id         VARCHAR(50) PRIMARY KEY,
    full_name  VARCHAR(255),
    age        INT,
    profession VARCHAR(255),
    gross_annual_income DOUBLE,
    address    VARCHAR(255),
    smoker     BOOLEAN
);

CREATE TABLE policy
(
    id          VARCHAR(50) PRIMARY KEY,
    type        VARCHAR(50),
    name        VARCHAR(255),
    base_premium DOUBLE,
    coverage_amount DOUBLE,
    description VARCHAR(1024),
    min_age     INT,
    max_age     INT
);

CREATE TABLE claim
(
    id          VARCHAR(50) PRIMARY KEY,
    policy_id   VARCHAR(50),
    estimated_damage_value DOUBLE,
    description VARCHAR(500),
    status      VARCHAR(50)
);
