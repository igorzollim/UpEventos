class EventoView{
  constructor(base){
    this.base = base;

    let botao = document.createElement("button");
    botao.innerText = "Cadastrar Eventos";
    botao.onclick=()=>{
      window.location.href = "http://localhost:8080/cadastrarEvento.html";
    }



    base.appendChild(botao);

    //tabela
    this.tabela= document.createElement("table");

    const cabecalho = this.tabela.insertRow();
    cabecalho.setAttribute("style", "padding-top: 12px; padding-bottom: 12px; text-align: left; background-color: #f0932b;color: white;");


    const cellNome = cabecalho.insertCell();
    cellNome.innerText="Nome do Evento";

    const cellDescricao= cabecalho.insertCell();
    cellDescricao.innerText="Descrição";

    const cellInformacoes= cabecalho.insertCell();
    cellInformacoes.innerText="Informações";

    this.tabela.border = 1;
    this.tabela.style.border= "3px solid black";
    this.tabela.setAttribute("style", "margin-left:14%; border: 1px solid black;border-collapse: collapse;");
    this.tabela.style.background = "#f2f2f2";
    this.tabela.style.position = "absolute";
    this.tabela.style.top = "50%";
    this.tabela.style.width = "1200px";

    let buscar = document.querySelector("#buscar");
    let temas = document.querySelector("#temas");

    buscar.onclick =()=>{
      this.listar(temas.value.toString());
    }
  }

  listar(tags) {
    this.base.appendChild(this.tabela);

    //lista os eventos
        fetch("/pesquisaEventos?tagsBusca="+tags).then(
            (resultado)=>resultado.json().then(
                (eventos)=>this.setEventos(eventos)
            )
        );
    }

    dataAtualFormatada(dataSQL){
        let data = new Date(dataSQL);

        let dia  = (data.getDate()+1).toString();
        let diaF = (dia.length == 1) ? '0'+dia : dia;
        let mes  = (data.getMonth()+1).toString();
        let mesF = (mes.length == 1) ? '0'+mes : mes;
        let anoF = data.getFullYear();
    return diaF+"/"+mesF+"/"+anoF;
  }

  horaAtualFormatada(horaSQL){
    let arrayHora = horaSQL.split(":");
    let hora = arrayHora[0] + ":" + arrayHora[1];
    return hora;
  }

    setEventos(eventos) {
        this.eventos=eventos;

        while(this.tabela.rows.length>1)
            this.tabela.rows[1].remove();

        for (let index = 0; index < eventos.length; index++) {
            const evento = eventos[index];

            let linha = this.tabela.insertRow();

            let cellNome= linha.insertCell();
            cellNome.innerText=evento.nome;

            let cellDescricao= linha.insertCell();
            cellDescricao.innerText=evento.desc_evento;

            let temas = evento.temas;
            let cellInformacoes= linha.insertCell();
            let str ="";

            //Concatenando as informações do evento
            for (let i = 0; i < temas.length;i++){

              str = ">Data: " +this.dataAtualFormatada(evento.data) + "  "+this.horaAtualFormatada(evento.horario_abertura)+ "-"+this.horaAtualFormatada(evento.horario_fechamento)+
              "\n>Ingresso: R$"+evento.valor_entrada+
              "\n>Faixa etária: +"+evento.faixa_etaria+
              "\n>Tipo de comida: "+temas[i].tipo_comida;

              if(temas[i].bebida_alcoolica){
                str = str + " com acesso à bebidas alcoolicas.";
              }

              str = str + "\n>Estilo musical: " +temas[i].estilo_musical;

              if(temas[i].pista_danca){
                str = str + " com acesso à pista de dança.";
              }
            }
            cellInformacoes.innerText=str;
        }
    }
}
