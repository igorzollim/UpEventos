class CadastroView{
  constructor(base){
    this.base = base;

    let labelNome = document.createElement("label");
    labelNome.innerText = "Nome do Evento: "
    let inputNome = document.createElement("input");
    labelNome.setAttribute("style", "position:absolute; top:24%; left:3%;")
    inputNome.setAttribute("style", "position:absolute; top:24%; left:16%; width:295px")

    let labelIngresso = document.createElement("label");
    labelIngresso.innerText = "Valor da Entrada: "
    let inputIngresso = document.createElement("input");
    inputIngresso.setAttribute("type", "number");
    labelIngresso.setAttribute("style", "position:absolute; top:30%; left:3%;")
    inputIngresso.setAttribute("style", "position:absolute; top:30%; left:16%; width:80px")

    let labelData = document.createElement("label");
    labelData.innerText = "Data: "
    let inputData = document.createElement("input");
    inputData.setAttribute("type", "date");
    labelData.setAttribute("style", "position:absolute; top:42%; left:3%;")
    inputData.setAttribute("style", "position:absolute; top:42%; left:16%;width:120px")


    let labelFaixa = document.createElement("label");
    labelFaixa.innerText = "Faixa etária: "
    let inputFaixa = document.createElement("input");
    inputFaixa.setAttribute("type", "number");
    inputFaixa.setAttribute("style", "position:absolute; top:30%; left:37%; width:80px")
    labelFaixa.setAttribute("style", "position:absolute; top:30%; left:27%;")

    let labelHoraA = document.createElement("label");
    labelHoraA.innerText = "Hora de abertura: "
    let inputHoraA = document.createElement("input");
    inputHoraA.setAttribute("type", "time");
    labelHoraA.setAttribute("style", "position:absolute; top:36%; left:3%;")
    inputHoraA.setAttribute("style", "position:absolute; top:36%; left:16%;")


    let labelHoraF = document.createElement("label");
    labelHoraF.innerText = "Término: "
    let inputHoraF = document.createElement("input");
    inputHoraF.setAttribute("type", "time");
    labelHoraF.setAttribute("style", "position:absolute; top:36%; left:30%;")
    inputHoraF.setAttribute("style", "position:absolute; top:36%; left:38%;")

    let labelDesc = document.createElement("label");
    labelDesc.innerText = "Descrição do evento: "
    let textDesc = document.createElement("textarea");
    labelDesc.setAttribute("style", "position:absolute; top:70%; left:3%;");
    textDesc.setAttribute("style", "position:absolute; top:74%; left:14%;")

    let labelTags = document.createElement("label");
    labelTags.innerText = "Tags: "
    let inputTags = document.createElement("input");
    labelTags.setAttribute("style", "position:absolute; top:42%; left:30%;")
    inputTags.setAttribute("style", "position:absolute; top:42%; left:34%;")

    let labelBebidas = document.createElement("label");
    labelBebidas.innerText = ">O evento vai ter bebidas alcoolicas? ";
    labelBebidas.setAttribute("style", "position:absolute; top:52%; left:3%;")


    let radioBebidasSim = document.createElement("input");
    radioBebidasSim.setAttribute("name", "bebidas");
    radioBebidasSim.setAttribute("type", "radio");
    let labelSim = document.createElement("label");
    labelSim.innerText = "Sim";
    labelSim.setAttribute("style", "position:absolute; top:52%; left:31%;")
    radioBebidasSim.setAttribute("style", "position:absolute; top:52%; left:33%;")


    let radioBebidasNao = document.createElement("input");
    radioBebidasNao.setAttribute("name", "bebidas");
    radioBebidasNao.setAttribute("type", "radio");
    let labelNao = document.createElement("label");
    labelNao.innerText = "Não";
    labelNao.setAttribute("style", "position:absolute; top:52%; left:35%;")
    radioBebidasNao.setAttribute("style", "position:absolute; top:52%; left:37%;")

    //inputBebidasSim.checked se selecionado retorna true.

    let labelPista = document.createElement("label");
    labelPista.innerText = ">Os participantes terão acesso à pista de dança? ";
    labelPista.setAttribute("style", "position:absolute; top:58%; left:3%;")

    let radioPistaSim = document.createElement("input");
    radioPistaSim.setAttribute("name", "pista");
    radioPistaSim.setAttribute("type", "radio");
    let labelSim2 = document.createElement("label");
    labelSim2.innerText = "Sim";
    radioPistaSim.setAttribute("style", "position:absolute; top:58%; left:42%;")
    labelSim2.setAttribute("style", "position:absolute; top:58%; left:40%;")

    let radioPistaNao = document.createElement("input");
    radioPistaNao.setAttribute("name", "pista");
    radioPistaNao.setAttribute("type", "radio");
    let labelNao2 = document.createElement("label");
    labelNao2.innerText = "Não";
    radioPistaNao.setAttribute("style", "position:absolute; top:58%; left:47%;")
    labelNao2.setAttribute("style", "position:absolute; top:58%; left:45%;")

    let labelMusica = document.createElement("label");
    labelMusica.innerText = "Estilo musica: ";

    let listaMusical = document.createElement("select");

    let opt0 = document.createElement("option");
    opt0.value = "0";
    opt0.text = "Nenhum";
    listaMusical.add(opt0, listaMusical.options[0]);

    let opt1 = document.createElement("option");
    opt1.value = "1";
    opt1.text = "Sertanejo";
    listaMusical.add(opt1, listaMusical.options[1]);

    let opt2 = document.createElement("option");
    opt2.value = "2";
    opt2.text = "Variado";
    listaMusical.add(opt2, listaMusical.options[2]);

    let opt3 = document.createElement("option");
    opt3.value = "3";
    opt3.text = "Pop";
    listaMusical.add(opt3, listaMusical.options[3]);

    labelMusica.setAttribute("style", "position:absolute; top:64%; left:3%;");
    listaMusical.setAttribute("style", "position:absolute; top:64%; left:14%;")

    //alert(listaMusical.options[listaMusical.selectedIndex].text)

    let labelComida = document.createElement("label");
    labelComida.innerText = "Tipo de Comida: "
    let inputComida = document.createElement("input");
    labelComida.setAttribute("style", "position:absolute; top:64%; left:25%;");
    inputComida.setAttribute("style", "position:absolute; top:64%; left:38%;")

    this.labelID = document.createElement("label");
    this.labelID.innerText = "ID do evento: "
    this.inputID = document.createElement("input");
    this.labelID.setAttribute("style", "position:absolute; top:72%; left:35%;");
    this.inputID.setAttribute("style", "position:absolute; top:72%; left:45%;width:70px")

    let cadastrar = document.createElement("button");
    cadastrar.innerText = "Cadastrar evento";
    cadastrar.setAttribute("style", "position:absolute; top:88%; left:25%;");

    this.editar = document.createElement("button");
    this.editar.innerText = "Editar evento";
    this.editar.setAttribute("style", "position:absolute; top:88%; left:45%;");

    this.apagar = document.createElement("button");
    this.apagar.innerText = "Apagar evento";
    this.apagar.setAttribute("style", "position:absolute; top:88%; left:6%;");

    this.apagar.onclick=()=>{
      base.appendChild(this.inputID);
      base.appendChild(this.labelID);
      this.apagar.innerText = "Confirmar exclusão";

      this.apagar.onclick=()=>{
          this.apagarEvento(this.inputID.value);
      }

    }
    this.editar.onclick=()=>{
      base.appendChild(this.inputID);
      base.appendChild(this.labelID);
      this.editar.innerText = "Confirmar edição"

      this.editar.onclick=()=>{
        let evento={
          id:this.inputID.value,
          nome:inputNome.value,
          valor_entrada:parseFloat(inputIngresso.value),
          faixa_etaria:parseInt(inputFaixa.value),
          horario_abertura:inputHoraA.value,
          horario_fechamento: inputHoraF.value,
          data: this.dataFormatadaSQL(inputData.value),
          tags:inputTags.value,
          desc_evento:textDesc.value,
          temas:[{
            bebida_alcoolica: (radioBebidasSim.checked) ? true : false,
            pista_danca:(radioPistaSim.checked)? true : false,
            estilo_musical: listaMusical.options[listaMusical.selectedIndex].text,
            tipo_comida: inputComida.value
          }]
        };

        this.editarEvento(evento);
      }
    }

    cadastrar.onclick=()=>{
      if (radioBebidasNao.checked == false & radioBebidasSim.checked == false ||
          radioPistaSim.checked == false & radioPistaNao.checked == false){
        alert('As perguntas SIM/NÃO são obrigatórias!')
      }else{
          console.log(inputData.value);
        let evento={
          nome:inputNome.value,
          valor_entrada:parseFloat(inputIngresso.value),
          faixa_etaria:parseInt(inputFaixa.value),
          horario_abertura:inputHoraA.value,
          horario_fechamento: inputHoraF.value,
          data: this.dataFormatadaSQL(inputData.value),
          tags:inputTags.value,
          desc_evento:textDesc.value,
          temas:[{
            bebida_alcoolica: (radioBebidasSim.checked) ? true : false,
            pista_danca:(radioPistaSim.checked)? true : false,
            estilo_musical: listaMusical.options[listaMusical.selectedIndex].text,
            tipo_comida: inputComida.value
          }]
        };

        this.cadastrar(evento);

      }


    }

    let voltar = document.createElement("button");
    voltar.innerText = "Up Eventos";
    voltar.setAttribute("style", "position:absolute; top:50%; left:80%;")
    voltar.onclick=()=>{
      window.location.href = "http://localhost:8080/";
    }


    base.appendChild(labelTags); base.appendChild(labelData);
    base.appendChild(labelDesc); base.appendChild(labelIngresso);
    base.appendChild(inputIngresso);base.appendChild(labelNome);
    base.appendChild(labelFaixa);base.appendChild(labelHoraA);
    base.appendChild(labelHoraF); base.appendChild(labelPista);
    base.appendChild(labelMusica); base.appendChild(labelComida);
    base.appendChild(labelBebidas);base.appendChild(inputData);
    base.appendChild(inputTags);base.appendChild(inputNome);
    base.appendChild(inputFaixa);base.appendChild(inputHoraA);
    base.appendChild(inputHoraF);base.appendChild(inputComida);
    base.appendChild(radioPistaNao); base.appendChild(radioPistaSim);
    base.appendChild(radioBebidasSim);  base.appendChild(labelSim);
    base.appendChild(labelSim2);base.appendChild(labelNao2);
    base.appendChild(labelNao);  base.appendChild(radioBebidasNao);
    base.appendChild(listaMusical);base.appendChild(textDesc);
    base.appendChild(cadastrar);base.appendChild(this.editar);
    base.appendChild(this.apagar);base.appendChild(voltar);


  }

  editarEvento(evento){
      let eventoJson = JSON.stringify(evento);
      fetch("/alteraEvento?id="+evento.id,{
        method:"POST",
        headers:{
          'Content-Type':'application/json'
        },
        body:eventoJson
      }).then(
        (resultado)=>{
          if(resultado.ok){
            alert('Evento editado!')
            this.base.removeChild(this.labelID);
            this.base.removeChild(this.inputID);
            this.editar.innerText="Editar Evento";
          }else{
            resultado.json().then(
              (erro)=>alert(erro.message)
            )
          }
        }
      );
  }

  apagarEvento(id){
    fetch("/excluiEvento?id="+id).then(
      (resultado)=>{
        if(resultado.ok){
          alert('Evento apagado!');
          this.base.removeChild(this.labelID);
          this.base.removeChild(this.inputID);
          this.apagar.innerText="Apagar Evento";
        }
      }
    );
  }

  cadastrar(evento){
    let eventoJson = JSON.stringify(evento);
    console.log(evento);
    console.log(eventoJson);
    fetch("/insereEvento",{
      method:"POST",
      headers:{
        'Content-Type' : 'application/json'
      },
      body:eventoJson
    }).then(
      (resultado)=>{
        if(resultado.ok){
          alert('Evento registrado!')
            window.location.href = "http://localhost:8080";
        }else{
          resultado.json().then(
            (erro)=>alert(erro.message)
          )
        }
      }
    );
  }

  dataFormatadaSQL(dataSQL){

    if(dataSQL == ""){
      return "";
    }

    let data = new Date(dataSQL);

    let dia  = (parseInt(data.getDate())+2).toString();
    let diaF = (dia.length == 1) ? '0'+dia : dia;
    let mes  = (data.getMonth()+1).toString();
    let mesF = (mes.length == 1) ? '0'+mes : mes;
    let anoF = data.getFullYear();
    return anoF+"-"+mesF+"-"+diaF;

}
}
