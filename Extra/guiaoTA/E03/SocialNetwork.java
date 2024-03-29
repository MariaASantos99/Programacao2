
/** Uma SocialNetwork é caracterizada por um vector de membros
 * (objectos da classe Person) e um vector de pedidos de amizade
 * (objectos da classe FriendshipRequest).
 * Cada pedido de amizade pode estar num de quatro estados:
 * "pending", "accepted", "rejected" e "cancelled".
 */

public class SocialNetwork {

  /**
   * Construtor de objectos da classe SocialNetwork.
   * @param  maxSize Capacidade inicial do vector de membros
   *         ("members") da rede social.
   * @param  sizeExpansion Numero de posicoes a acrescentar
   *                 ao vector quando este enche.
   */
  public SocialNetwork(int maxSize, int sizeExpansion) {

    this.sizeExpansion = sizeExpansion;
    members = new Person[maxSize];
    requests = new FriendshipRequest[maxSize];
  }

  /**
   * Verifica se uma pessoa e' membro da rede social.
   * @param  personName Nome da pessoa.
   * @return true se a pessoa e' membro, false caso contrario
   */
  public boolean personIsMember(String personName) {
    return memberIndex(personName) != -1;
  }

  /**
   * Acrescenta uma nova pessoa como membro da rede social.
   * @param  person Uma pessoa que ainda nao seja membro.
   */
  public void addMember(Person p) {
    assert !personIsMember(p.name());

    if (numMembers==members.length) extendMemberArray();
    members[numMembers] = p;
    numMembers++;
  }

  /**
   * Devolve o numero de membros da rede social.
   */
  public int numMembers() {
    return numMembers;
  }

  /**
   * Devolve o indice de um membro no vector "members".
   * @param personName O nome da pessoa a procurar
   * @return O indice da pessoa no vector, ou -1 caso 
   *         não seja encontrada
   */
  private int memberIndex(String personName) {
    for(int m=0; m<numMembers(); m++) {
      if (members[m].name().equals(personName))
        return m;
    }
    return -1;
  }

  /**
   * Expande a dimensao do vector "members", quando este enche.
   */
  private void extendMemberArray() {
    Person[] newmembers = new Person[members.length+sizeExpansion];
    System.arraycopy(members,0,newmembers,0,numMembers);
    members = newmembers;
  }

  private Person[] members;
  private int numMembers = 0, numRequests = 0;
  private final int sizeExpansion;
  
  private FriendshipRequest[] requests;

  /**
   * Actualiza o estado de um pedido de amizade.
   * @param m1   Nome do membro que fez o pedido
   * @param m2   Nome do destinatario do pedido
   * @param s    Novo estado a registar
   */
  public void setRequestStatus(String m1, String m2, String s) {


    int p1 = memberIndex(m1);
    int p2 = memberIndex(m2);


    int r = requestIndex(p1,p2);


    requests[r].setStatus(s);
  }
  /**
   * Mostra informacao sobre os membros da rede social
   * e respectivos pedidos de amizade.
   */
  public void display() {
    for(int m=0; m<numMembers; m++)
    {
      System.out.print(members[m].name() + " ("+ members[m].birthYear()+")\t: ");

      for(int r=0; r<numRequests(); r++)
        if (requests[r].requester()==m) {
          if (requests[r].accepted()) 
            System.out.print("(A) ");
          else if (requests[r].rejected()) 
            System.out.print("(R) ");
          else if (requests[r].pending()) 
            System.out.print("(P) ");
          else if (requests[r].cancelled()) 
            System.out.print("(C) ");
          int ri = requests[r].requested();
          System.out.print(members[ri].name() + "\t");
        }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Devolve o indice de um pedido de amizade no vector "requests".
   * @param requester Indice de quem pediu amizade
   * @param requested Indice do destinatario do pedido
   * @return O indice do pedido no vector, ou -1 caso 
   *         não seja encontrado
   */
  private int requestIndex(int requester,int requested) {
    for(int r=0; r<numRequests(); r++)
      if ( requests[r].requester()==requester && 
          requests[r].requested()==requested )
        return r;
    return -1;
  }


  // Complete as funções pedidas:
  /**
   * Cria e guarda um pedido de amizade enviado por "m1" a "m2".
   * Admite-se que "m1" e "m2" sao nomes de membros ja' registados
   * e que ainda não existe um pedido entre eles.
   * @param m1 Nome do membro que faz o pedido.
   * @param m2 Nome do membro que é destinatario do pedido.
   */
  public void addFriendshipRequest(String m1, String m2) {
	  assert personIsMember(m1);
	  assert personIsMember(m2);
	  assert requestIndex(memberIndex(m1), memberIndex(m2))==-1;
	  if(numRequests == requests.length){
		  FriendshipRequest[] copy = new FriendshipRequest[requests.length + sizeExpansion];
		  System.arraycopy(requests,0,copy,0,requests.length);
		  requests = copy;
	  }
	  requests[numRequests++] = new FriendshipRequest(memberIndex(m1), memberIndex(m2));  
  }

  /**
   * Devolve o número de pedidos de amizade existentes.
   */
  public int numRequests() {
    return numRequests;
  }

  /**
   * Devolve o número de pedidos de amizade que é possível
   * armazenar com a capacidade actual.
   */
  public int maxNumRequests() {
    return this.requests.length;
  }

  /**
   * Calcula numero de pedidos feitos por uma dada
   * pessoa e que estejam pendentes.
   * Admite-se que a pessoa e' membro da rede.
   * @param memberName Nome do membro.
   */
  public int numPendingRequests(String memberName) {
	  int count=0;
	  for (int i = 0; i < numMembers; i++){
		  int n = requestIndex(memberIndex(memberName),i);
		  if(n != -1 && requests[n].pending())count++;
	  }
	  return count;
  }

  /**
   * Devolve o amigo mais velho de um determinado membro 
   * da rede, considerando pedidos de amizade enviados e 
   * recebidos, mas apenas os que estão em estado "accepted".
   * @param memberName Nome do membro da rede
   */
  public String oldestFriend(String memberName) {
	  int k=-1, ano=Integer.MAX_VALUE;
	for (int i = 1; i < numMembers; i++){
		int env = requestIndex(memberIndex(memberName),i);
		int rec = requestIndex(i, memberIndex(memberName));
		if( (env != -1 && requests[env].accepted()) || (rec != -1 && requests[rec].accepted())){
			
			int n = members[i].birthYear();
			if(ano > n){
				k = i;
				ano = n;
			}
		}
	}
	if(k==-1)return null;
	return members[k].name();
  }


}

