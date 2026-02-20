ALTER TABLE booking
DROP
CONSTRAINT fkei2mjigb4hb2sm4htt6jhwn6;

ALTER TABLE passanger_review
DROP
CONSTRAINT fkfsk2381wrtp4shcye38fjlsvu;

ALTER TABLE passenger
    ADD email VARCHAR(255);

ALTER TABLE passenger
    ADD password VARCHAR(255);

ALTER TABLE passenger
    ADD phonenumber VARCHAR(255);

ALTER TABLE passenger
    ALTER COLUMN email SET NOT NULL;

ALTER TABLE passenger
    ALTER COLUMN password SET NOT NULL;

ALTER TABLE passenger
    ALTER COLUMN phonenumber SET NOT NULL;

DROP TABLE bookingreview CASCADE;

DROP TABLE hibernate_sequences CASCADE;

DROP TABLE passanger_review CASCADE;

ALTER TABLE booking
DROP
COLUMN review_id;

ALTER TABLE passenger
    ALTER COLUMN name SET NOT NULL;

