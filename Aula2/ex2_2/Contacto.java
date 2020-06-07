public class Contacto {
  private String nome;
  private String telefone;
  private String email;
  
	public Contacto(String nome, String telefone, String email){
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	public Contacto(String nome, String telefone){
		this.nome = nome;
		this.telefone = telefone;
		this.email = null;
	}
  public String nome(){
	return this.nome;
  }
  
  public String telefone(){
	return this.telefone;
  }
  
  public String email(){
	return this.email;
  }
}
