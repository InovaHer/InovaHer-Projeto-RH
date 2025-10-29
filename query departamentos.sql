USE db_inovarh;


INSERT tb_departamentos( nome, descricao)
VALUES ("Recursos Humanos", "Responsável pela gestão de pessoas, recrutamento, seleção e desenvolvimento de colaboradores.");
INSERT tb_departamentos( nome, descricao)
VALUES ("Financeiro", "Controla as finanças da empresa, realiza pagamentos, cobranças e planejamento orçamentário.");
INSERT tb_departamentos( nome, descricao)
VALUES ("Tecnologia da Informação", "Garante o funcionamento dos sistemas, infraestrutura de TI e suporte técnico.");
INSERT tb_departamentos( nome, descricao)
VALUES ("Marketing", "Cuida da imagem da empresa, campanhas publicitárias e comunicação com o público.");
INSERT tb_departamentos( nome, descricao)
VALUES ("Compras", "Realiza a aquisição de materiais e serviços necessários para as operações da empresa.");

SELECT * FROM tb_departamentos