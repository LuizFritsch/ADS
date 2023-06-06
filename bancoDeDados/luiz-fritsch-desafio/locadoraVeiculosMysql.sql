-- Criação do banco de dados
CREATE DATABASE locadoraVeiculosLogico;

-- Use o banco de dados criado
USE locadoraVeiculosLogico;

-- Criação da tabela veiculo
CREATE TABLE veiculo (
    placa VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(255),
    modelo VARCHAR(255),
    ano INTEGER,
    fabricante VARCHAR(255),
    nmr_passageiros INTEGER,
    capacidade_portamalas INTEGER,
    valor_locacao_dia DOUBLE,
    valor_locacao_semana DOUBLE,
    valor_locacao_mes DOUBLE
);

-- Inserção de dados na tabela veiculo
INSERT INTO veiculo (placa, nome, modelo, ano, fabricante, nmr_passageiros, capacidade_portamalas, valor_locacao_dia, valor_locacao_semana, valor_locacao_mes)
VALUES
    ('ABC123', 'Carro A', 'Modelo A', 2022, 'Fabricante A', 5, 300, 50.00, 300.00, 1000.00),
    ('XYZ789', 'Carro B', 'Modelo B', 2021, 'Fabricante B', 4, 250, 45.00, 280.00, 950.00),
    ('DEF456', 'Carro C', 'Modelo C', 2023, 'Fabricante C', 7, 400, 60.00, 350.00, 1200.00),
    ('GHI789', 'Carro D', 'Modelo D', 2020, 'Fabricante D', 5, 350, 55.00, 320.00, 1100.00),
    ('JKL012', 'Carro E', 'Modelo E', 2022, 'Fabricante E', 4, 280, 48.00, 280.00, 980.00);

-- Criação da tabela cliente
CREATE TABLE cliente (
    cpf VARCHAR(15) PRIMARY KEY,
    nome VARCHAR(255),
    categoria_cnh CHAR(1),
    data_nascimento DATE,
    endereco_completo VARCHAR(255)
);

-- Inserção de dados na tabela cliente
INSERT INTO cliente (cpf, nome, categoria_cnh, data_nascimento, endereco_completo)
VALUES
    ('12345678901', 'Cliente A', 'A', '1990-05-15', 'Endereço A'),
    ('23456789012', 'Cliente B', 'B', '1985-08-20', 'Endereço B'),
    ('34567890123', 'Cliente C', 'A', '1995-03-10', 'Endereço C'),
    ('45678901234', 'Cliente D', 'B', '1980-12-05', 'Endereço D'),
    ('56789012345', 'Cliente E', 'A', '1992-07-25', 'Endereço E');

-- Criação da tabela manutencao
CREATE TABLE manutencao (
    data_inicio DATE,
    valor_total DOUBLE,
    data_termino DATE,
    atividade VARCHAR(255),
    fk_veiculo_placa VARCHAR(20),
    FOREIGN KEY (fk_veiculo_placa) REFERENCES veiculo(placa) ON DELETE SET NULL
);

-- Inserção de dados na tabela manutencao
INSERT INTO manutencao (data_inicio, valor_total, data_termino, atividade, fk_veiculo_placa)
VALUES
    ('2023-09-01', 150.00, '2023-09-05', 'Troca de óleo', 'ABC123'),
    ('2023-08-15', 200.00, '2023-08-20', 'Reparo do motor', 'XYZ789'),
    ('2023-09-10', 100.00, '2023-09-15', 'Verificação de freios', 'DEF456'),
    ('2023-08-25', 180.00, '2023-08-30', 'Troca de pneus', 'GHI789'),
    ('2023-09-05', 120.00, '2023-09-10', 'Reparo elétrico', 'JKL012');

-- Criação da tabela locacao
CREATE TABLE locacao (
    fk_cliente_cpf VARCHAR(15),
    fk_veiculo_placa VARCHAR(20),
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    data_inicio DATE,
    data_termino DATE,
    valor_total DOUBLE,
    FOREIGN KEY (fk_cliente_cpf) REFERENCES cliente(cpf) ON DELETE SET NULL,
    FOREIGN KEY (fk_veiculo_placa) REFERENCES veiculo(placa) ON DELETE SET NULL
);

-- Inserção de dados na tabela locacao
INSERT INTO locacao (fk_cliente_cpf, fk_veiculo_placa, data_inicio, data_termino, valor_total)
VALUES
    ('12345678901', 'ABC123', '2023-09-01', '2023-09-10', 500.00),
    ('23456789012', 'XYZ789', '2023-08-15', '2023-08-22', 400.00),
    ('34567890123', 'DEF456', '2023-09-10', '2023-09-17', 550.00),
    ('45678901234', 'GHI789', '2023-08-25', '2023-09-05', 320.00),
    ('56789012345', 'JKL012', '2023-09-05', '2023-09-12', 380.00);
