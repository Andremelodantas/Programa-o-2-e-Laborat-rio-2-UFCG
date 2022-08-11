package agenda;


/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author André Melo
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private String[] contatos;
	private String nome;
	private String sobrenome;
	private String telefone;
	private Contato[] Contato = new Contato[TAMANHO_AGENDA];
	private String[] favoritos = new String[10];

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new String[TAMANHO_AGENDA];
		
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Nada, se não há contato na posição.
	 */
	public String getContato(int posicao) {
		if (this.Contato[posicao] == null) {
			return "";
		}
		for (int i=1; i<=10;i++) {
			if (this.Contato[posicao].getContato().equals(this.favoritos[i])){
				return "❤  "+ this.Contato[posicao].getContato() + "\n" + this.Contato[posicao].getTelefone() + "\n" + this.Contato[posicao].getTags();
			}
		}
		return Contato[posicao].getContato() + "\n" + Contato[posicao].getTelefone() + "\n" + this.Contato[posicao].getTags();
		
	}

	/**
	 * Cadastra um contato em uma posição, envia seus dados para outra classe com array de contato para armazena-los. 
	 * Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return String informando o exito do cadastro.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if ( nome == null || telefone == null) {
			return "CONTATO INVALIDO";
		}
		else if (nome.length() == 0 || telefone.length() == 0 ) {
			return "CONTATO INVALIDO";
		}
		for (int i = 0;i<this.contatos.length;i++) {
			if(this.Contato[i] == null) {
				
			}else if ((nome + " " + sobrenome).equals(this.Contato[i].getContato())) {
				return "CONTATO JA CADASTRADO";
			}
			
		}

		this.contatos[posicao] = nome;
		this.Contato[posicao] = new Contato(nome, sobrenome, telefone);
		return "CONTATO CADASTRADO COM SUCESSO!";
		
	}
	/**
	 * Método para fazer a lista de contato com posição, nome e sobrenome.
	 * @param posicao da agenda que o contato se encontra.
	 * @return String com os dados do contato especificado acima.
	 */
	public String toString(int posicao) {
		return posicao + " - " + this.Contato[posicao].getContato();
	}
	
	/**
	 * Método para cadastrar contato aos favoritos. Sobreescreve a posição de favorito se já estiver ocupada 
	 * e não é possivel cadastrar um contato mais de uma vez.
	 * @param posicaoContato posição do contato na agenda
	 * @param posicaoFavorito posição do contato que ele vai ficar em favorito.
	 * @return String indicando sucesso ou falha em outras palavras.
	 */
	public String cadastraFavoritos(int posicaoContato, int posicaoFavorito) {
		if (posicaoFavorito>10 || posicaoFavorito<1) {
			return("Posicao invalida.");
		}
		for (int i=1; i<=10;i++) {
			if (this.Contato[posicaoContato].getContato().equals(this.favoritos[i])){
				return "Não é possivel adicionar, pois o contato ja esta adicionado aos favoritos.";
			}
		}
		this.favoritos[posicaoFavorito] = Contato[posicaoContato].getContato();
		return "CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito + "!";
		
	}
	/**
	 * Acessa a lista de favoritos mantida.
	 * @return O array de favoritos.
	 */
	public String[] getFavoritos() {
		return this.favoritos.clone();
	}
	
	/**
	 * Método para listar os favoritos, cada vez que for chamado
	 * retorna um.
	 * @param posicao do favorito desejado.
	 * @return String com os dados do favorito.
	 */
	public String listarFavoritos(int posicao) {
		return posicao + " - " + this.favoritos[posicao];
	}
	
	/**
	 * Método para adicionar tags aos contatos na posição desejada, se ja tiver uma tag, é sobreescrita.
	 * @param posicoesContato String com as posições dos contatos que sera separada com split para poder adicionar as tags de forma precisa
	 * @param tag String com a tag.
	 * @param posicaoTag posição da tag.
	 * @return String informando do sucesso ou não da tag.
	 */
	public String adicionaTags(String posicoesContato, String tag, int posicaoTag) {
		if(posicaoTag<1 || posicaoTag>5) {
			return("Posição da tag invalida, só é permitido entre 1 e 5.");
		}
		String[] posicao = posicoesContato.split(" ");
		for(int i = 0; i<posicao.length;i++) {
			this.Contato[Integer.parseInt(posicao[i])].registraTags(posicaoTag, tag);
		}
		return("Tag "+ tag + ", adicionado na posicao " + posicaoTag);
	}
}
