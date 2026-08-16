CREATE TABLE Policy (
    Policy_Id VARCHAR(50) NOT NULL,
    Policy_Details TEXT,
    Hotel_Id VARCHAR(50) NOT NULL,
    PRIMARY KEY (Policy_Id),
    CONSTRAINT fk_policy_hotel FOREIGN KEY (Hotel_Id) REFERENCES Hotel(Hotel_Id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

