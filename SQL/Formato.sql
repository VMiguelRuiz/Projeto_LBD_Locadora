
CREATE TABLE TB_FORMATO(
FORMATO_ID INT NOT NULL,
FORMATO_NOME VARCHAR(20) NOT NULL
);


-- ## TB_FORMATO #######################################################################################################################

CREATE OR REPLACE PROCEDURE INSERIRFORMATO (NOME IN VARCHAR)
AS
BEGIN 
    INSERT INTO TB_FORMATO (FORMATO_ID, FORMATO_NOME)
    VALUES (seq_crescente_formato.nextval, NOME);
END;

--##
CREATE OR REPLACE PROCEDURE EXCLUIRFORMATO (ID IN INT) 
AS 
BEGIN 
    DELETE FROM TB_FORMATO
    WHERE FORMATO_ID = ID;
END;

--##
CREATE OR REPLACE PROCEDURE ALTERARFORMATO (ID IN INT, NOME IN VARCHAR)
AS 
BEGIN 
    UPDATE TB_FORMATO SET FORMATO_NOME = NOME
	WHERE FORMATO_ID = ID;
END;

--##
create sequence seq_crescente_formato
	start with 1
	increment by +1
	maxvalue 1000
	minvalue 1
	nocache
	cycle;


-- ## TB_FORMATO #######################################################################################################################

ALTER TABLE TB_FORMATO ADD CONSTRAINT PK_TB_FORMATO PRIMARY KEY(FORMATO_ID);



