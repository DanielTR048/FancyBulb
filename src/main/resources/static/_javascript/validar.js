//Validação com REGEX
function validar_nome() {
    let value = document.getElementById("nome").value;
    // aceita a-z A-Z caracteres especiais - espaço
    let expressao = /^[a-zA-ZéúíóáÉÚÍÓÁèùìòàçÇÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ\-\ \s]+$/;
    if (!expressao.test(value)) {
      alert('Somente caracteres alfabéticos No nome');
      document.form.nome.focus();
      return false;
    }
    return true;
  }

  function validar(campo, valor_inicial , nome_campo )
{
	if (campo.value == "" || campo.value == null || valor_inicial == campo.value ) {
	    // campo inválido, retorna false para o formulário não ser submetido
	    alert('Conteúdo '+ nome_campo + ' não informado');	    
	    campo.focus();
	    return false;
  }
	    return true;
}

  function verificar_campos()
{
	let nome = document.getElementById("nome");	
	if(validar(nome,"","nome")==false)return false;

	let cpf = document.getElementById("cpf");	
	if(validar(cpf,"","cpf")==false)return false;

	let tel = document.getElementById("tel");
	if(validar(tel,"","Telefone")==false)return false;
    
	let cel = document.getElementById("cel");
	if(validar(cel,"","Celular")==false)return false;

	let cep = document.getElementById("cep");
	if(validar(cep,"","cep")==false)return false;
	
	let num = document.getElementById("num");
	if(validar(num,"","num")==false)return false;


	return true;

}


function validar_tudo() {      
	if(verificar_campos() == true && validar_nome() == true)
	{
        alert('voce enviou o formulario com sucesso');
		criarjson();
		return true;
	} else {
        alert('algo de errado nao esta certo');
          
        return false;
    }

  }


  function criarjson(){
  var obj = {

    nome: "",
	cpf: "",
	tel:"",
	cel:"",
	complemento: "",
	cep:[],

  }

  obj.nome = document.getElementById("nome").value;

  obj.cpf = document.getElementById("cpf").value;

  obj.cel = document.getElementById("cel").value;

  obj.tel = document.getElementById("tel").value;

  obj.complemento = document.getElementById("complemento").value;


  obj.cep.push(document.getElementById("cep").value);

  obj.cep.push(document.getElementById("rua").value);

  obj.cep.push(document.getElementById("bairro").value);

  obj.cep.push(document.getElementById("cidade").value);

  obj.cep.push(document.getElementById("uf").value);




  var json = JSON.stringify(obj);

  console.log(json);

  document.write("<h1>Dados em Json</h1>");

  document.write(json);

  return json;


}
