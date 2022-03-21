import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList();
        for (Integer i = 0; i < 10_000_000; i += 1) {
            list.add(i.toString().intern()); // .intern() places the string into string pool
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(">> One shot elapsed time -> " + (end - start) / 1000.0 + "s");
        System.out.println();

        Thread.sleep(5000); // required when adding more than 1M strings
    }

    /*
        Empty main method:
        StringTable statistics:
        Number of buckets       :     65536 =    524288 bytes, each 8
        Number of entries       :        10 =       160 bytes, each 16
        Number of literals      :        10 =       616 bytes, avg  61.000
        Total footprint         :           =    525064 bytes
        Average bucket size     :     0.000
        Variance of bucket size :     0.000
        Std. dev. of bucket size:     0.012
        Maximum bucket size     :         1

        Main with 1000 strings created:

        >> One shot elapsed time -> 0.001s

        StringTable statistics:
        Number of buckets       :     65536 =    524288 bytes, each 8
        Number of entries       :       973 =     15568 bytes, each 16
        Number of literals      :       973 =     46864 bytes, avg  48.000
        Total footprint         :           =    586720 bytes
        Average bucket size     :     0.015
        Variance of bucket size :     0.015
        Std. dev. of bucket size:     0.121
        Maximum bucket size     :         1

        Main with 10_000 strings created:

        >> One shot elapsed time -> 0.005s

        StringTable statistics:
        Number of buckets       :     65536 =    524288 bytes, each 8
        Number of entries       :      9973 =    159568 bytes, each 16
        Number of literals      :      9973 =    478864 bytes, avg  48.000
        Total footprint         :           =   1162720 bytes ~ 1.2Mb
        Average bucket size     :     0.152
        Variance of bucket size :     0.156
        Std. dev. of bucket size:     0.395
        Maximum bucket size     :         2

        Main with 1_000_000 strings created:

        >> One shot elapsed time -> 0.507s

        StringTable statistics:
        Number of buckets       :    524288 =   4194304 bytes, each 8    // how the f#ck it got resized???
        Number of entries       :    999973 =  15999568 bytes, each 16
        Number of literals      :    999973 =  47998864 bytes, avg  48.000
        Total footprint         :           =  68192736 bytes ~ 68Mb
        Average bucket size     :     1.907
        Variance of bucket size :     2.241
        Std. dev. of bucket size:     1.497
        Maximum bucket size     :         9

        Main with 10_000_000 strings created:

        >> One shot elapsed time -> 6.068s

        StringTable statistics:
        Number of buckets       :   4194304 =  33554432 bytes, each 8
        Number of entries       :   9999973 = 159999568 bytes, each 16
        Number of literals      :   9999973 = 479998864 bytes, avg  48.000
        Total footprint         :           = 673552864 bytes ~ 674Mb
        Average bucket size     :     2.384
        Variance of bucket size :     3.864
        Std. dev. of bucket size:     1.966
        Maximum bucket size     :        13

        With 10_000_000 strings put into string pool and -Xmx500m OutOfMemoryError is thrown

        Initial heap size 268435456 (~270Mb) -> 6.164s
        Initial heap size 629145600 (~629Mb) -> 7.573s // wtf?

        Setting up required string table size to avoid resizing:
        -XX:StringTableSize=4194304

        >> One shot elapsed time -> 3.835s

        StringTable statistics:
        Number of buckets       :   8388608 =  67108864 bytes, each 8
        Number of entries       :   9999973 = 159999568 bytes, each 16
        Number of literals      :   9999973 = 479998864 bytes, avg  48.000
        Total footprint         :           = 707107296 bytes
        Average bucket size     :     1.192
        Variance of bucket size :     1.383
        Std. dev. of bucket size:     1.176
        Maximum bucket size     :         9



        Setting up required string table size to avoid resizing:
        -XX:StringTableSize=2097152 (non-prime size) -> 4.532s
        -XX:StringTableSize=2097169 (prime size) -> 3.773s

     */
}
