package p2utils;

/** This class implements a "dynamic" array of elements of generic type.
 * The capacity of a dynamic array grows automatically, as needed.
 * It implements a random access abstract data type, with two main methods:
 * set and get.
 */
public class DynamicArray<E> {

  private E[] array;
  private int maxidx = -1;  // maximum index ever set
  private static final int BLOCK = 256;

  public DynamicArray(){
	  this.array = null;
  }

  /** Returns the length of the array.
   * The "length" is defined as 1 plus the maximum index that was set.
   * @return Number of elements in the array
   */
  public int length() { return 1+maxidx; }

  /** Set the element in position idx to given value.
   */
  public void set(int idx, E value) {
    assert idx >= 0;
    if(idx >= array.length){
		E[] a = (E[]) new Object [array.length];
		for (int i = 0; i <a.length ; i++){
			a[i] = array[i];
		}
		array = (E[]) new Object[array.length+BLOCK];
		for (int i = 0; i < a.length; i++)
		{
			array[i] = a[i];
		}
	}
	
	array[idx] = value;
  }


  /** Return the element in a given position in the list.
   * @param idx  the index of the element (0 is the first).
   * @return value at position idx of the array, or null, if not set yet.
   */
  public E get(int idx) {
    assert idx >= 0;
	if(array[idx]==null)return null;
	else return array[idx];
  }

  public E get(int idx, E d){
	  assert idx >= 0;
	if(array[idx]==null)return d;
	else return array[idx];
  }

}
