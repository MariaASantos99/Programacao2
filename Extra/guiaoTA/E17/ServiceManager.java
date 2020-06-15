
import static java.lang.System.*;

public class ServiceManager
{

  public ServiceManager(String [] serviceNames, int maxSize) {

    this.maxSize = maxSize;

    services = new ServiceQueue[serviceNames.length];

    for(int i=0; i<serviceNames.length; i++) {
      services[i] = new ServiceQueue(serviceNames[i], maxSize);
      services[i].beingServed = null;
    }
  }

  // verifica se o nome de um serviço é válido
  public boolean validServiceName(String serviceName) {
    int s = findService(serviceName);
    return s<services.length;
  }

  // verifica se existe um ou mais clientes à espera
  // de atendimento num dado serviço
  public boolean clientPending(String serviceName) {

    int s = findService(serviceName);
    assert s<services.length;

    return clientPending(s);
  }

  private boolean clientPending(int s) {
    return services[s].clientPendingExcept(beingServed());
  }

  // Verifica se a fila de um serviço está cheia
  public boolean serviceFull(String serviceName) {
    int s = findService(serviceName);
    assert s<services.length;

    return services[s].isFull();
  }

  // clear service manager
  public void clear() {
    for(int s=0; s<services.length; s++) {
      services[s].clear();
      services[s].beingServed = null;
    }
    first = null;
  }

  // retorna o índice do serviço no vector de serviços;
  // caso o serviço não exista, retorna o comprimento do vector
  private int findService(String serviceName) {

    int i = 0;
    while ( i<services.length  &&
        !services[i].serviceName().equals(serviceName) ) 
      i++;
    return i;
  }

  // Lista dos clientes que estão a ser servidos nos vários serviços
  private String [] beingServed() {
    int nBeingServed = 0;

    for(int i=0; i<services.length; i++)
      if (services[i].beingServed!=null) nBeingServed++;
    String [] a = new String[nBeingServed];
    int n = 0;
    for(int i=0; i<services.length; i++) {
      if (services[i].beingServed!=null) {
        a[n] = services[i].beingServed;
        n++;
      }
    }
    return a;
  }

  // Acrescentar dados de um serviço ao histórico de serviços
  private void logServiceData(int index, String client, int time) {
    HistoryNode n = new HistoryNode();
    n.time = time;
    n.serviceIndex = index;
    n.client = client;
    n.next = first;
    first = n;
  }

  // verifica se uma cadeia de caracteres existe num vector
  private static boolean inStringArray(String x, String [] a) {
    for(int i=0; i<a.length; i++)
      if (a[i].equals(x)) return true;
    return false;
  }

  // funde dois subvectores ordenados
  private static void mergeSubarrays(String[] a,int start,int middle,int end) {
    String[] b = new String[end-start];
    int i1 = start;
    int i2 = middle;
    int j = 0;
    while(i1 < middle && i2 < end) {
      if (a[i1].compareTo(a[i2]) < 0)
        b[j++] = a[i1++];
      else
        b[j++] = a[i2++];
    }
    while(i1 < middle)
      b[j++] = a[i1++];
    while(i2 < end)
      b[j++] = a[i2++];
    arraycopy(b, 0, a, start, end-start);
  }

  private ServiceQueue [] services;
  private int maxSize;

  private HistoryNode first = null;

  // ----------------- funções pedidas ------------------------

  public void queueFor(String clientName, String service){
	  assert validServiceName(service) : "service invallid!";
	  assert !serviceFull(service) : "service full!";
	  int idx = findService(service);
	  services[idx].in(clientName);
  }
  
  public void serveNext(String service){
	  assert validServiceName(service) : "service invallid!";
	  assert !serviceFull(service) : "service full!";
	  int idx = findService(service);
	  while(services[idx].equals(beingServed())){
		  services[idx].out();
	  }
	  services[idx].beingServed = services[idx].peek();
	  services[idx].out();
  }
  
  public void endService(String service, int time){
	  assert validServiceName(service) : "service invallid!";
	  int idx = findService(service);
	  logServiceData(idx, services[idx].beingServed, time);
	  services[idx].beingServed = null;
  }
  
  public int maxServiceTime(){
	  return maxServiceTime(first, -1);
  }
  
  private int maxServiceTime(HistoryNode n, int max){
	  if(n == null) return max;
	  if(n.time > max) max = n.time;
	  return maxServiceTime(n.next, max);
  }
  
  public boolean validServiceNameRec(String serviceName){
	  return findServiceName(serviceName, 0) < services.length;
  }
  
  private int findServiceName(String serviceName, int idx){
	  if(idx == services.length || services[idx].serviceName().equals(serviceName))return idx;
	  return findServiceName(serviceName, ++idx);
  }
  
  public static void sort(String[] a, int start, int end){
	  assert start>=0 && start < end;
	  assert a.length != 0;
	  if(end-start>1){
		  int middle = (start+end)/2;
		  sort(a, start, middle);
		  sort(a, middle, end);
		  mergeSubarrays(a, start, middle, end);
	  }
  }
  
  public String[] alphabeticalClientList(String serviceName){
	  assert validServiceName(serviceName) : "servico invalido!";	 
	  int idx = findService(serviceName);
	  String[] clients = services[idx].clientsInQueue();
	  sort(clients, 0, clients.length);
	  return clients;	  
  }

}

