CREATE TABLE usuarios
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(200) NOT NULL
);

INSERT INTO usuarios (login, senha)
VALUES ('carlao',
        '$2a$12$m..S/KGh7Uu/qVFipcIQ8.8PciSPxM44MAo9Cv0rQcGF8x79/L6cK');