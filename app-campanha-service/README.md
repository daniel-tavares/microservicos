# DOCUMENTACAO



## Arquitetura e Padrões

A aplicação foi desenvolvida baseando-se na arquitetura de microservicos com spring boot. Microservico são sistemas distribuídos que usam muitos conceitos e práticas do SOA. Eles se diferem, entretanto, no escopo da responsabilidade dada para cada serviço individualmente.

- **Banco de dados:** Foi utilizado o banco de dados **H2** em memória para o desenvolvimento do projeto.

- **Persistencia:** Foi utilizado o **JPA** em conjunto com o **Hibernate** para a persistencia dos dados.

- **DAO:** padrão de interface que abstrai o acesso aos dados 

- **Padrões HTTP:** REST é baseado no protocolo HTTP, é importante seguir os padrões definidos por ele e aplicá-los onde eles fazem sentido, por exemplo, nos status code de retorno de um método.

- **Padrão URI:** Foi utilizado substantivos e não verbos ou nomes de métodos conforme o padrão a exigencia do padrão RESTful.

- **Gerenciameto unico de configuração:** 

- **API Gateway**
   
 

## Mocks

	Mocks foram criados para testar os serviços implementados. Para criação dos mocks foiutilizada a biblioteca Mockito em conjundo com o junit.



# MicroService:  app-campanha-service


## Cadastro de campanhas

**REQUISITO 1:** As campanhas deverão ser cadastradas de forma que o serviço retorne essas campanhas seguindo a estrutura abaixo:
	o	Nome Da Campanha;
	o	ID do Time do Coração;
	o	Data de Vigência
    
**REQUISITO 2:** No cadastramento de uma nova campanha, deve-se verificar se já existe uma campanha ativa para aquele período (vigência), caso exista uma campanha ou N campanhas associadas naquele período, o sistema deverá somar um dia no término da vigência de cada campanha já existente. Caso a data final da vigência seja igual a outra campanha, deverá ser acrescido um dia a mais de forma que as campanhas não tenham a mesma data de término de vigência   

**REQUISITO 3: ** As campanhas deveram ser controladas por um ID único

##

 

#### Cadastrando uma nova campanha
	
    Método: POST
    URL: http://localhost:8000/v1/campanhas
    JSON-ENVIO:
     {
   		 "nome": "Nome da campanha 1",
  		 "idTime": 1,
   		 "dataInicioVigencia": "01/03/2017",
  	     "dataFimVigencia":"01/12/2017"
	  }
   
  	JSON-RETORNO:
    
     {
   		 "id": 1,
   		 "nome": "Nome da campanha 1",
   		 "idTime": 1,
    	 "dataInicioVigencia": "01/03/2017",
    	 "dataFimVigencia": "01/12/2017"
	 }
       




## Atualização de campanha

**REQUISITO 1:**	No caso de uma nas campanhas já existentes, o sistema deverá ser capaz de fornecer recursos para avisar outros sistemas que houve alteração nas campanhas existentes;

##

#### Atualizando campanha

    Método: PUT
	URL: http://localhost:8000/v1/campanhas
	JSON-ENVIO E RETORNO: 
	   {
          "id": 5,
          "nome": "Nome do Campanha 3",
          "idTime": 1,
          "dataInicioVigencia": "01/11/2012",
          "dataFimVigencia": "15/11/2017"
       }

  

## Exclusão de campanha

**REQUISITO 1:** A deleção deve ser feita pelo ID;

##


#### Excluindo uma campanha
 
 	Método: DELETE
    URL: http://localhost:8000/v1/campanhas/{idCampanha}
    PARAM: idCampanha
    JSON-RETORNO:
      **Campanha excluida
      {
   		  "id": 3,
  		  "nome": "Nome do Campanha 1",
          "idTime": 1,
          "dataInicioVigencia": "01/06/2016",
          "dataFimVigencia": "01/06/2017"
	  }


## Associação entre usuário e campanha

**REQUISITO 1:** Se for usuário novo: Após o cadastramento do usuário, o sistema deverá solicitar as campanhas ativas para aquele time do coração e efetuar a associação;

**REQUISITO 2:** Se for um usuário já cadastrado: Deverá ser feita a associação das campanhas novas, ou seja, as que o usuário daquele time do coração não tem relacionamento até o momento.

**OBS:** 
- O Consumo das listas das campanhas deve ser feita via Serviço exposto conforme descrito no exercício anterior;
- O	cadastramento das campanhas deverá ser feito via Serviço (API, conforme descrito no exercício anterior)

##

#### Consultando campanhas Ativas para o Time do Usuario
 
	   Metodo: GET
	   URL: http://localhost:8000/v1/campanhas/time/{idTime}
	   Param: idTime  

#### Consulta todas as campanhas ativas e não associadas ao usuario
      
      Método: GET
      URL: http://localhost:8000/v1/campanhas/semAssociacaoUsuario/{idUsuario}/time/{idTime}
      Param1: {idUsuario}
      Param2: {idTime}


#### Realiza a associação entre Usuario e campanha
 
      Metodo: POST
	  URL: http://localhost:8000/v1/campanhaUsuario/associacao
	  JSON ENVIO E RETORNO:
       {
   		 "usuario": 1,
  		 "campanhas":[2,3,4]
	   }





# MicroService:  app-usuario-service
	

## Cadastro de usuario 
  
  **REQUISITO 1:** Dado um E-mail que já existe, informar que o cadastro já foi efetuado, porém, caso o cliente não tenha nenhuma campanha associada, o serviço deverá enviar as novas campanhas como resposta
  
  **REQUISITO 2:** O Cadastro deve ser composto de: Nome Completo; E-mail;
	-	Data de Nascimento;Meu Time do Coração;

  **REQUISITO 3:** O Cliente não pode ter mais de um cadastro ativo
  
  **REQUISITO 4:** Ao efetuar o cadastro do usuário, utilize os serviços criados anteriormente para efetuar as operações e as associações necessárias 
  
  **REQUISITO 5:** O Cadastramento do cliente ocorre antes da associação com as campanhas, ou seja, o processo de cadastro e associação ocorre em dois momentos separados
##

#### Cadastrar um novo usuario ou cliente

	Metodo: POST
	URL: http://localhost:9000/v1/usuarios
	JSON-ENVIO:
   		{
   		   "nome": "Daniel",
    	   "email": "danieltavares.web@gmail.com",
    	   "dataNascimento": "01/11/2012",
    	   "idTime": 1,
    	}
    
    JSON-RETORNO:
         
        **QUANDO NAO EXISTIR** 
		{
    	    "id": 2,
   			"nome": "Daniel",
    	    "email": "danieltavares.web@gmail.com",
    	    "dataNascimento": "01/11/2012",
    		"idTime": 1,
    		"situacao": "ATIVO"
		}


       ** QUANDO NÃO EXISTIR RECUPERA TODAS AS CAMPANHAS ATIVAS ** 
       [
          {
              "id": 1,
              "nome": "Nome do Time 1",
              "idTime": 1,
              "dataInicioVigencia": "01/11/2017",
              "dataFimVigencia": "04/12/2017"
          },
          {
              "id": 2,
              "nome": "Nome do Time 1",
              "idTime": 1,
              "dataInicioVigencia": "01/11/2017",
              "dataFimVigencia": "03/12/2017"
          },
	   ]
       
       
        **QUANDO EXISTIR E NAO TIVER CAMPANHAS ATIVAS**
        {
    		"status": 302,
    	    "title": "Já cadastrado.",
    	    "message": "Recurso já foi cadastrado.",
    	    "timestamp": 1510671717601,
    	    "developerMessage": 	"br.com.usuario.exceptions.ResourceFoundException"
		}




## Falhas de Integração
 **REQUISITO 1:** A aplicação deverá prever falhas de integração entre as APIs, não deixando o cliente sem nenhuma resposta;
 
 **REQUISITO 2:** O Cadastramento não pode ser influenciado pelo serviço das campanhas, caso o serviço das campanhas não esteja “UP”;
##

	Foi utilizado o projeto Feign para contornar problemas de comunicação causado por queda de serviço. Este projeto permite a utilização de fallbacks para prover um comportamento padrão para o fluxo. O fallback é muito utilizado em  arquitetura de micro serviços onde temos que nos integrar com diversos serviços para que a aplicação como um todo funcione. 



## Escalabilidade

**REQUISITO** O Serviço será acessado de forma acentuada, ou seja, a previsão é que o serviço receba 100 requisições por segundo;

##

	Para atender um grande numero de usuários a aplicação foi construida com base na arquitetura de microservicos que são soluções mais rápidas, seguras, altamente escaláveis e que não enfrentavam os problemas de uma arquitetura monolitica gerada pelo alto acoplamento.

	A principal ideia do microserviço é construir serviços que sejam pequenos, independentes e focados na resolução de um único problema dentro de um ecossistema de uma aplicação. Suas principais características são: alta coesao(único foco), reajam as falhas, autonomos e focado no negócio. 



# STREAM

