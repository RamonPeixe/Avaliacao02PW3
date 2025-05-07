CREATE TABLE repairs (
                         id          BIGINT   AUTO_INCREMENT PRIMARY KEY,
                         entry_date  VARCHAR(10) NOT NULL,
                         exit_date   VARCHAR(10),
                         mech_name   VARCHAR(100) NOT NULL,
                         mech_years  INT           NOT NULL,
                         veh_make    VARCHAR(50)   NOT NULL,
                         veh_model   VARCHAR(50)   NOT NULL,
                         veh_year    VARCHAR(4)    NOT NULL
);