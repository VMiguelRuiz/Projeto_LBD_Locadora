CREATE TABLE TB_GENERO(
GENERO_ID INT NOT NULL,
GENERO_NOME VARCHAR(20) NOT NULL
);

-- ## TB_GENERO #######################################################################################################################

CREATE OR REPLACE PROCEDURE INSERIRGENERO(NOME IN VARCHAR)
AS 
BEGIN 
    INSERT INTO TB_GENERO(GENERO_ID, GENERO_NOME) VALUES (seq_crescente_genero.nextval , NOME);
END;

--##
CREATE OR REPLACE PROCEDURE EXCLUIGENERO (ID IN INT)
AS 
BEGIN 
	DELETE FROM TB_GENERO WHERE GENERO_ID = ID;
END;

--##
CREATE OR REPLACE PROCEDURE ALTERARGENERO (ID IN INT, NOME IN VARCHAR)
AS 
BEGIN 
    UPDATE TB_GENERO SET GENERO_NOME = NOME
	WHERE GENERO_ID = ID;
END;

--##
create sequence seq_crescente_genero
	start with 1
	increment by +1
	maxvalue 1000
	minvalue 1
	nocache
	cycle;

-- ## TB_GENERO #######################################################################################################################

ALTER TABLE TB_GENERO ADD CONSTRAINT PK_TB_GENERO PRIMARY KEY(GENERO_ID);