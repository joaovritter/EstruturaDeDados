using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fila
{
    internal class Cliente
    {
        public string Fone { get; set; }
        public string Nome { get; set; }
        public int FichaAtendimento { get; set; }


        public Cliente(string fone, string nome, int ficha)
        {
            this.Fone = fone;
            this.Nome = nome;
            this.FichaAtendimento = ficha;
        }

        
        public override string ToString()
        {
            return "Cliente: " + this.Nome + " : " + this.Fone + " -> Ficha: " + this.FichaAtendimento + "\n";
        }
    }
}
