-- INSERT INTO tb_cliente (id, cpf, cnpj, nome_social, email, senha, telefone, endereco)
-- VALUES
-- (1, '123.456.789-00', '12.345.678/0001-00', 'João Silva', 'joao.silva@example.com', 'senha123', 11987654321, 'Rua A, 123'),
-- (2, '987.654.321-00', '98.765.432/0001-00', 'Maria Oliveira', 'maria.oliveira@example.com', 'senha456', 11987654322, 'Rua B, 456');

-- INSERT INTO tb_boleto (nf_boleto, valor_boleto, vencimento_boleto, data_emissao_boleto, cnpj_emissor, data_pagamento)
--VALUES
--('BOL12345', 1500.00, '2024-09-01', '2024-08-01', 12345678000100, '2024-08-26 14:00:00'),
--('BOL67890', 2500.50, '2024-10-01', '2024-09-01', 98765432000100, '2024-09-25 14:00:00');

--INSERT INTO tb_pedido (nf_pedido, cnpj_emissor, valor_total, data_pedido, nome_social_emissor, id_pagamento)
--VALUES
--('PED12345', 12345678000100, 1500.00, '2024-08-15', 'João Silva', 1),
--('PED67890', 98765432000100, 2500.50, '2024-09-15', 'Maria Oliveira', 2);

--INSERT INTO tb_pagamento (id_pagamento, forma_pagamento)
--VALUES
--(1, 'Cartão de Crédito'),
--(2, 'Boleto Bancário');

--INSERT INTO tb_deposito (id_transacao, valor_deposito)
--VALUES
--(1, 500.00),
--(2, 1000.00);
