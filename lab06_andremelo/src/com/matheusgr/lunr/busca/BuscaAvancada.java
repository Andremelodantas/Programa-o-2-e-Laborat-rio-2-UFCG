package com.matheusgr.lunr.busca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;
/**
 * BuscaAvançada realiza uma operaração de busca a partir dos metadados
 * @author André
 *
 */
public class BuscaAvancada  implements Busca{
	
	private Map<String, String> metadados;
	private ArrayList<String>todosMetadados;
	/**
	 * Construtor padrão com os metadados a serem encontrados.
	 * @param metadados mapa com os metadados a serem encontrados
	 */
	public BuscaAvancada(Map<String, String> metadados) {
		(new ValidadorBusca()).valida(metadados);
		this.metadados = metadados;
		todosMetadados=new ArrayList<String>(this.metadados.keySet());
	}
	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * O DocumentoService realiza operações avançadas de  busca, mas sem
	 * ordenação ou tratamento da lógica de relevância.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada
	 *         operação.
	 */
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		
		for (Documento d: ds.todosDocumentos().values()) {
			boolean cumpriuMetadados = true;
			for(int i = 0; i < this.todosMetadados.size();i++) {
				if(d.getMetadados().containsValue(metadados.get(this.todosMetadados.get(i)))) {
					continue;
				}else cumpriuMetadados = false;
			}
			if(cumpriuMetadados == true) {
				respostaDocumento.put(d, respostaDocumento.getOrDefault(d,  0) + 1);
			}
		}
		return respostaDocumento;
	}
	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	@Override
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = new String[] {"TERMO " + this.todosMetadados.get(i), this.metadados.get(this.todosMetadados.get(i))};
		}
		return resultado;
	}

}
