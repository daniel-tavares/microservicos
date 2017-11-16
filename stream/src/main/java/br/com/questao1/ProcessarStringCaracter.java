package br.com.questao1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* QUESTAO 1
 * Dada uma stream, encontre o primeiro caractere Vogal, após uma consoante, 
 * onde a mesma é antecessora a uma vogal e que não se repita no resto da stream. 
 * O termino da leitura da stream deve ser garantido através do método hasNext(), 
 * ou seja, retorna falso para o termino da leitura da stream. 
 * Voce tera acesso a leitura da stream através dos métodos de interface fornecidos ao termino do enunciado. (15 pontos)
 * 
 * 
 */
public class ProcessarStringCaracter {

	private static final List<Character> vogais=Arrays.asList('a','e','i','o','u');
	
	public static char processar(Stream input){
		final Map<Character, Boolean> caracteresValidos= new HashMap<Character, Boolean>();
		
		char caracterPesquisadoMenosUmaPosicao = 0,
		     caracterPesquisadoMenosDuasPosicoes=0;
	
		while (input.hasNext()) {
			

			char caracterPesquisado = input.getNext();
			System.out.println(caracterPesquisado);
			if ( isVogal(caracterPesquisadoMenosDuasPosicoes) && 
			    !isVogal(caracterPesquisadoMenosUmaPosicao) &&  
			     isVogal(caracterPesquisado)  
			   ) {
				
				 if(caracteresValidos.containsKey(caracterPesquisado))
					 caracteresValidos.put(caracterPesquisado,false);
				 else
					 caracteresValidos.put(caracterPesquisado,true);
			}
		
			caracterPesquisadoMenosDuasPosicoes=caracterPesquisadoMenosUmaPosicao;
			caracterPesquisadoMenosUmaPosicao=caracterPesquisado;
		}		

		
		return caracteresValidos.entrySet().stream().filter(Entry::getValue).findFirst().map(Map.Entry::getKey).orElse(' ');
	}

	private static boolean isVogal(char c) {
		return vogais.contains(c);
	}
	
	public static void main(String[] args) {
		Stream stream=new StreamImpl("aAbBABacafe");
		char valor=ProcessarStringCaracter.processar(stream);
		System.out.println(valor);
	}

}