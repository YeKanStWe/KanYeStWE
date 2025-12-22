INSERT INTO animal
(nome_provisorio, especie, raca, porte, idade_estimada,
 condicoes_chegada, nome_recebedor,data_chegada, data_adocao)
VALUES
    ('Rex','Cachorro','Vira-lata','Médio',3,'Resgatado','João',CURRENT_DATE, CURRENT_DATE),
    ('Mia','Gato','Siamês','Pequeno',2,'Abandono','Maria',CURRENT_DATE - 10, null),
    ('Thor','Cachorro','Pastor Alemão','Grande',5,'Entrega voluntária','Carlos',CURRENT_DATE, null);
