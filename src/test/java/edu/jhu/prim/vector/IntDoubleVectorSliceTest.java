package edu.jhu.prim.vector;

import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class IntDoubleVectorSliceTest {

    @Test
    public void testDotProduct() {
        IntDoubleVector v1 = new IntDoubleDenseVector();
        IntDoubleVector v2 = new IntDoubleDenseVector();
        v1.set(4, toDouble(5308));
        v1.set(49, toDouble(23));
        v1.set(32, toDouble(22));
        v1.set(23, toDouble(10));
        
        v2.set(3, toDouble(204));
        v2.set(2, toDouble(11));
        v2.set(4, toDouble(11));
        v2.set(23, toDouble(24));
        v2.set(10, toDouble(0001));
        v2.set(52, toDouble(11));
        v2.set(49, toDouble(7));
        
        v1 = new IntDoubleVectorSlice((IntDoubleDenseVector)v1, 0, 50);
        v2 = new IntDoubleVectorSlice((IntDoubleDenseVector)v2, 0, 53);
        
        assertEquals(11*5308 + 10*24 + 23*7, toInt(v1.dot(v2)));
    }
    
    @Test
    public void testDotProduct2() {
        IntDoubleVector v1 = new IntDoubleDenseVector();
        IntDoubleVector v2 = new IntDoubleDenseVector();
        v1.set(4, toDouble(5308));
        v1.set(49, toDouble(23));
        v1.set(32, toDouble(22));
        v1.set(23, toDouble(10));
        
        v2.set(3, toDouble(204));
        v2.set(2, toDouble(11));
        v2.set(4, toDouble(11));
        v2.set(23, toDouble(24));
        v2.set(10, toDouble(0001));
        v2.set(52, toDouble(11));
        v2.set(49, toDouble(7));
        
        v1 = new IntDoubleVectorSlice((IntDoubleDenseVector)v1, 2, 50);
        v2 = new IntDoubleVectorSlice((IntDoubleDenseVector)v2, 2, 53);
        
        assertEquals(11*5308 + 10*24 + 23*7, toInt(v1.dot(v2)));
    }
    
}    
