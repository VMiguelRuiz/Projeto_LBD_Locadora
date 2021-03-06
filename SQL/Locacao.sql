--------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------CREATE TABLE------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE TB_LOCACAO(
	LOCACAO_ID INT NOT NULL,
	LOCACAO_DATA DATE NOT NULL,
	LOCACAO_VALOR FLOAT NOT NULL, 
	CLIENTE_ID INT NOT NULL
);

------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------SEQUENCIAL------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
create sequence seq_crescente_locacao
	start with 1
	increment by +1
	maxvalue 1000
	minvalue 1
	nocache
	cycle;

------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------PROCEDURES------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERIRLOCACAO(DATA_SAIDA IN DATE, VALOR IN FLOAT, CLIENTE IN INT)
AS 
BEGIN 
    INSERT INTO TB_LOCACAO(LOCACAO_ID, LOCACAO_DATA, LOCACAO_VALOR, CLIENTE_ID) VALUES (seq_crescente_locacao.nextval, TO_DATE(DATA_SAIDA, 'YYYY/MM/DD'), VALOR, CLIENTE);
END;

--##
CREATE OR REPLACE PROCEDURE EXCLUILOCACAO (ID IN INT)
AS 
BEGIN 
	DELETE FROM TB_LOCACAO WHERE LOCACAO_ID = ID;
END;

--##
CREATE OR REPLACE PROCEDURE ALTERARLOCACAO (ID IN INT, DATA_SAIDA IN DATE, VALOR IN FLOAT, CLIENTE IN INT)
AS 
BEGIN 
    UPDATE TB_LOCACAO SET LOCACAO_DATA = TO_DATE(LOCACAO_DATA, 'YYYY/MM/DD'), LOCACAO_VALOR = VALOR, CLIENTE_ID = CLIENTE
	WHERE LOCACAO_ID = ID;
END;

------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------ALTER TABLE-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
ALTER TABLE TB_LOCACAO ADD CONSTRAINT PK_TB_LOCACAO PRIMARY KEY(LOCACAO_ID);
ALTER TABLE TB_LOCACAO ADD CONSTRAINT FK_TB_LOCACAO FOREIGN KEY(CLIENTE_ID) REFERENCES TB_CLIENTE(CLIENTE_ID);
