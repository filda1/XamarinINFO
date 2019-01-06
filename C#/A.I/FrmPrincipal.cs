using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Sintetizador
{
    public partial class FrmPrincipal : Form
    {
        public FrmPrincipal()
        {
            InitializeComponent();
        }

        private void btnExecutar_Click(object sender, EventArgs e)
        {
            Fala Speech = Fala.getInstance(ref btnExecutar);
            Speech.Velocidade = (int)tkbVelocidade.Value;
            Speech.Volume = (int)tkbVolume.Value;

            
            if (string.IsNullOrWhiteSpace(rtbTexto.Text))
            {
                MessageBox.Show("Favor digitar o texto!");
                rtbTexto.Focus();
                return;
            }

            //Executar a síntese de voz
            Speech.Falar(rtbTexto.Text);
        }

        private void btnLimpar_Click(object sender, EventArgs e)
        {
            rtbTexto.Clear();
        }

        private void FrmPrincipal_Load(object sender, EventArgs e)
        {

        }
    }
}
