using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsAppMVC.Models
{
   public class Rectangulo
    {
     
        public double Largo { get; set; }
        public double Ancho { get; set; }

        public double Area()
        {
            return Largo * Ancho;
        }

    }
}
