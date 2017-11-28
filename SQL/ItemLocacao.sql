------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------CREATE TABLE----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE TB_ITEMLOCACAO(
	ITEM_ID INT NOT NULL,
	COPIA_ID INT NOT NULL, 
	LOCACAO_ID INT NOT NULL
);
------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------SEQUENCIAL------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
create sequence seq_crescente_item
	start with 1
	increment by +1
	maxvalue 1000
	minvalue 1
	nocache
	cycle;
------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------PROCEDURES------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE INSERIRITEM(COPIA IN INT, LOCACAO IN INT)
AS 
BEGIN 
    INSERT INTO TB_ITEMLOCACAO(ITEM_ID, COPIA_ID, LOCACAO_ID) VALUES (seq_crescente_item.nextval, COPIA, LOCACAO);
END;

--##
CREATE OR REPLACE PROCEDURE EXCLUIITEM (ID IN INT)
AS 
BEGIN 
	DELETE FROM TB_ITEMLOCACAO WHERE ITEM_ID = ID;
END;

--##
CREATE OR REPLACE PROCEDURE ALTERARITEM (ID IN INT, COPIA IN INT, LOCACAO IN INT)
AS 
BEGIN 
    UPDATE TB_ITEMLOCACAO SET COPIA_ID = COPIA, LOCACAO_ID = LOCACAO
	WHERE ITEM_ID = ID;
END;

------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------ALTER TABLE-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE TB_ITEMLOCACAO ADD CONSTRAINT PK_TB_ITEMLOCACAO PRIMARY KEY(ITEM_ID);
ALTER TABLE TB_ITEMLOCACAO ADD CONSTRAINT FK_TB_ITEMLOCACAO FOREIGN KEY(COPIA_ID) REFERENCES TB_COPIA(COPIA_ID);
ALTER TABLE TB_ITEMLOCACAO ADD CONSTRAINT FK_TB_ITEMLOCACAO_LOCACAO FOREIGN KEY(LOCACAO_ID) REFERENCES TB_LOCACAO(LOCACAO_ID);