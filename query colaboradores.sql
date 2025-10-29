USE db_inovarh;


INSERT INTO tb_colaboradores (nome, data_nascimento, valor_hora, horas_trabalhadas, bonus, descontos, departamento_id)
VALUES 
("Ana Souza",       '1990-05-12', 75.50, 160, 1200.00, 300.00, 2), 
("Bruno Lima",      '1987-09-25', 68.00, 170, 950.00, 200.00, 2),  
("Carlos Mendes",   '1985-03-08', 90.00, 180, 1500.00, 400.00, 2), 
("Daniela Ribeiro", '1992-12-19', 85.75, 160, 1000.00, 250.00, 2), 
("Eduardo Silva",   '1995-07-03', 120.00, 175, 1800.00, 500.00, 3),
("Fernanda Costa",  '1998-02-14', 110.50, 165, 1600.00, 450.00, 3),
("Gabriela Torres", '1993-06-29', 70.00, 160, 900.00, 200.00, 4),  
("Henrique Dias",   '1989-10-10', 72.50, 168, 950.00, 180.00, 4),  
("Isabela Martins", '1994-04-21', 65.00, 172, 850.00, 150.00, 5),  
("João Pereira",    '1986-11-07', 68.25, 166, 870.00, 220.00, 5);  

SELECT * FROM tb_colaboradores;
