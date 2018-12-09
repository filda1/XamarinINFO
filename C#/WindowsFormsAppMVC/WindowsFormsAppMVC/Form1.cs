using Newtonsoft.Json;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WindowsFormsAppMVC.Models;
using WindowsFormsAppMVC.Presenters;
using WindowsFormsAppMVC.Views;

namespace WindowsFormsAppMVC
{
    public partial class Form1 : Form, IRectangulo
    {
        public Form1()
        {
            InitializeComponent();
        }

         public string LargoText {

             get => textLargo.Text;
             set => textLargo.Text = value;
         }

       /* public string LargoText
        {

            get { return textLargo.Text; }
            set { textLargo.Text = value; }
        }*/

        public string AnchoText {

            get => textAncho.Text;
            set => textAncho.Text = value;
        }

        public string AreaText {

            get => textArea.Text;
            set => textArea.Text = value;
        }

        public IList<Coin> DataText
        {
            get
            {
                return this.dataGridView1.DataSource as IList<Coin>;
            }

           set
            {
               this.dataGridView1.DataSource = value;
            }
        }


        public DataGridView DataGridV {

            get
            {
                return this.dataGridView1;
            }

            set
            {
                this.dataGridView1.DataSource = value;
            }
        }
        public BindingSource BindingS {

            get
            {
                BindingSource bs = new BindingSource();
                return bs;
            }

            set
            {

                BindingSource bs = new BindingSource();
                bs.DataSource = value;
            }
        }

        public Coin DataTextId {

            get
            {
                return this.dataGridView1.DataSource as Coin;
            }

            set
            {
                this.dataGridView1.DataSource = value;
            }

        }

        private void Form1_Load_1(object sender, EventArgs e)
        {
            Colummns_DataGridView();
         
        }

        private void button2_Click(object sender, EventArgs e)
        {
            RectanguloPresenter rp = new RectanguloPresenter(this);
            rp.MetodoIntermedio();
        }


        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
          /*  int index = e.RowIndex;
            DataGridViewRow selectedRow = dataGridView1.Rows[index];
            var x = selectedRow.Cells[0].Value.ToString();
            MessageBox.Show(x);*/
        }

        private void button3_Click(object sender, EventArgs e)
        {
             GetAllProdutos();
           /* RectanguloPresenter rp = new RectanguloPresenter();
             rp.RestClientAsync();*/
        }

        private async void GetAllProdutos()
        {
            String URI = "https://jsonplaceholder.typicode.com/posts/";
            using (var client = new HttpClient())
            {
                using (var response = await client.GetAsync(URI))
                {
                    if (response.IsSuccessStatusCode)
                    {
                       
                        var ProdutoJsonString = await response.Content.ReadAsStringAsync();
                        dataGridView1.DataSource = JsonConvert.DeserializeObject<Coin[]>(ProdutoJsonString).ToList();
                     //  List<Dictionary<string, string>> obj = Newtonsoft.Json.JsonConvert.DeserializeObject<List<Dictionary<string, string>>>(ProdutoJsonString);
                     //   dataGridView1.DataSource = obj;
                    }
                    else
                    {
                        MessageBox.Show("Não foi possível obter o produto : " + response.StatusCode);
                    }
                }
            }
        }

        private async void GetProdutoById()
        {
            using (var client = new HttpClient())
            {
                BindingSource bsDados = new BindingSource();
                //  URI = txtURI.Text + "/" + codProduto.ToString();
                String URI = "https://jsonplaceholder.typicode.com/posts/2";
                HttpResponseMessage response = await client.GetAsync(URI);
                if (response.IsSuccessStatusCode)
                {
                    var ProdutoJsonString = await response.Content.ReadAsStringAsync();
                    bsDados.DataSource = JsonConvert.DeserializeObject<Coin>(ProdutoJsonString);
                    dataGridView1.DataSource = bsDados;
                }
                else
                {
                    MessageBox.Show("Falha ao obter o produto : " + response.StatusCode);
                }
            }
        }


        private void button4_Click(object sender, EventArgs e)
        {
            RectanguloPresenter rp = new RectanguloPresenter(this);
            rp.MetodoIntermedio();

        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {
          /* var cliente = new WebClient();

            var text = cliente.DownloadString("https://jsonplaceholder.typicode.com/posts/2");

            Coin data = JsonConvert.DeserializeObject<Coin>(text);

            MessageBox.Show(data.title);*/
        }


        // Columnas del DataGridView
        public void Colummns_DataGridView()
        {
            dataGridView1.ColumnCount = 4;
            dataGridView1.Columns[0].Name = "Id";
            dataGridView1.Columns[1].Name = "User";
            dataGridView1.Columns[2].Name = "Title";
            dataGridView1.Columns[3].Name = "Body";


            // COLOR CAMPO,  OJO===> DataGridView tiene que estar EnableHeadersVisualStyles==FALSE
            DataGridViewColumn dataGridViewColumn = dataGridView1.Columns[0];
            dataGridViewColumn.HeaderCell.Style.BackColor = Color.Magenta;
            dataGridViewColumn.HeaderCell.Style.ForeColor = Color.Yellow;
        }


        // Adiciona una Fila
        private void button6_Click(object sender, EventArgs e)
        {
             ArrayList row = new ArrayList();
             row.Add("");
             dataGridView1.Rows.Add(row.ToArray());
        }

        // Ir a Propiedsades del DatagridView  y el relampago y buscar....
        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
           int index = e.RowIndex;
           DataGridViewRow selectedRow = dataGridView1.Rows[index];
          // DataGridViewColumn
           var x = selectedRow.Cells[0].Value.ToString();
           MessageBox.Show(x);
        }
    }
}
