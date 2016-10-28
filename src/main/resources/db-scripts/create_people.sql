CREATE TABLE "people" (
    ID bigint NOT NULL PRIMARY KEY,
    FIRST_NAME varchar(255), 
    LAST_NAME varchar(255),
    AGE int,
    PLACE_OF_BIRTH varchar(255),
    PROFESSION varchar(255)
);
  
CREATE SEQUENCE people_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;