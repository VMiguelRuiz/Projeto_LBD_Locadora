------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------CREATE TABLE----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE TB_COPIA(
	COPIA_ID INT NOT NULL,
	FILME_ID INT NOT NULL,
	COPIA_LOCADA INT NOT NULL,
	FORMATO_ID INT NOT NULL,
	COPIA_VALOR FLOAT NOT NULL
);
------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------SEQUENCIAL------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
create sequence seq_crescente_copia
	start with 1
	increment by +1
	maxvalue 1000
	minvalue 1
	nocache
	cycle;
------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------PROCEDURES------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE INSERIRCOPIA(FILME IN INT, LOCADO IN INT, FORMATO IN INT, VALOR IN FLOAT)
AS 
BEGIN 
    INSERT INTO TB_COPIA(COPIA_ID, FILME_ID, COPIA_LOCADA, FORMATO_ID, COPIA_VALOR) VALUES (seq_crescente_copia.nextval, FILME, LOCADO, FORMATO, VALOR);
END;

--##
CREATE OR REPLACE PROCEDURE EXCLUICOPIA (ID IN INT)
AS 
BEGIN 
	DELETE FROM TB_COPIA WHERE COPIA_ID = ID;
END;

--##
CREATE OR REPLACE PROCEDURE ALTERARCOPIA (ID IN INT, FILME IN INT, LOCADO IN INT, FORMATO IN INT, VALOR IN FLOAT)
AS 
BEGIN 
    UPDATE TB_COPIA SET FILME_ID = FILME, COPIA_LOCADA = LOCADO, FORMATO_ID = FORMATO, COPIA_VALOR = VALOR
	WHERE COPIA_ID = ID;
END;

------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------ALTER TABLE-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE TB_COPIA ADD CONSTRAINT PK_TB_COPIA PRIMARY KEY(COPIA_ID);
ALTER TABLE TB_COPIA ADD CONSTRAINT FK_TB_COPIA_FILME FOREIGN KEY(FILME_ID) REFERENCES TB_FILME(FILME_ID);
ALTER TABLE TB_COPIA ADD CONSTRAINT FK_TB_COPIA_FILME FOREIGN KEY(FORMATO_ID) REFERENCES TB_FORMATO(FORMATO_ID);