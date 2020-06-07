import static java.lang.System.*;
import java.io.File;

import p2utils.LinkedList;

public class ListRec2 {

  public static void main(String[] args) {
    if (args.length != 1) {
      err.println("Uso: java -ea ListRec2 <dir>");
      exit(1);
    }

    File dir = new File(args[0]);

    // Verificar entrada
    if (!dir.exists()) {
      err.printf("ERRO: %s nao existe!\n", dir);
      exit(2);
    }

    LinkedList<File> files = recListFiles(dir);
    files.print();
  }

  /** Devolve uma lista com o conteúdo de um directório f
   *  e de todos os seus subdirectórios recursivamente.
   */
	public static LinkedList<File> recListFiles(File f) {
		assert f != null;
		LinkedList<File> lkd = new LinkedList<File>();
		if (f.exists()){
			lkd.addLast(f);
			if(f.isDirectory() && f.canRead()){
				File[] list = f.listFiles();
				for (int i = 0; i < list.length; i++){
					lkd = lkd.concatenate(recListFiles(list[i]));					
				}
			}
		}
		return lkd;
	}
}
