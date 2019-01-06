using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Speech.Synthesis;
using System.Speech.Recognition;
using System.Threading;
using System.Globalization; 
using System.Speech.AudioFormat;


namespace WhatsappVoxEmail
{
    public partial class Form1 : Form
    {

        

        // Palavras aceitas
        public string[] listaPalavras = { "oi" };

        public Form1()
        {
            InitializeComponent();

            
        }

//**************************************************************TEXTO A VOZ en ***********************************************************************************************
        // Boton Hablar
        // NOTA: activar antes System.Speech en =========> Menu, Proyect ====> Add References.. ===> Assemblies
        private void button1_Click(object sender, EventArgs e)
        {
            Thread tarea = new Thread(new ParameterizedThreadStart(hablar));
            tarea.Start(richTextBox1.Text);
        }
        private void hablar(object texto)
        {
            SpeechSynthesizer voz = new SpeechSynthesizer();
            //SpeechRecognitionEngine recognizer = new SpeechRecognitionEngine(new CultureInfo("es-ES"));
            voz.SetOutputToDefaultAudioDevice();
            voz.Speak(texto.ToString());
        }

 //*****************************************************************************************************************************************************

  
            
        
    
/////////////////////////////////////////////////////////////// ENVIAR EMAIL////////////////////////////////////////////////////////////////////////////////////////////////////////
        private void button2_Click(object sender, EventArgs e)
        {
            /////////////////////// RECEPTOR ////////////////////////////////////////
            System.Net.Mail.MailMessage msg = new System.Net.Mail.MailMessage();
            msg.To.Add("filintomeireles@gmail.com");
            msg.Subject = "N3";
            msg.SubjectEncoding = System.Text.Encoding.UTF8;
            msg.Bcc.Add("filintomeireles@gmail.com");

            msg.Body = "Hola 3 desde VS 2017";
            msg.BodyEncoding = System.Text.Encoding.UTF8;
            msg.IsBodyHtml = true;
           /////////////////////////////////////////////////////////////////////////////
           

           /////////////////////// EMISOR //////////////////////////////////////////////
           ///
            //msg.From = new System.Net.Mail.MailAddress("filintomeireles@gmail.com");
            msg.From = new System.Net.Mail.MailAddress("meireles596@hotmail.com");
            System.Net.Mail.SmtpClient client = new System.Net.Mail.SmtpClient();
            //client.Credentials = new System.Net.NetworkCredential("filintomeireles@gmail.com","universo");
            client.Credentials = new System.Net.NetworkCredential("meireles596@hotmail.com", "");

           //////////////////////////////////////////////////////////////////////////////

            client.Port = 587;  // gmail y hotmail
          
            client.EnableSsl = true;

            //client.Host = "smtp.gmail.com";
            client.Host = "smtp.live.com";

            try
            {
                client.Send(msg);
            }
            catch(Exception)
            {
                MessageBox.Show("Error");
            }

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        static SpeechRecognitionEngine recEngine;
        private void Form1_Load(object sender, EventArgs e)
        {
            

 ///////////////////////////////////////////////////////////// ESCUCHAR Y RESPONDER AL USUARIO //////////////////////////////////////////////////////////
            SpeechRecognitionEngine rec = new SpeechRecognitionEngine();

            button5.Visible = false;
            button6.Visible = false;

            Choices lista = new Choices();
            lista.Add(new String[] { "amarelo", "azul" });

            //GrammarBuilder gb = new GrammarBuilder(lista);
            //gb.Culture = Thread.CurrentThread.CurrentCulture;


            Grammar gramatica = new Grammar(new GrammarBuilder(lista));


            try
            {
                //rec.SetInputToDefaultAudioDevice();
                rec.RequestRecognizerUpdate();
                rec.LoadGrammar(gramatica);
                rec.SpeechRecognized += reconocimiento;
                rec.RecognizeAsync(RecognizeMode.Multiple);

            }
            catch (Exception)
            {
                throw;
            }
        }

        // Application.Exit()



        void reconocimiento(object sender, SpeechRecognizedEventArgs e)
        {
            if (e.Result.Text =="amarelo")
            {
                button5.Visible = true;
          
            }
            else
                 if (e.Result.Text == "azul")
            {
            
                button6.Visible = true;
            }
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////// TEXTO A VOZ pt /////////////////////////////////////////////////////////////////////////////////

        // Boton Falar

        //Instalar:    =============================>      fuente: https://www.youtube.com/watch?v=Cwtt75DOR4Y  = http://codigologo.blogspot.com/
        //1. Microsoft Speech Platform Runtime
        //2.  Microsoft Speech SDK(bajar 86x) (https://download.microsoft.com/downlo...)~
        //3.Microsoft Speech Platform - Runtime Languages(Version 11) (https://www.microsoft.com/en-us/download/details.aspx?      id=27224)
        // 3.A-MSSpeech_TTS_pt-PT_Helia16k.msi
        //3.B   3.A-MSSpeech_SR_pt_TELE.msi

        //Configurar
        // activar antes System.Speech en =========> Menu, Proyect ====> Add References.. ===> Assemblies
        // activar Microsoft Speecht en ==============> Menu, Proyect ====> Add References.. ===> Browser y buscar =========> Programas 86X ===> Microsoft SDKs =====S Asamblies  ====>Microsoft Speech.dll
        // https://www.youtube.com/watch?v=1fVNGEG0w6I ,https://www.youtube.com/watch?v=LrYvUDnip6g

        private void button4_Click(object sender, EventArgs e)
        {
            Fala Speech = Fala.getInstance(ref button4);
            Speech.Velocidade = (int)trackBar2.Value;  /// Velocidad,Propiedades de TrackBar velocidad, Minimun -10 , Maximun 10 y TickFrecuency 5
            Speech.Volume = (int)trackBar1.Value;          /// volumen ,Propiedades de TrackBar volumen, Minimun 0 , Maximun 100, TickFrecuency 10, value 100


            if (string.IsNullOrWhiteSpace(richTextBox2.Text))
            {
                MessageBox.Show("Favor digitar o texto!");
                richTextBox2.Focus();
                return;
            }

            //Executar a síntese de voz
            Speech.Falar(richTextBox2.Text);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            richTextBox2.Clear();
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
