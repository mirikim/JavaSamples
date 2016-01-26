package Day11_160112;

import java.util.*;

public class MyVector implements List {
	protected Object[] data = null;// 객체를 담기 위한 객체배열을 선언한다.
	protected int capacity = 0;// 용량
	protected int size = 0;// 크기

	public MyVector(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity);

		this.capacity = capacity;
		data = new Object[capacity];

	}

	public MyVector() {// default값
		this(10);// 크기를 지정하지 않으면 크기를 10으로 한다.
	}

	// 최소한의 저장공간(capacity)를 확보하는 메서드
	public void ensureCapacity(int minCapacity) {
		int newCapacity = capacity;// 0

		// 넘겨받은 값이 현재 capacity보다 크면 MyVector의 크기를 2배로 늘린다.
		if (minCapacity > capacity) {
			newCapacity = capacity * 2;
		}

		// 넘겨받은 값(minCapacity)이 2배로 늘린 값(newCapacity)보다도 크면,
		if (minCapacity > newCapacity) {
			newCapacity = minCapacity;// 새로운 크기를 넘겨받은 크기 그대로 지정한다.
		}
		setCapacity(newCapacity);

	}

	public boolean add(Object obj) {
		// 새로운 객체를 저장하기 전에 저장할 공간을 확보한다.
		ensureCapacity(size + 1);
		data[size++] = obj;
		return true;
	}

	public Object get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		return data[index];
	}

	public Object remove(int index) {// Object의해당 index를 제거하고 oldObj에 배열을 담아
										// return
		Object oldObj = null;
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		oldObj = data[index];

		// 삭제하고자 하는 객체가 마지막 객체가 아니라면 배열 복사를 통해 빈자리를 채워줘야 한다.
		if (index != size - 1) {
			System.arraycopy(data, index + 1, data, index, size - index - 1);// 같은배열내
																				// shift
		}
		// 마지막 데이터를 null로 한다. 배열은 0부터 시작하므로 마지막 요소는 index가 size-1이다.
		data[size - 1] = null;
		size--;
		return oldObj;
	}

	public boolean remove(Object obj) {// obj의 값과 data[i]의 주소값과 같은지 비교(Object는
										// 주소값을 비교하기때문)후 같은값을 remove
		for (int i = 0; i < size; i++) {
			if (obj.equals(data[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	public void trimToSize() {// 용량을 크기에 맞게 줄인다.(빈 공간을 없앤다) capacity==size
		setCapacity(size);
	}

	public void setCapacity(int capacity) {
		if (this.capacity == capacity)
			return;

		Object[] tmp = new Object[capacity];
		System.arraycopy(data, 0, tmp, 0, size);
		data = tmp;
		this.capacity = capacity;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
			size = 0;// 인스탄스변수이므로 항상체크해주어야함
		}
	}

	public Object[] toArray() {// 배열에 저장된 객체들을 객체배열로 바꿔준다.
		Object[] result = new Object[size];//deep copy
		System.arraycopy(data, 0, result, 0, size);
		return result;//return data;를한다면(참조값을 복사하는것이므로 shallow copy)
	}

	public boolean isEmpty() {// vector가비어있는지 확인 비어있으면 true
		return size == 0;
	}

	public int capacity() {//Vector의 용량반환
		return capacity;
	}

	public int size() {//Vector에 저장된 객체의 갯수를 반환
		return size;
	}

	/*****************************************
	 * List인터페이스로부터 상속받은 메서드들*
	 *****************************************/

	// public int size();
	// public boolean isEmpty();
	public boolean contains(Object o) {//Object o가 Vector에 포함되어있는지
		return false;
	}

	public Iterator iterator() {
		return null;
	}

	// public Object[] toArray();
	public Object[] toArray(Object a[]) {
		return null;
	}

	// public boolean add(Object o);
	// public boolean remove(Object o);
	public boolean containsAll(Collection c) {
		return false;
	}

	public boolean addAll(Collection c) {
		return false;
	}

	public boolean addAll(int index, Collection c) {
		return false;
	}

	public boolean removeAll(Collection c) {
		return false;

	}

	public boolean retainAll(Collection c) {
		return false;
	}

	// public void clear();
	public boolean equals(Object o) {
		return false;

	}

	// public int hashCode();
	// public Object get(int index);
	public Object set(int index, Object element) {
		return null;
	}

	public void add(int index, Object element) {
	}

	// public Object remove(int index);
	public int indexOf(Object o) {
		return -1;

	}

	public int lastIndexOf(Object o) {
		return -1;
	}

	public ListIterator listIterator() {
		return null;
	}

	public ListIterator listIterator(int index) {
		return null;
	}

	public List subList(int fromIndex, int toIndex) {
		return null;
	}

}
