using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WindowsFormsAppMVC.Models;

namespace WindowsFormsAppMVC.Views
{
    public interface IRectangulo
    {
        String LargoText { get; set; }
        String AnchoText { get; set; }
        String AreaText { get; set; }
        IList<Coin> DataText { get; set; }
        Coin DataTextId { get; set; }
        DataGridView DataGridV { get; set; }
        BindingSource BindingS { get; set; }
    }
}
