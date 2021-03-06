package edu.jhu.prim.list;

import java.io.Serializable;
import java.util.Arrays;

import edu.jhu.prim.Primitives;

/**
 * Array list for float primitives.
 * @author mgormley
 */
public class FloatArrayList implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /** The internal array representing this list. */
    protected float[] elements;
    /** The number of elements in the list. */
    protected int size;
    
    public FloatArrayList() {
        this(8);
    }
    
    public FloatArrayList(int initialCapacity) {
        elements = new float[initialCapacity];
        size = 0;
    }
    
    /** Copy constructor. */
    public FloatArrayList(FloatArrayList other) {
        this(other.size);
        add(other);
    }
    
    /**
     * Adds the value to the end of the list.
     * @param value The value to add.
     */
    public void add(float value) {
        ensureCapacity(size + 1);
        elements[size] = value;
        size++;
    }
    
    /**
     * Gets the i'th element of the array list.
     * @param i The index of the element to get.
     * @return The value of the element to get.
     */
    public float get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[i];
    }
    
    /**
     * Sets the i'th element of the array list to the given value.
     * @param i The index to set.
     * @param value The value to set.
     */
    public void set(int i, float value) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[i] = value;
    }

    /**
     * Adds all the elements in the given array to the array list.
     * @param values The values to add to the array list.
     */
    public void add(float[] values) {
        ensureCapacity(size + values.length);
        for (float element : values) {
            this.add(element);
        }
    }
    
    /**
     * Adds all the elements in the given array list to the array list.
     * @param values The values to add to the array list.
     */
    public void add(FloatArrayList values) {
        ensureCapacity(size + values.size);
        for (int i=0; i<values.size; i++) {
            this.add(values.elements[i]);
        }
    }

    /**
     * Gets the index of the first element in this list with the specified
     * value, or -1 if it is not present.
     * 
     * @param value The value to search for.
     * @param delta The delta with which to evaluate equality.
     * @return The index or -1 if not present.
     */
    public int lookupIndex(float value, float delta) {
        for (int i=0; i<elements.length; i++) {
            if (Primitives.equals(elements[i], value, delta)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets a NEW array containing all the elements in this array list.
     * @return The new array containing the elements in this list.
     */
    public float[] toNativeArray() {
        return Arrays.copyOf(elements, size);
    }
    
    /**
     * Trims the internal array to the size of the array list and then return
     * the internal array backing this array list. CAUTION: this should not be
     * called without carefully handling the result.
     * 
     * @return The internal array representing this array list, trimmed to the
     *         correct size.
     */
    // TODO: rename to getElements.
    public float[] elements() {
        this.trimToSize();
        return elements;
    }
    
    /**
     * Gets the internal representation of this list. CAUTION: this should not
     * be called without carefully handling the result.
     */
    public float[] getInternalElements() {
        return elements;
    }
    
    /**
     * Trims the internal array to exactly the size of the list.
     */
    public void trimToSize() {
        if (size != elements.length) { 
            elements = Arrays.copyOf(elements, size);
        }
    }

    /**
     * Ensure that the internal array has space to contain the specified number of elements.
     * @param size The number of elements. 
     */
    private void ensureCapacity(int size) {
        elements = ensureCapacity(elements, size);
    }
    
    /**
     * Ensure that the array has space to contain the specified number of elements.
     * @param elements The array.
     * @param size The number of elements. 
     */
    public static float[] ensureCapacity(float[] elements, int size) {
        if (size > elements.length) {
            float[] tmp = new float[size*2];
            System.arraycopy(elements, 0, tmp, 0, elements.length);
            elements = tmp;
        }
        return elements;
    }

    /**
     * Gets the number of elements in the list.
     * @return The size of the list.
     */
    public int size() {
        return size;
    }
    
    /**
     * Removes all elements from this array list.
     */
    public void clear() {
        size = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FloatArrayList [");
        for (int i=0; i<size; i++) {
            sb.append(i);
            if (i != size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + size;
        Arrays.hashCode(elements);
        for (int i=0; i<size; i++) {
            int elementHash = Primitives.hashOfFloat(elements[i]);
            result = prime * result + elementHash;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FloatArrayList other = (FloatArrayList) obj;
        if (size != other.size)
            return false;
        for (int i=0; i<size; i++) {
            if (this.elements[i] != other.elements[i]) 
                return false;
        }
        return true;
    }
        
}
