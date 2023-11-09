package vector1;


import java.util.Random;

import jdk.incubator.vector.*;

public class VectorJun {

    static final VectorSpecies<Integer> INT_SPECIES = IntVector.SPECIES_PREFERRED;

    static final VectorSpecies<Float> FLT_SPECIES = FloatVector.SPECIES_PREFERRED;

    static final VectorSpecies<Double> DBL_SPECIES = DoubleVector.SPECIES_PREFERRED;

    static final VectorSpecies<Long> LNG_SPECIES = LongVector.SPECIES_PREFERRED;

    public VectorJun( String[] args ){

    }

    public static void main( String[] args ) {

        int nSize = 2* 64 * 1024;
        int[] vect1 = new int[ nSize ];
        int[] vect2 = new int[ nSize ];

        float[] fltVect1 = new float[ nSize ];
        float[] fltVect2 = new float[ nSize ];

        double[] dblVect1 = new double[ nSize ];
        double[] dblVect2 = new double[ nSize ];

        long[] lngVect1 = new long[ nSize ];
        long[] lngVect2 = new long[ nSize ];

        Random rnd = new Random( 4711 );
        for( int i= 0; i < vect1.length; i++ ) {
            vect1[ i ] = rnd.nextInt();
            vect2[ i ] = rnd.nextInt();
            fltVect1[ i ] = rnd.nextFloat();
            fltVect2[ i ] = rnd.nextFloat();
            dblVect1[ i ] = rnd.nextDouble();
            dblVect2[ i ] = rnd.nextDouble();
            lngVect1[ i ] = rnd.nextLong();
            lngVect2[ i ] = rnd.nextLong();
        }

        double[] xdblResult = addTwoDoubleVectorArrays( dblVect1, dblVect2 );

        long dblAddStart = System.nanoTime();
        double[] dblResult = addTwoDoubleVectorArrays( dblVect1, dblVect2 );
        long dblAddEnd = System.nanoTime();

        long lngAddStart = System.nanoTime();
        long[] lngResult = addTwoLongVectorArrays( lngVect1, lngVect2 );
        long lngAddEnd = System.nanoTime();

        long intAddStart = System.nanoTime();
        int[] intResult = addTwoIntVectorArrays( vect1, vect2 );
        long intAddEnd = System.nanoTime();

        long fltAddStart = System.nanoTime();
        float[] fltResult = addTwoFloatVectorArrays( fltVect1, fltVect2 );
        long fltAddEnd = System.nanoTime();

        System.out.printf(" time was %d microSecs INT %n", (intAddEnd - intAddStart)/1000 );
        System.out.printf(" time was %d microSecs FLT %n", (fltAddEnd - fltAddStart)/1000 );
        System.out.printf(" time was %d microSecs DBL %n", (dblAddEnd - dblAddStart)/1000 );
        System.out.printf(" time was %d microSecs LNG %n", (lngAddEnd - lngAddStart)/1000 );

        long dblMulStart = System.nanoTime();
        dblResult = mulTwoDoubleVectorArrays( dblVect1, dblVect2 );
        long dblMulEnd = System.nanoTime();

        long intMulStart = System.nanoTime();
        intResult = mulTwoIntVectorArrays( vect1, vect2 );
        long intMulEnd = System.nanoTime();

        long lngMulStart = System.nanoTime();
        lngResult = mulTwoLongVectorArrays( lngVect1, lngVect2 );
        long lngMulEnd = System.nanoTime();

        long fltMulStart = System.nanoTime();
        fltResult = mulTwoFloatVectorArrays( fltVect1, fltVect2 );
        long fltMulEnd = System.nanoTime();

        System.out.printf(" time was %d microSecs INT %n", (intMulEnd - intMulStart)/1000 );
        System.out.printf(" time was %d microSecs FLT %n", (fltMulEnd - fltMulStart)/1000 );
        System.out.printf(" time was %d microSecs DBL %n", (dblMulEnd - dblMulStart)/1000 );
        System.out.printf(" time was %d microSecs LNG %n", (lngMulEnd - lngMulStart)/1000 );

    }

    public static int[] addTwoIntVectorArrays( int[] arr1, int[] arr2) {
        var v1 = IntVector.fromArray( INT_SPECIES, arr1, 0);
        var v2 = IntVector.fromArray( INT_SPECIES, arr2, 0);
        var result = v1.add(v2);
        return result.toArray();
    }

    public static int[] mulTwoIntVectorArrays( int[] arr1, int[] arr2) {
        var v1 = IntVector.fromArray( INT_SPECIES, arr1, 0);
        var v2 = IntVector.fromArray( INT_SPECIES, arr2, 0);
        var result = v1.mul(v2);
        return result.toArray();
    }

    public static float[] addTwoFloatVectorArrays( float[] arr1, float[] arr2) {
        var v1 = FloatVector.fromArray( FLT_SPECIES, arr1, 0);
        var v2 = FloatVector.fromArray( FLT_SPECIES, arr2, 0);
        var result = v1.add(v2);
        return result.toArray();
    }

    public static float[] mulTwoFloatVectorArrays( float[] arr1, float[] arr2) {
        var v1 = FloatVector.fromArray( FLT_SPECIES, arr1, 0);
        var v2 = FloatVector.fromArray( FLT_SPECIES, arr2, 0);
        var result = v1.mul(v2);
        return result.toArray();
    }

    public static double[] addTwoDoubleVectorArrays( double[] arr1, double[] arr2) {
        var v1 = DoubleVector.fromArray( DBL_SPECIES, arr1, 0);
        var v2 = DoubleVector.fromArray( DBL_SPECIES, arr2, 0);
        var result = v1.add(v2);
        return result.toArray();
    }

    public static double[] mulTwoDoubleVectorArrays( double[] arr1, double[] arr2) {
        var v1 = DoubleVector.fromArray( DBL_SPECIES, arr1, 0);
        var v2 = DoubleVector.fromArray( DBL_SPECIES, arr2, 0);
        var result = v1.mul(v2);
        // var mask = result.lt( 25.6 );
        return result.toArray();
    }


    public static long[] addTwoLongVectorArrays( long[] arr1, long[] arr2) {
        var v1 = LongVector.fromArray( LNG_SPECIES, arr1, 0);
        var v2 = LongVector.fromArray( LNG_SPECIES, arr2, 0);
        var result = v1.add(v2);
        return result.toArray();
    }

    public static long[] mulTwoLongVectorArrays( long[] arr1, long[] arr2) {
        var v1 = LongVector.fromArray( LNG_SPECIES, arr1, 0);
        var v2 = LongVector.fromArray( LNG_SPECIES, arr2, 0);
        var result = v1.mul(v2);
        // var mask = result.lt( 25.6 );
        return result.toArray();
    }


    public void someUselessMethod() {
        System.out.println("this is useless");
    }


}
