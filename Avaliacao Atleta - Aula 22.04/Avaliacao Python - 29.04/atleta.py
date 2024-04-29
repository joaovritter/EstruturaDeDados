class Atleta:
    def __init__(self, nome, apelido, fone, data_nascimento,pontuacao):
        self.nome = nome
        self.apelido = apelido
        self.fone = fone
        self.data_nascimento = data_nascimento
        self.pontuacao = pontuacao
        
    def __str__(self) -> str:
        return f"Atleta: {self.nome}, Apelido: {self.apelido}, Fone: {self.fone}, Data de Nascimento: {self.data_nascimento}, Pontuação: {self.pontuacao}"