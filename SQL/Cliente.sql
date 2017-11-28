------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------CREATE TABLE----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE TB_CLIENTE(
	CLIENTE_ID INT NOT NULL,
	CLIENTE_NOME VARCHAR(45) NOT NULL,
	CLIENTE_CPF LONG NOT NULL,
	CLIENTE_ENDERECO VARCHAR(50) NOT NULL,
	CLIENTE_TELEFONE VARCHAR(11) NOT NULL
);
------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------SEQUENCIAL------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------
create sequence seq_crescente_cliente
	start with 1
	increment by +1
	maxvalue 1000
	minvalue 1
	nocache
	cycle;
------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------PROCEDURES------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERIRCLIENTE(NOME IN VARCHAR, CPF IN LONG, ENDERECO IN VARCHAR, TELEFONE IN VARCHAR)
AS 
BEGIN 
    INSERT INTO TB_CLIENTE(CLIENTE_ID, CLIENTE_NOME, CLIENTE_CPF, CLIENTE_ENDERECO, CLIENTE_TELEFONE) VALUES (seq_crescente_cliente.nextval, NOME, CPF, ENDERECO, TELEFONE);
END;

--##
CREATE OR REPLACE PROCEDURE EXCLUICLIENTE (ID IN INT)
AS 
BEGIN 
	DELETE FROM TB_CLIENTE WHERE CLIENTE_ID = ID;
END;

--##
CREATE OR REPLACE PROCEDURE ALTERARCLIENTE (ID IN INT, NOME IN VARCHAR, CPF IN LONG, ENDERECO IN VARCHAR, TELEFONE IN VARCHAR)
AS 
BEGIN 
    UPDATE TB_CLIENTE SET CLIENTE_NOME = NOME, CLIENTE_CPF = CPF, CLIENTE_ENDERECO = ENDERECO, CLIENTE_TELEFONE = TELEFONE
	WHERE CLIENTE_ID = ID;
END;

------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------ALTER TABLE-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE TB_CLIENTE ADD CONSTRAINT PK_TB_CLIENTE PRIMARY KEY(CLIENTE_ID);

