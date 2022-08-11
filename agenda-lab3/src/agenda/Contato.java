package agenda;

/**
 * Classe para armazenar todos os dados de cada contato.
 * @author André
 *
 */
public class Contato {
	private String nome = "";
	private String sobrenome = "";
	private String telefone = "";
	private String[] tags = new String[6];
	/**
	 * Construtor para cadastrar todos os dados no contato, e fazendo as validações do bônus 1.
	 * @param nome dados do contato
	 * @param sobrenome dados do contato
	 * @param telefone dados do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if ( nome == null || telefone == null) {
			throw new NullPointerException("Dado(s) nulo(s)");
		}else if (nome.trim().length() == 0 || telefone.trim().length() == 0 ) {
			throw new IllegalArgumentException("Parametros invalidos.");
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Método para retornar o número de telefone do contato
	 * @return String do telefone do contato
	 */
	public String getTelefone() {
		return this.telefone;
	}
	/**
	 * Método para retornar o nome e sobrenome do contato.
	 * @return String do nome + sobrenome do contato
	 */
	public String getContato() {
		return this.nome + " " +this.sobrenome;
	}
	/**
	 * Método para registrar tag na posição devida no contato
	 * @param posicaoTag posição da tag
	 * @param tag nome da tag
	 */
	public void registraTags(int posicaoTag, String tag) {
		this.tags[posicaoTag] = tag;
		
	}
	/**
	 * Método para retornar todas as tags do contato especificado
	 * @return String com todas as tags que o contato tem.
	 */
	public String getTags() {
		String saida = "";
		for (int i = 1;i < this.tags.length; i++) {
			if (this.tags[i] == null){
				
			}else {
				saida += this.tags[i] + " ";
			}
		}
		return saida.trim();
	}
}
