package br.com.questao1;


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
		return valor.charAt(getPosicaoAtual());
	}

	@Override
	public boolean hasNext() {
		return isCaractere;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}


	public void setTamanhoMaximo(int tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
	}



	public Integer getPosicaoAtual() {
		return posicaoAtual;
	}


	public void setPosicaoAtual(Integer posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}


	public void setTamanhoMaximo(Integer tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
	}


	public boolean isCaractere() {
		return isCaractere;
	}


	public void setCaractere(boolean isCaractere) {
		this.isCaractere = isCaractere;
	}

	
	
	public static void main(String[] args) {
		StreamImpl s=new StreamImpl("testeagora");
		
		while(s.hasNext()) {
			System.out.println(s.getNext());
		}
	}
	
}
