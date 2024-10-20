-- Criação de sequência para a tabela de clientes
CREATE SEQUENCE IF NOT EXISTS tb_cliente_id_seq START 1;

-- Tabela Cliente com chave primária autoincrementada
CREATE TABLE IF NOT EXISTS tb_cliente (
    id INT NOT NULL PRIMARY KEY DEFAULT nextval('tb_cliente_id_seq'),
    cnpj VARCHAR(14) NOT NULL,
    nome_social VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(15),
    endereco VARCHAR(255) NOT NULL
);

-- Atualização da sequência do cliente
SELECT setval('tb_cliente_id_seq', COALESCE((SELECT MAX(id) FROM tb_cliente), 1), false);

-- Criação de sequência para a tabela Pedido
CREATE SEQUENCE IF NOT EXISTS tb_pedido_id_seq START 1;

-- Tabela Pedido
CREATE TABLE IF NOT EXISTS tb_pedido (
    id_pedido INT NOT NULL PRIMARY KEY DEFAULT nextval('tb_pedido_id_seq'),
    nf_pedido VARCHAR(50) NOT NULL,
    cnpj_emissor VARCHAR(14) NOT NULL,
    valor_total DECIMAL(12, 2) NOT NULL,
    data_pedido DATE NOT NULL,
    nome_social_emissor VARCHAR(50)
);

-- Atualização da sequência do pedido
SELECT setval('tb_pedido_id_seq', COALESCE((SELECT MAX(id_pedido) FROM tb_pedido), 1), false);

-- Tabela Estado Boleto
CREATE TABLE IF NOT EXISTS tb_estado_boleto (
    id_estado_boleto INT NOT NULL PRIMARY KEY,
    estado_boleto VARCHAR(10) NOT NULL
);

-- Criação de sequência para a tabela Boleto
CREATE SEQUENCE IF NOT EXISTS tb_boleto_id_seq START 1;

-- Tabela Boleto
CREATE TABLE IF NOT EXISTS tb_boleto (
    id_boleto INT NOT NULL PRIMARY KEY DEFAULT nextval('tb_boleto_id_seq'),
    nf_boleto VARCHAR(50) NOT NULL,
    cod_boleto int NOT NULL,
    valor_boleto DECIMAL(12, 2) NOT NULL,
    vencimento_boleto DATE NOT NULL,
    data_emissao_boleto DATE NOT NULL,
    cnpj_emissor VARCHAR(14) NOT NULL,
    data_pagamento TIMESTAMP,
    id_pedido INT,
    id_estado_boleto INT,
    FOREIGN KEY (id_pedido) REFERENCES tb_pedido(id_pedido),
    FOREIGN KEY (id_estado_boleto) REFERENCES tb_estado_boleto(id_estado_boleto)
);

-- Atualização da sequência do boleto
SELECT setval('tb_boleto_id_seq', COALESCE((SELECT MAX(id_boleto) FROM tb_boleto), 1), false);

-- Tabela Forma de Pagamento
CREATE TABLE IF NOT EXISTS tb_forma_pagamento (
    id_forma_pagamento INT NOT NULL PRIMARY KEY,
    forma_pagamento VARCHAR(10) NOT NULL
);


