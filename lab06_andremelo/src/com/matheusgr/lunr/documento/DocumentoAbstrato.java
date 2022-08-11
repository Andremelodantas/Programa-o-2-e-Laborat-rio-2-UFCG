package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import biblitex.TransformaTexto;

public abstract class DocumentoAbstrato implements Documento{
	
	public String id;
	public String original;
	public String limpo;
	public String[] split;
	
	/**
	 * Método para retornar a metrica do texto
	 * @return tamanho do texto
	 */
	@Override
	public double metricaTextoUtil() {
		long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo)
				.length();
		return (1.0 * extractedSize) / this.original.length();
	}
	/**
	 * Método para obter o id do texto
	 * @return id do texto
	 */
	@Override
	public String getId() {
		return this.id;
	}
	
	/**
	 * Método para obter as palavras do texto
	 * @return palavras do texto em uma cadeira de array
	 */
	@Override
	public String[] getTexto() {
		if (this.split == null) {
			this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
					.split(" ");
			Arrays.sort(this.split);
		}
		return this.split;
	}
	/**
	 * Método para gerar o hashcode do objeto
	 * @return hashcode do objeto em  inteiro
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	/**
	 * Método para obter a representação textual do objeto
	 * @return representação textual do objeto.
	 */
	@Override
	public String toString() {
		return "===" + this.id + System.lineSeparator() + this.limpo;
	}
	/**
	 * Método para comparar dois objetos e retornar true caso forem iguais
	 * @return booleano dizendo se é true ou false
	 */
	@Override
	public abstract boolean equals(Object obj);
	/**
	 * Método para adquirir todos os metadados do documento
	 * @return mapa com todos os metadados
	 */
	@Override
	public abstract Map<String, String> getMetadados();

}
