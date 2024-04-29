class Atleta:
    def __init__(self, nome, apelido, fone, data_nascimento, pontuacao):
        self.nome = nome
        self.apelido = apelido
        self.fone = fone
        self.data_nascimento = data_nascimento
        self.pontuacao = pontuacao

    def __str__(self):
        return f"Atleta: {self.nome}, Apelido: {self.apelido}, Fone: {self.fone}, Data de Nascimento: {self.data_nascimento}, Pontuação: {self.pontuacao}"

    def get_nome(self):
        return self.nome

    def set_nome(self, nome):
        self.nome = nome

    def get_apelido(self):
        return self.apelido

    def set_apelido(self, apelido):
        self.apelido = apelido

    def get_fone(self):
        return self.fone

    def set_fone(self, fone):
        self.fone = fone

    def get_data_nascimento(self):
        return self.data_nascimento

    def set_data_nascimento(self, data_nascimento):
        self.data_nascimento = data_nascimento

    def get_pontuacao(self):
        return self.pontuacao

    def set_pontuacao(self, pontuacao):
        self.pontuacao = pontuacao

    def __eq__(self, other):
        if isinstance(other, Atleta):
            return self.fone == other.fone
        return False

    def __hash__(self):
        return hash(self.fone)
