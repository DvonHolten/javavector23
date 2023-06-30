package vector1;


import java.util.Random;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class VectorTest {

    static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

    public static void main( String[] args ) {

        int[] vect1 = new int[ 32*1024 ];
        int[] vect2 = new int[ 32*1024 ];

        Random rnd = new Random( 4711 );
        for( int i= 0; i < vect1.length; i++ ) {
            vect1[ i ] = rnd.nextInt();
            vect2[ i ] = rnd.nextInt();
        }

        long start = System.nanoTime();

        int[] result = addTwoVectorArrays( vect1, vect2 );

        long endTm = System.nanoTime();

        System.out.printf(" time was %d nanoSecs %n", (endTm - start)/1000 );
    }

    public static int[] addTwoVectorArrays(int[] arr1, int[] arr2) {
        var v1 = IntVector.fromArray(SPECIES, arr1, 0);
        var v2 = IntVector.fromArray(SPECIES, arr2, 0);
        var result = v1.add(v2);
        return result.toArray();
    }
}
