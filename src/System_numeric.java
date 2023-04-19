import java.util.HashMap;

class System_numeric {
    String arab = "arab";
    String rim = "rim";

    String arab_regexp = "([1-9]|10){1}([-+/*]){1}([1-9]|10){1}";
    String rim_regexp = "([I]{1,3}|[IV]{1,4}|[IX]|[X])([-+/*]{1})([I]{1,3}|[IV]{1,4}|[IX]|[X])";

    HashMap<Integer, String> arab_to_rim = new HashMap<>();
    HashMap<String, Integer> rim_to_arab = new HashMap<>();

    System_numeric(){
        this.arab_to_rim.put( 1, "I" );
        this.arab_to_rim.put( 2, "II" );
        this.arab_to_rim.put( 3, "III" );
        this.arab_to_rim.put( 4, "IV" );
        this.arab_to_rim.put( 5, "V" );
        this.arab_to_rim.put( 6, "VI" );
        this.arab_to_rim.put( 7, "VII" );
        this.arab_to_rim.put( 8, "VIII" );
        this.arab_to_rim.put( 9, "IX" );
        this.arab_to_rim.put( 10, "X" );
        this.arab_to_rim.put( 20, "XX" );
        this.arab_to_rim.put( 30, "XXX" );
        this.arab_to_rim.put( 40, "XL" );
        this.arab_to_rim.put( 50, "L" );
        this.arab_to_rim.put( 60, "LX" );
        this.arab_to_rim.put( 70, "LXX" );
        this.arab_to_rim.put( 80, "LXXX" );
        this.arab_to_rim.put( 90, "XC" );
        this.arab_to_rim.put( 100, "C" );

        for ( int i=1; i<100; i++ ){
            if (! arab_to_rim.containsKey( i )) {
                int x1 = i / 10 * 10;
                int x2 = i % 10;
                String new_rim = arab_to_rim.get( x1 ) + arab_to_rim.get(x2);

                this.arab_to_rim.put( i, new_rim );
            }
        }

        this.arab_to_rim.forEach( (key, value) -> this.rim_to_arab.put( value, key ) );

    }
}
