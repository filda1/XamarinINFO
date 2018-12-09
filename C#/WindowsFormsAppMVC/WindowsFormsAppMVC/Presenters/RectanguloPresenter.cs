using Newtonsoft.Json;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WindowsFormsAppMVC.Models;
using WindowsFormsAppMVC.Views;

namespace WindowsFormsAppMVC.Presenters
{
   public class RectanguloPresenter
    {
        

        #region Services
        private readonly ConsultaApiRest apiService;
        private  List<Coin> Items;
        private readonly IRectangulo rectanguloView;
        #endregion


        public RectanguloPresenter( IRectangulo view)
        {
            rectanguloView = view;
            this.apiService = new ConsultaApiRest();
        }
        public RectanguloPresenter()
        {
  
            this.apiService = new ConsultaApiRest();
        }
        public async Task MetodoIntermedio()
        {
            Rectangulo rectangulo = new Rectangulo
            {
               // Largo = double.Parse(rectanguloView.LargoText),
               // Ancho = double.Parse(rectanguloView.AnchoText)
            };

            //// rectanguloView.AreaText = rectangulo.Area().ToString();


            /* var cliente = new WebClient();

             var text = cliente.DownloadString("https://jsonplaceholder.typicode.com/posts/2");

             Coin data = JsonConvert.DeserializeObject<Coin>(text);*/


////////////////////////////////////////////////////////////    Codigo     /////////////////////////////////////////////////////////////////
///

            // OBTENER LISTA DE REGISTROS URL (JSON)
            //rectanguloView.DataText = await apiService.GetAllProdutos(); 

            // OBTENER UN REGISTRO DESDE URL (JSON)
            Coin data = await apiService.GetId();

            rows_DataGridView(data);
        




        }

      

     

        // Filas del DatagridView
        public void rows_DataGridView(Coin data)
        {
            // 4 colummnas

            /* ArrayList row = new ArrayList();
             row.Add("1");
             row.Add("usuario")
             row.Add("titulo1");
             row.Add("olaaa");
             rectanguloView.DataGridV.Rows.Add(row.ToArray());

             // Row 2
             row = new ArrayList();
               row.Add("2");
             row.Add("usuario2")
             row.Add("titulo2");
             row.Add("olaaa2");
             rectanguloView.DataGridV.Rows.Add(row.ToArray());*/


            // Row 1
            ArrayList row = new ArrayList
            {
                data.id,
                data.userId,
                data.title,
                data.body,
            };
            rectanguloView.DataGridV.Rows.Add(row.ToArray());

            // Row 2
          /*  row = new ArrayList
            {
                data.userId
            };
            rectanguloView.DataGridV.Rows.Add(row.ToArray());

            // Row 3
            row = new ArrayList
            {
                data.title
            };
            rectanguloView.DataGridV.Rows.Add(row.ToArray());

            // Row 4
            row = new ArrayList
            {
                data.body
            };
            rectanguloView.DataGridV.Rows.Add(row.ToArray());*/


        }
        // CAMPOS DE COLUMNA
        // rectanguloView.DataGridV.ColumnCount = 1;
        //  rectanguloView.DataGridV.Columns[0].Name = "User";




  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///
        private async Task<List<Coin>> GetAllProdutos()
        {
            Items = new List<Coin>();
            Coin coo = new Coin();

            String URI = "https://jsonplaceholder.typicode.com/posts/";
            using (var client = new HttpClient())
            {
                using (var response = await client.GetAsync(URI))
                {
                    if (response.IsSuccessStatusCode)
                    {
                        var ProdutoJsonString = await response.Content.ReadAsStringAsync();
                        var Lista = JsonConvert.DeserializeObject<Coin[]>(ProdutoJsonString).ToList();
                        //  List<Dictionary<string, string>> obj = Newtonsoft.Json.JsonConvert.DeserializeObject<List<Dictionary<string, string>>>(ProdutoJsonString);
                        //   dataGridView1.DataSource = obj;

                        foreach (var item in Lista)
                        {
                            coo.body = item.body;
                            coo.id = item.id;
                            coo.title = item.title;
                            coo.userId = item.userId;

                            Items.Add(coo);
                        }

                    }
                    else
                    {
                        MessageBox.Show("Não foi possível obter o produto : " + response.StatusCode);
                    }
                }
            }

            return Items;
        }

        private async Task<List<Coin>> GetProdutoById()
        {
            Items = new List<Coin>();
            Coin coo = new Coin();

            String URI = "https://jsonplaceholder.typicode.com/posts/2";
            using (var client = new HttpClient())
            {
                using (var response = await client.GetAsync(URI))
                {
                    if (response.IsSuccessStatusCode)
                    {
                        var ProdutoJsonString = await response.Content.ReadAsStringAsync();
                        var Lista = JsonConvert.DeserializeObject<Coin[]>(ProdutoJsonString).ToList();
                        //  List<Dictionary<string, string>> obj = Newtonsoft.Json.JsonConvert.DeserializeObject<List<Dictionary<string, string>>>(ProdutoJsonString);
                        //   dataGridView1.DataSource = obj;

                        foreach (var item in Lista)
                        {
                            coo.body = item.body;
                            coo.id = item.id;
                            coo.title = item.title;
                            coo.userId = item.userId;

                            Items.Add(coo);
                        }

                    }
                    else
                    {
                        MessageBox.Show("Não foi possível obter o produto : " + response.StatusCode);
                    }
                }
            }

            return Items;
        }


    }
}
