$(document).ready(function(){
    var isMobile = false;
    if (typeof window.orientation !== 'undefined'){
        isMobile = true;
    }

    /* BEGIN UTIL */
        function isOnScreen(element, offsetTop, offsetBottom) {
            if(offsetTop == undefined || offsetTop == null) offsetTop = 0;
            if(offsetBottom == undefined || offsetBottom == null) offsetBottom = 0;

            var win = $(window);
            var screenTop = win.scrollTop() + offsetTop;
            var screenBottom = screenTop + win.height() + offsetBottom;

            var elementTop = element.offset().top;
            var elementBottom = elementTop + element.height();

            var vertical = elementBottom > screenTop && elementTop < screenBottom;

            var screenLeft = win.scrollLeft();
            var screenRight = screenLeft + win.width();

            var elementLeft = element.offset().left;
            var elementRight = elementLeft + element.width();

            var horizontal = elementRight > screenLeft && elementLeft < screenRight;

            return vertical && horizontal;
        }

        function scrollToPosition(position, speed, transitar){
            if(transitar == undefined || transitar == null) transitar = true;
            
            var alturaTela = window.innerHeight - 75;
            var podeTransitar = ($(window).scrollTop() > alturaTela && position < alturaTela) ||
                                ($(window).scrollTop() < alturaTela && position > alturaTela);

            if($(window).scrollTop() != position){
                if(transitar && podeTransitar){
                    $("#viewaula").addClass("transitando");
                }
                $("body, html").clearQueue();
                $("body, html").animate({
                    scrollTop: position
                }, speed, function() {
                    canScroll = true;
                    $("#viewaula").removeClass("transitando");
                });
            }else{
                canScroll = true;
            }
        }

        telaFixa = false;

        function fixScreen(){
            if(!telaFixa){
                $("body").css("top", ($(window).scrollTop() * -1) + "px");
                if($(".action-menu")[0].floating){
                    $("body").addClass("fixScreen").delay(0).queue(function(){
                        $(".action-menu").css("top", "");
                        $("body").clearQueue();
                    });
                }else{
                    $("body").addClass("fixScreen");
                }
                telaFixa = true;
            }
        }

        function unfixScreen(){
            if(telaFixa){
                var top = $("body").offset().top * -1;
                $("body").removeClass("fixScreen");
                $(window).scrollTop(top);
                telaFixa = false;
            }
        }

        function initMenuFixer(){
            if($(".top-content-text").length > 0){
                var topMenu = $(".top-content-text").next().offset().top;
            }else{
                if($("#viewcomp").hasClass("devcast-page") && ($("#samba-video-include").length > 0 || $(".video-sem-acesso").length > 0)){
                    var topMenu = $(".page-body").offset().top + 60;
                }else{
                    var topMenu = $(".main-content .page-content-wrapper").children().first().offset().top;
                }
            }
    
            $(".action-menu").css("top", topMenu - 20);
            $(".action-menu").menuFixer(window.innerHeight*0.2, $(".page-info .page-content-wrapper"));
    
            $(".action-menu").removeClass("menu-hidden");
    
    
            let guiaurl = $(".saiba-mais-area").attr("data-url");
            if(guiaurl.length > 0){
                let leftSaibaMais = $(".page-content.main-content .page-content-wrapper")[0].getBoundingClientRect().right + 60;
        
                $(".saiba-mais-area").css({
                    "top": topMenu + 10,
                    "left": leftSaibaMais
                });
        
                //$(".saiba-mais-area").menuFixer(window.innerHeight*0.3, $(".page-content.page-content-buttons"));
        
                $(".saiba-mais-area").removeClass("menu-hidden");
                $(".saiba-mais-area").attr("href", guiaurl);
            }else{
                $(".saiba-mais-area").remove();
            }
        }

        function styleCodes(){
            var codes = $('div[class^="pre_"], div[class*=" pre_"], div[class^="code_"], div[class*=" code_"]');
    
            $.each(codes, function(i,e){
                var code = $(e);
                code.addClass("code-sample");

                /* var aux = $("<div class='code-sample-bg'></div>");
    
                setCodeBGPosition(code,  aux);
                
                code.attr("data-code-index", i);
                aux.attr("data-code-index", i);
    
            
                $("#viewcomp").append(aux); */
            });
        }
    
        function refreshCodesBG() {
            var codes = $(".code-sample");
            $.each(codes, function(i,e){
                var code = $(e);
                var aux = $(".code-sample-bg[data-code-index='" + code.data("code-index") + "']");
                setCodeBGPosition(code,  aux);
            });
        }
    
        function setCodeBGPosition(code,  bg){
            var top = code.offset().top;
            var height = code.height();
    
            bg.css("top", top + "px");
            bg.height(height);
        }
    
        function changeHeader(){
            if($(window).scrollTop() > 5){
                $(".header-site-devmedia, #viewcomp").addClass("viewcomp-bottom");
            }else{
                $(".header-site-devmedia, #viewcomp").removeClass("viewcomp-bottom");
            }
        }

        function refreshLead(){
            let box = $(".top-content-text .box_lead2");
            if(box.length > 0){
                let lines = box[0].scrollHeight / 25;
    
                if(lines > 4){
                    $(".top-content-text").addClass("oculto");
                }else{
                    $(".top-content-text").removeClass("oculto");
                }
    
                if($(".top-content-text").hasClass("active")){
                    $(".top-content-text .box_lead2").height($(".top-content-text .box_lead2")[0].scrollHeight);
                }else{
                    $(".top-content-text .box_lead2").height("");
                }
            }
        }
    
        function moveLead(){
            var leads = $(".box_lead2");
    
            if(leads.length > 0){
                var mainlead = leads[0];
                $(".main-content .page-content-wrapper").prepend("<div class='top-content-text'><span class='top-content-btn'><span class='top-content-label'>Ver mais</span> <span class='top-content-icon'><span class='icon-line1'></span><span class='icon-line2'></span></span></span></div>");
                $(".top-content-text").prepend(mainlead);
                $(".page-header, .main-content").addClass("top-content");
    
                refreshLead();
    
                $(".top-content-text .top-content-btn").click(function(){
                    if($(".top-content-text").hasClass("active")){
                        $(".top-content-text").removeClass("active");
                        $(".top-content-text .box_lead2").height("");
                        $(".top-content-text .top-content-btn .top-content-label").text("Ver mais");
                    }else{
                        $(".top-content-text").addClass("active");
                        $(".top-content-text .box_lead2").height($(".top-content-text .box_lead2")[0].scrollHeight);
                        $(".top-content-text .top-content-btn .top-content-label").text("Fechar");
                    }
                });
            }
        }

        function refreshDevcast(){
            let devcast = $("#samba-video-include, .video-sem-acesso");
            if(devcast.length > 0){
                let offset = devcast.height() / 2;
    
                if(devcast.hasClass("video-sem-acesso")){
                    var pBottom = offset + 40;
                    var mBottom = 20;
    
                    $(".devcast-page .page-header.top-content").css("margin-bottom", 20);
                }else{
                    var pBottom = offset + 50;
                    var mBottom = "auto";
    
                }
                
                $(".devcast-page .page-header.top-content").css("padding-bottom", pBottom);
                devcast.css({
                    top: offset*-1,
                    marginBottom: (offset - 40) * -1
                });
            }
        }
    
        function moveDevcast(){
            if($("#viewcomp").hasClass("devcast-page")){
                var devcast = $("#samba-video-include, .video-sem-acesso");
    
                if(devcast.length > 0){
                    $(".page-header, .main-content").addClass("top-content");
                    
                    refreshDevcast();
                }
            }
        }

        function resizeVideo(){
            var videos = $(".videoWrapper iframe");
            videos.each(function(i, e){
                var video = $(e);
    
                var newWidth = video.parent().width();
                var newheight = newWidth * 315 / 560;
    
                video.height(newheight);
                video.width(newWidth);
            });
            
            //refreshCodesBG();
        }

        if(typeof player != "undefined"){
            player.resizer.disableVideoResize();
        }
    /* END UTIL */


    changeHeader();
    moveLead();
    moveDevcast();
    resizeVideo();

    $(window).scroll(function(){
        changeHeader();
    });

    $(window).resize(function(){
        //refreshCodesBG();
        refreshLead();
        refreshDevcast();
        resizeVideo();
        $(".saiba-mais-area").css("left", $(".page-content.main-content .page-content-wrapper")[0].getBoundingClientRect().right + 60);
    });
    
    /* BEGIN MODAL */
        function abrirModal(conteudo){
            $(".modal-content").html(conteudo);

            fixScreen();
            $(".modal").fadeIn();
        }

        function fecharModal(){
            $(".modal").fadeOut(function(){
                if(!$("body").hasClass("mobile")){
                    unfixScreen(); 
                }
            });            
        }
        
        $(".modal-bg, .modal-icon-exit").on("click", function(e){
            fecharModal();
        });
    /* END MODAL */

    /* BEGIN MENU_ACAO */
        var urlValidar = "//www.devmedia.com.br/view/scripts/valida.php";
        $(".action-menu-item.like-button").on("click", function(e){
            var self = $(this)[0];
            if(self.waiting == true){
                return false;
            }else{
                self.waiting = true;
            }

            var id = $(this).data("id");

            $.ajax({
                url: "//www.devmedia.com.br/view/scripts/valida.php",
                method: "POST",
                data: { "funcao": "avaliarUtil", "comp": id, "util": 1},
                success: function(response){
                    if(response.status){
                        if(response.return > 0){
                            $(".like-button").removeClass("hidden-count");
                            $(".like-button .menu-icone-like-count").addClass("changing").delay(200).queue(function() {
                                $(".like-button .menu-icone-like-count").html(response.return);
                                $(".like-button").addClass("active");
                                $(this).removeClass("changing");
                                $(this).dequeue();
                            });
                        }else{
                            $(".like-button").addClass("hidden-count");
                        }
                    }else{
                        abrirModal(response.html);
                    }

                    self.waiting = false;
                },
                error: function(response){
                    console.log(response, true);
                    abrirModal("Ocorreu um erro!");
                    self.waiting = false;
                }
            });
        });

        $(".action-menu-item.fav-button").on("click", function(e){
            var self = $(this)[0];
            if(self.waiting == true){
                return false;
            }else{
                self.waiting = true;
            }

            var id = $(this).data("id");

            $.ajax({
                url: "//www.devmedia.com.br/view/scripts/valida.php",
                method: "POST",
                data: { "funcao": "favorito", "comp": id},
                success: function(response){
                    if(response.status){
                        $(".fav-button").addClass("active");
                    }else{
                        abrirModal(response.html);
                    }

                    self.waiting = false;
                },
                error: function(response){
                    console.log(response, true);
                    abrirModal("Ocorreu um erro!");
                    self.waiting = false;
                }
            });
        });

        $(".action-menu-item.comment-button").on("click", function(e){
            $("body, html").animate({
                scrollTop: $(".page-comment").offset().top - 85
            }, 600);
        });

        $(".action-menu-item.note-button").on("click", function(e){
            toggleMenuAnotacao();
        });

        $(".menu-anotacao-button-close").on("click", function(e){
            closeMenuAnotacao();
        });
        
        $(".finish-btn").on("click", function(e){
            var self = $(this)[0];
            if(self.waiting == true){
                return false;
            }else{
                self.waiting = true;
            }

            var lastText = $(".finish-btn .label").text();

            $(".finish-btn .label").text("Aguarde...");

            var id = $(this).data("id");

            $.ajax({
                url: "//www.devmedia.com.br/view/scripts/valida.php",
                method: "POST",
                data: { "funcao": "concluido", "comp": id},
                success: function(response){
                    if(response.status){
                        $(".finish-btn").addClass("active");
                        $(".finish-btn .label").text("Marcado como lido");
                        
                        if(response.return != true){
                            abrirModal(response.html);
                        }
                    }else{
                        abrirModal(response.html);
                        $(".finish-btn .label").text(lastText);
                    }

                    self.waiting = false;
                },
                error: function(response){
                    $(".finish-btn .label").text(lastText);
                    console.log(response, true);
                    abrirModal("Ocorreu um erro!");
                    self.waiting = false;
                }
            });
        });

        $(".download-btn").on("click", function(e){
            var self = $(this)[0];
            if(self.waiting == true){
                return false;
            }else{
                self.waiting = true;
            }

            var button = $(this);

            var lastText = button.text();
            button.text("Aguarde...");

            var id = $(this).data("id");

            var funcao = "donwload";
            
            if(button.hasClass("fontes")){
                var funcao = "fontes";
            }

            $.ajax({
                url: "//www.devmedia.com.br/view/scripts/valida.php",
                method: "POST",
                data: { "funcao": funcao, "comp": id, "curso": false},
                success: function(response){
                    if(response.status){
                        var link = document.createElement("a");
                        link.href = response.html;
                        link.target = "_blank";
                        document.body.appendChild(link);
                        link.click();
                        document.body.removeChild(link);
                        delete link;
                    }else{
                        abrirModal(response.html);
                    }

                    button.text(lastText);
                    self.waiting = false;
                },
                error: function(response){
                    console.log(response, true);
                    button.text(lastText);
                    self.waiting = false;
                    abrirModal("Ocorreu um erro!");
                }
            });
        });
    /* END MENU_ACAO */

    /* BEGIN ANOTACAO */
        if(false){ //cancelado
            anotacaoAberto = false;
            var anotacao = $(".anotacao-conteudo textarea[name=anotacao]");
            var anotacaoMaxHeight = 0;
            var lastAnotacao = anotacao.val();
            var lastSave = lastAnotacao;

            function obterModalAnotacao(funcao, comp, id , anotacao, modal, callback){
                if (id == undefined) id = null;
                if (anotacao == undefined) anotacao = null;
                if (callback == undefined) callback = null;

                if(lastSave != anotacao){
                    $(".action-menu-item.note-button").addClass("active saving");
                    $(".menu-anotacao-icone-editar").addClass("saving");

                    $.ajax({
                        url: "//www.devmedia.com.br/view/scripts/valida.php",
                        method: "POST",
                        data: { "funcao": funcao, "comp": comp, "id": id, "anotacao": anotacao},
                        success: function(response){
                            if(response.status){
                                if(modal === true){
                                    //abrirModal(response.html , true);
                                }
                                if(response.return != undefined){
                                    callback(response.return);
                                }else{
                                    callback();
                                }

                                lastSave = anotacao;
                            }else{
                                if(response.html.length > 0){
                                    abrirModal(response.html , true);
                                }
                            }
                        },
                        error: function(response){
                            console.log(response, true);
                            abrirModal("Ocorreu um erro", true);
                        }
                    });
                }
            }

            function editarAnotacaoBackground(){
                var conteudo = $(".anotacao-conteudo textarea[name=anotacao]").val();
                var comp = $(".anotacao-area").data("comp");

                obterModalAnotacao("salvarAnotacao", comp, null, conteudo, true, function(x){
                    if(x == 0){
                        $(".action-menu-item.note-button").removeClass("active saving saved");
                    }else{
                        $(".action-menu-item.note-button").removeClass("saving").addClass("active saved");
                    }
                    $(".menu-anotacao-icone-editar").removeClass("saving").addClass("saved");
                });
            }

            function closeMenuAnotacao(){
                editarAnotacaoBackground();
                $("#viewcomp").removeClass("menu-anotacao-aberto");
                if(location.hash == "#menu-aberto")
                    history.replaceState("", document.title, window.location.href.replace(window.location.hash, ""));
                anotacaoAberto = false;
            }
            
            function openMenuAnotacao(){
                if($("#menu-anotacao").attr("off") == undefined){
                    $("#viewcomp").addClass("menu-anotacao-aberto");
                    location.hash = "menu-aberto";
                    anotacaoAberto = true;
                }else{
                    abrirModal("Voc&ecirc; precisa estar logado para realizar essa a&ccedil;&atilde;o. <br> <a target='_blank' href='https://www.devmedia.com.br/login/login.asp'>Clique aqui para logar.</a>");
                }
            }

            function toggleMenuAnotacao(){
                if($("#viewcomp").hasClass("menu-anotacao-aberto")){
                    closeMenuAnotacao();
                }else{
                    openMenuAnotacao();
                }
            }

            function resizeAnotacoes(){
                var ofs = window.innerWidth > 768 ? 25 : 65;
                anotacaoMaxHeight = (window.innerHeight -  $(".anotacao-conteudo")[0].getBoundingClientRect().top) - ofs;
                $(".anotacao-conteudo").css("max-height",anotacaoMaxHeight);

                var st = 0;
                if(document.getSelection().anchorNode != null){
                    st = document.getSelection().anchorNode.scrollTop;
                }
                
                anotacao.height("");
                var newSH = anotacao[0].scrollHeight + 40; // > anotacaoMaxHeight? anotacaoMaxHeight : anotacao[0].scrollHeight;
                anotacao.height(newSH);

                $(".anotacao-conteudo").scrollTop(st);
            }

            $(".menu-anotacao-icone-editar").on("click", function(e){
                editarAnotacaoBackground();
            });

            anotacao.on("keyup scroll", function(e){
                if(lastAnotacao != anotacao.val()){
                    resizeAnotacoes();
                    lastAnotacao = anotacao.val();
                    $(".action-menu-item.note-button, .menu-anotacao-icone-editar").removeClass("saved");
                }
            });

            resizeAnotacoes();
        }
    /* END ANOTACAO */

    var devslider;
	if($("#devslider").length > 0){
		function runSlider() {	
			var sliderTags = $.find("[id='slide-comp']");
			$(sliderTags).each(function(i,e){
				$(e).addClass("slider-box");
			});
			
			devslider = new DevSlider(".slider-box");
		}

		if(typeof DevSlider == "undefined"){	
			$("#devslider")[0].onload = runSlider;
		}else{	
			runSlider();
		}
	}

    var pulseStarted = false;

    function pulseButtons(){
        if(!pulseStarted && $(".btn-ir-cod-font").length > 0){
            if(isOnScreen($(".btn-ir-cod-font"))){
                $(".btn-ir-cod-font").addClass("pulse");
                pulseStarted = true;  
            }
        }
    }

    $(window).on("scroll", function(){
        pulseButtons();
    });
    
    pulseButtons();

    if($("code").length > 0){
        if($("code .syntaxhighlighter").length > 0){
            styleCodes();
        }else{
            var codeInterval = setInterval(function(){
                if($("code .syntaxhighlighter").length > 0){
                    styleCodes();
                    clearInterval(codeInterval);
                }
            }, 100);
        }
    }

    if (typeof $.fn.menuFixer != "undefined"){
        initMenuFixer();
    }else{
        if($("#utilscript").length > 0){
            $("#utilscript")[0].onload = initMenuFixer;
        }
    }
});