// Altere esta classe para implementar um tipo de dados abstrato que funciona
// como um array, com métodos de put e get.
// A implementação fornecida cria um único array, mas queremos substituí-lo
// por uma lista de blocos (arrays de tamanho blocksize), que poderá crescer
// juntando progressivamente mais blocos à lista.
import p2utils.*;
public class BlockArrayInt{
	private LinkedList<BlockArrayInt> blocks = new LinkedList<BlockArrayInt>();
	private int numberOfBlocks = 0;
	
	public BlockArrayInt(int blockSize, int numBlocks) {
		assert blockSize > 0;
		assert numBlocks > 0;
		if(numberOfBlocks==0)blocks.addLast(this);//nao entendo a q se refere o this
		numberOfBlocks++;
		size = blockSize;
		a = new int[blockSize*numBlocks];
	}

	public int get(int index) {
		assert validIndex(index);
		int blockIndex = index/blockSize();
		BlockArrayInt block = blocks.get(blockIndex);
		return block.a()[(blockIndex+1)*blockSize()-index-1];
	}
	
	public void put(int elem, int index) {
		assert validIndex(index);
		int blockIndex = index/blockSize();
		BlockArrayInt block = blocks.get(blockIndex);
		block.a()[(blockIndex+1)*blockSize()-index-1]=elem;
	}

	public void incrementNumberOfBlocks() {
		blocks.addLast(new BlockArrayInt(blockSize(), 1));
		numberOfBlocks++;
		size +=blockSize();
	}

	public int size() {return size;}

	public int numberOfBlocks() {return numberOfBlocks;}

	public int blockSize() {return a.length;}

	public boolean validIndex(int index) {return index >= 0 && index < size();}
	
	public int[] a() {return a;}
	private int[] a;
	private int size;
}

