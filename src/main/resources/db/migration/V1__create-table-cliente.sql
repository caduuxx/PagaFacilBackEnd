CREATE TABLE IF NOT EXISTS tb_cliente (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(25),
    cnpj VARCHAR(25),
    nome_social VARCHAR(25),
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(30) NOT NULL,
    telefone INT,
    endereco VARCHAR(100) NOT NULL
);