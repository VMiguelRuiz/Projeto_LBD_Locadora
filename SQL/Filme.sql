

CREATE TABLE TB_FILME(
FILME_ID INT NOT NULL,
FILME_TITULO VARCHAR(20) NOT NULL,
GENERO_ID INT NOT NULL
);

-- TB_FILME #######################################################################################################################

CREATE OR REPLACE PROCEDURE INSERIRFILME(TITULO IN VARCHAR, GENERO IN INT)
AS 
BEGIN 
    INSERT INTO TB_FILME(FILME_ID, FILME_TITULO, GENERO_ID) VALUES (seq_crescente_filme.nextval, TITULO, GENERO);
END;

--##
CREATE OR REPLACE PROCEDURE EXCLUIFILME (ID IN INT)
AS 
BEGIN 
	DELETE FROM TB_FILME WHERE FILME_ID = ID;
END;

--##
CREATE OR REPLACE PROCEDURE ALTERARFILME (ID IN INT, TITULO IN VARCHAR, GENERO IN INT)
AS 
BEGIN 
    UPDATE TB_FILME SET FILME_TITULO = TITULO, GENERO_ID = GENERO
	WHERE FILME_ID = ID;
END;

--##
create sequence seq_crescente_filme
	start with 1
	increment by +1
	maxvalue 1000
	minvalue 1
	nocache
	cycle;

-- TB_FILME #######################################################################################################################

ALTER TABLE TB_FILME ADD CONSTRAINT PK_TB_FILME PRIMARY KEY(FILME_ID);
ALTER TABLE TB_FILME ADD CONSTRAINT FK_TB_FILME FOREIGN KEY(GENERO_ID) REFERENCES TB_GENERO(GENERO_ID);









