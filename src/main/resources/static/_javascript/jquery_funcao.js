//Construção do efeito ACCORDION (ACORDEON) do JQUERY UI
$(function() {
  $( "#acordeon" ).accordion({
      active: false, 
      collapsible: true
  });


//VALIDAÇÃO JQUERY IGUAL DO MATERIAL SOMENTE PARA O NOME
$( "#form" ).validate({   	debug: true,
rules: {
   nome: {        required: true  }	,	
   email: { required: true},
   senha: { required: true}
},
messages: {
    nome, email, senha: {
        required: "<li>Por favor entre com seu Nome.</li>"
      },

      
}
  }); // fechamento do validate



//VALIDAÇÃO COM JQUERY

// a  Representa caracteres alfabéticos (letras) (A-Z,a-z)
// a  Porém 'a' não permite acentuação nem ç 
// 9  Representa caracteres numéricos (números) (0-9)
// *  Representa caracteres alfanuméricos (letras e números) (A-Z,a-z,0-9)
// Uso do ? transforma o caracter seguinte opcional

 //Mascara para CPF com o .class
 $('.mask-cpf').mask('999.999.999-99'); 

 //Mascara para o Celular com o seletor ID, 
 // recebe 8 ou 9 digitos
 $("#cel").mask("(99)9999?9-9999");
 $("#tel").mask("(99)9999-9999");
 $("#cep").mask("99999-999");

 //Mascara para Salario - valores monetários
 $('#salario').maskMoney({showSymbol:true,symbol:'R$ ', 
   decimal:',', thousands:'.', allowZero:true}); 

});