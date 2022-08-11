package com.matheusgr.lunr.busca;

import java.util.Map;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;
/**
 * Interface para poder transformar a parte de Busca do nosso sistema expansivel.
 * @author André
 *
 */
public interface Busca {
	/**
	 * Método padrão para fazer a busca nos documentos
	 * @param ds Objeto Documento Service
	 * @return um mapa com as buscas feitas
	 */
	public Map<Documento, Integer> busca(DocumentoService ds);
	/**
	 * Método padrão para descrever as consultas nos ducumentos
	 * @return Array com as consultas.
	 */
	public String[][] descreveConsulta();

}
