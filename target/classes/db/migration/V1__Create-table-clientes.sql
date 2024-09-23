-- Criação de sequência para a tabela de clientes
CREATE SEQUENCE IF NOT EXISTS tb_cliente_id_seq START 1;

-- Tabela Cliente com chave primária autoincrementada
CREATE TABLE IF NOT EXISTS tb_cliente (
    id INT NOT NULL PRIMARY KEY DEFAULT nextval('tb_cliente_id_seq'),
    cnpj VARCHAR(14), -- Tamanho ajustado para CNPJ correto
    nome_social VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL, -- Tamanho ajustado para senhas seguras
    telefone VARCHAR(15), -- Tipo de dados ajustado para incluir DDDs e tamanhos variáveis
    endereco VARCHAR(255) NOT NULL -- Tamanho aumentado para endereços mais completos
);

-- Atualização da sequência do cliente
SELECT setval('tb_cliente_id_seq', COALESCE((SELECT MAX(id) FROM tb_cliente), 1), false);


-- Criação de sequência para a tabela Boleto
CREATE SEQUENCE IF NOT EXISTS tb_boleto_id_seq START 1;

-- Tabela Boleto com chave primária autoincrementada e NF-Boleto única
CREATE TABLE IF NOT EXISTS tb_boleto (
    id_boleto INT NOT NULL PRIMARY KEY DEFAULT nextval('tb_boleto_id_seq'),
    nf_boleto VARCHAR(50) NOT NULL UNIQUE, -- Garantindo que o nf_boleto seja único
    valor_boleto DECIMAL(12, 2) NOT NULL,
    vencimento_boleto DATE NOT NULL,
    data_emissao_boleto DATE NOT NULL,
    cnpj_emissor VARCHAR(14) NOT NULL, -- Tipo ajustado para CNPJ
    data_pagamento TIMESTAMP
);

-- Atualização da sequência do boleto
SELECT setval('tb_boleto_id_seq', COALESCE((SELECT MAX(id_boleto) FROM tb_boleto), 1), false);


-- Criação de sequência para a tabela Pagamento
CREATE SEQUENCE IF NOT EXISTS tb_pagamento_id_seq START 1;

-- Tabela Pagamento
CREATE TABLE IF NOT EXISTS tb_pagamento (
    id_pagamento INT NOT NULL PRIMARY KEY DEFAULT nextval('tb_pagamento_id_seq'),
    valor DECIMAL(12,2),
    forma_pagamento VARCHAR(50) NOT NULL

);

-- Atualização da sequência do pagamento
SELECT setval('tb_pagamento_id_seq', COALESCE((SELECT MAX(id_pagamento) FROM tb_pagamento), 1), false);


-- Tabela Pedido com chave composta e relação com Pagamento
CREATE TABLE IF NOT EXISTS tb_pedido (
    nf_pedido VARCHAR(50) NOT NULL,
    cnpj_emissor VARCHAR(14) NOT NULL, -- Ajustado para CNPJ correto
    valor_total DECIMAL(12, 2) NOT NULL,
    data_pedido DATE NOT NULL,
    nome_social_emissor VARCHAR(50),
    id_pagamento INT NOT NULL,
    PRIMARY KEY (nf_pedido, cnpj_emissor), -- Chave composta com nf_pedido e cnpj_emissor
    FOREIGN KEY (id_pagamento) REFERENCES tb_pagamento(id_pagamento) ON DELETE CASCADE -- Relacionamento com Pagamento
);


-- Criação de sequência para a tabela Depósito
CREATE SEQUENCE IF NOT EXISTS tb_deposito_id_seq START 1;

-- Tabela Depósito
CREATE TABLE IF NOT EXISTS tb_deposito (
    id_transacao INT NOT NULL PRIMARY KEY DEFAULT nextval('tb_deposito_id_seq'),
    valor_deposito DECIMAL(12, 2) NOT NULL
);

-- Atualização da sequência do depósito
SELECT setval('tb_deposito_id_seq', COALESCE((SELECT MAX(id_transacao) FROM tb_deposito), 1), false);
