using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.Speech.Synthesis;

namespace WhatsappVoxEmail
{
    public class Fala
    {
        private static Fala GerenciaInstancia = null;
        private static object objLock = new object();
        private static Button refBotao = null;

        public int Volume { get; set; }
        public int Velocidade { get; set; }


        SpeechSynthesizer SpeechEngine = new SpeechSynthesizer();

        public void Falar(string strTexto)
        {
            SpeechEngine.Rate = this.Velocidade;
            SpeechEngine.Volume = this.Volume;

            SpeechEngine.StateChanged += SpeechEngine_StateChanged;

            if (!string.IsNullOrWhiteSpace(strTexto))
            {
                switch (SpeechEngine.State)
                {
                    case SynthesizerState.Ready:
                        SpeechEngine.SetOutputToDefaultAudioDevice();  //Definindo o dispositivo padrão de reprodução da síntese.
                        SpeechEngine.SpeakAsync(strTexto);
                        break;
                    case SynthesizerState.Speaking:
                        SpeechEngine.Pause();
                        break;
                    case SynthesizerState.Paused:
                        SpeechEngine.Resume();
                        break;
                }
            }
        }

        void SpeechEngine_StateChanged(object sender, StateChangedEventArgs e)
        {
            switch (e.State)
            {
                case SynthesizerState.Ready:
                    refBotao.Text = "Falar";
                    break;
                case SynthesizerState.Speaking:
                    refBotao.Text = "Pausar";
                    break;
                case SynthesizerState.Paused:
                    refBotao.Text = "Continuar";
                    break;
            }
        }

        public static Fala getInstance(ref Button Botao)
        {
            lock (objLock)
            {
                if (GerenciaInstancia == null)
                {
                    GerenciaInstancia = new Fala();
                    refBotao = Botao;
                }

                return GerenciaInstancia;
            }
        }

    }
}
