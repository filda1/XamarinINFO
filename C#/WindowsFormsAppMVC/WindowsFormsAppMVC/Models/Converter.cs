using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsAppMVC.Models
{
    public class Converter
    {
       
       
        private Coin objeto;
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
                     //  object = JsonConvert.DeserializeObject<Coin[]>(ProdutoJsonString).ToList();
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
                String URI = "https://jsonplaceholder.typicode.com/posts/2";
                HttpResponseMessage response = await client.GetAsync(URI);
                if (response.IsSuccessStatusCode)
                {
                    var ProdutoJsonString = await response.Content.ReadAsStringAsync();
                    bsDados.DataSource = JsonConvert.DeserializeObject<Coin>(ProdutoJsonString);
                    //dgvDados.DataSource = bsDados;
                }
                else
                {
                    MessageBox.Show("Falha ao obter o produto : " + response.StatusCode);
                }
            }
       
        }
    }
}
