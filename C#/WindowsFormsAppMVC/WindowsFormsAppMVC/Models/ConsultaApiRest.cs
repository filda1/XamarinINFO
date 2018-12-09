using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsAppMVC.Models
{
   public class ConsultaApiRest
    {
        //public List<Coin> Items { get;  set; }
        List<Coin> Items;
   
        // Get All, Lista 
        public async Task<List<Coin>> GetAllProdutos()
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


        public async Task<List<Coin>> RefreshDataAsync()
        {
            Items = new List<Coin>();
            

            String uri = "https://jsonplaceholder.typicode.com/posts/";
            var client = new HttpClient();

            try
            {
                var response = await client.GetAsync(uri);
                if (response.IsSuccessStatusCode)
                {
                    var content = await response.Content.ReadAsStringAsync();
                    Items= JsonConvert.DeserializeObject<List<Coin>>(content);
                }

                return Items;
            }
            catch (Exception ex)
            {
                MessageBox.Show(@"				ERROR {0}", ex.Message);
            }

            return Items;
        }


        // Get Id
        public async Task<Coin> GetId()
        {
            var cliente = new WebClient();
            String uri = "https://jsonplaceholder.typicode.com/posts/2";

            try
            {             
                var text = cliente.DownloadString(uri);

                Coin result= JsonConvert.DeserializeObject<Coin>(text);
                return result;
            }
            catch
            {
                return null;
            }
        }

         public async Task<Coin> GetProdutoById()
        {

            Coin co;
            using (var client = new HttpClient())
            {
                BindingSource bsDados = new BindingSource();
                String URI = "https://jsonplaceholder.typicode.com/posts/2";
                HttpResponseMessage response = await client.GetAsync(URI);

                var ProdutoJsonString = await response.Content.ReadAsStringAsync();
                var X = JsonConvert.DeserializeObject<Coin>(ProdutoJsonString);

                co = new Coin
                {
                    body = X.body,
                    id = X.id,
                    title = X.title,
                    userId = X.userId,
                };

                //dgvDados.DataSource = bsDados;

                return co;

            }

          
        }
    }
}




