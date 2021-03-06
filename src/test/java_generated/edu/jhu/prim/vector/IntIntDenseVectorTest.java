package edu.jhu.prim.vector;

import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.jhu.prim.Primitives.MutableInt;
import edu.jhu.prim.list.IntArrayList;
import edu.jhu.prim.list.IntArrayList;
import edu.jhu.prim.util.Lambda.FnIntIntToInt;
import edu.jhu.prim.util.Lambda.FnIntIntToVoid;


public class IntIntDenseVectorTest extends AbstractIntIntVectorTest {

    protected IntIntVector getIntIntVector() {
        return new IntIntDenseVector();
    }

    @Test
    public void testIterate() {
        IntIntVector v2 = getIntIntVector();
        v2.add(1, toInt(11));
        v2.add(2, toInt(22));
        v2.add(1, toInt(111));
        v2.add(3, toInt(0));

        final IntArrayList idxs = new IntArrayList();
        final IntArrayList vals = new IntArrayList();
        idxs.add(0); vals.add(0);
        idxs.add(1); vals.add(122);
        idxs.add(2); vals.add(22);
        idxs.add(3); vals.add(0);
        
        final MutableInt i = new MutableInt(0);
        
        v2.iterate(new FnIntIntToVoid() {           
            @Override
            public void call(int idx, int val) {
                assertTrue(i.v < idxs.size()); // Failing here means we are iterating over too many entries.
                assertEquals(idxs.get(i.v), idx);
                assertEquals(vals.get(i.v), val);
                i.v++;
            }
        });
        
        // Did we iterate over the full expected set.
        assertEquals(i.v, idxs.size());
    }

    @Test
    public void testApply() {
        IntIntVector v2 = getIntIntVector();
        v2.add(1, toInt(11));
        v2.add(2, toInt(22));
        v2.add(1, toInt(111));
        v2.add(3, toInt(0));

        final IntArrayList idxs = new IntArrayList();
        final IntArrayList vals = new IntArrayList();
        idxs.add(0); vals.add(0);
        idxs.add(1); vals.add(122);
        idxs.add(2); vals.add(22);
        idxs.add(3); vals.add(0);

        final MutableInt i = new MutableInt(0);
        
        v2.apply(new FnIntIntToInt() {           
            @Override
            public int call(int idx, int val) {
                assertTrue(i.v < idxs.size()); // Failing here means we are iterating over too many entries.
                assertEquals(idxs.get(i.v), idx);
                assertEquals(vals.get(i.v), val);
                i.v++;
                return val;
            }
        });
        
        // Did we iterate over the full expected set.
        assertEquals(i.v, idxs.size());
    }
    
}    
