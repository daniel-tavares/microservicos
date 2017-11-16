package br.com.questao1.stream;


public class StreamImpl implements Stream {

	private String valor;
	private int tamanhoMaximo;
	private int posicaoAtual;
    private boolean isCaractere;
    private boolean isprimeiroAcesso;
	
	public StreamImpl(String valor) {
		this.valor=valor;
		this.tamanhoMaximo=valor.length();
	    this.isprimeiroAcesso=true;
	    if(tamanhoMaximo>0) 
	    	isCaractere=true;
	}
	
	
	@Override
	public char getNext() {
		this.posicaoAtual=(isprimeiroAcesso && tamanhoMaximo>0)? 0: (posicaoAtual+1);
		this.isCaractere=(posicaoAtual==(tamanhoMaximo-1))?false:true;	
		this.isprimeiroAcesso=false;
		return valor.charAt(this.posicaoAtual);
	}

	@Override
	public boolean hasNext() {
		return isCaractere;
	}
}
