create table tb_cliente (
    id int NOT NULL PRIMARY key,
    cpf varchar(50),
    cnpj varchar(50),
    nome_social varchar(50),
    email varchar(50) NOT NULL,
    senha varchar(50) NOT NULL,
    telefone int,
    endereco varchar(50) NOT NULL
    );

   CREATE TABLE tb_boleto (
       nf_boleto VARCHAR(50) NOT NULL PRIMARY KEY,
       valor_boleto DECIMAL(12,2) NOT NULL,
       vencimento_boleto DATE NOT NULL,
       data_emissao_boleto DATE NOT NULL,
       cnpj_emissor INT NOT NULL,
       data_pagamento TIMESTAMP NOT NULL
   );

   CREATE TABLE tb_pedido (
       nf_pedido VARCHAR(50) NOT NULL,
       cnpj_emissor INT NOT NULL,
       valor_total DECIMAL(12,2) NOT NULL,
       data_pedido DATE NOT NULL,
       nome_social_emissor VARCHAR(50),
       id_pagamento INT NOT NULL
   );

    create table tb_pagamento(
    forma_pagamento varchar(50)  NOT NULL,
    id_pagamento int  NOT NULL primary key
    );
    create table tb_deposito (
    id_transacao int not null primary key,
    valor_deposito decimal);

