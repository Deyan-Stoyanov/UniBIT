import com.sun.org.apache.xml.internal.security.keys.content.keyvalues.KeyValueContent;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AnonymousCache{

    public static void main(String[]args){
        class Cache{
            public String NameOfChache;
            public HashMap<String, Long> KeyAndSizeOfCache;

            public String getNameOfChache() {
                return NameOfChache;
            }

            public void setNameOfChache(String nameOfChache) {
                NameOfChache = nameOfChache;
            }

            public HashMap<String, Long> getKeyAndSizeOfCache() {
                return KeyAndSizeOfCache;
            }

            public void setKeyAndSizeOfCache(HashMap<String, Long> keyAndSizeOfCache) {
                KeyAndSizeOfCache = keyAndSizeOfCache;
            }
        }

        class DataSet{

            public String NameOfDataSet;
            public HashMap<String, Long> KeyAndSizeOfDataSet;

            public String getNameOfDataSet() {
                return NameOfDataSet;
            }

            public void setNameOfDataSet(String nameOfDataSet) {
                NameOfDataSet = nameOfDataSet;
            }

            public HashMap<String, Long> getKeyAndSizeOfDataSet() {
                return KeyAndSizeOfDataSet;
            }

            public void setKeyAndSizeOfDataSet(HashMap<String, Long> keyAndSizeOfDataSet) {
                KeyAndSizeOfDataSet = keyAndSizeOfDataSet;
            }
        }

        Scanner scanner = new Scanner(System.in);
        ArrayList<DataSet> listOfDataSets = new ArrayList<>();
        ArrayList<Cache> listOfCaches = new ArrayList<>();
        while(true){
            String line = scanner.nextLine();
            if(line.equals("thetinggoesskrra")){
                break;
            }
            String[] input = line.split("[\\-\\>\\|\\s]+");
            if(input.length == 1){
                String dataSet = input[0];
                DataSet thisDataSet = new DataSet(){};
                thisDataSet.NameOfDataSet = dataSet;
                thisDataSet.KeyAndSizeOfDataSet = new HashMap<>();
                for(Cache c:listOfCaches){
                    if(c.NameOfChache.equals(thisDataSet.NameOfDataSet)) {
                        c.KeyAndSizeOfCache.forEach((k, v) -> thisDataSet.KeyAndSizeOfDataSet.put(k, v));
                    }
                }
                if(!listOfDataSets.contains(thisDataSet)){
                    listOfDataSets.add(thisDataSet);
                }
            }else{
                String dataKey = input[0];
                Long dataSize = Long.parseLong(input[1]);
                String dataSet = input[2];
                boolean itExists = false;
                for (DataSet createdSet:listOfDataSets) {
                    if(createdSet.NameOfDataSet.equals(dataSet)){
                        itExists = true;
                        createdSet.KeyAndSizeOfDataSet.put(dataKey, dataSize);
                        break;
                    }
                }
                if(!itExists){
                    boolean cacheExists = false;
                    for (Cache c:listOfCaches) {
                        if(c.NameOfChache.equals(dataSet)){
                            cacheExists = true;
                            c.KeyAndSizeOfCache.put(dataKey, dataSize);
                        }
                    }
                    if(!cacheExists){
                        Cache cache = new Cache(){};
                        cache.NameOfChache = dataSet;
                        cache.KeyAndSizeOfCache = new HashMap<>();
                        cache.KeyAndSizeOfCache.put(dataKey, dataSize);
                        listOfCaches.add(cache);
                    }
                }
            }
        }

        for (int i = listOfDataSets.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                Long sum1 = 0L;
                Long sum2 = 0L;
                for (Long a: listOfDataSets.get(j).KeyAndSizeOfDataSet.values()) {
                    sum1 += a;
                }
                for (Long b: listOfDataSets.get(j + 1).KeyAndSizeOfDataSet.values()) {
                    sum2 += b;
                }
                if(sum1 > sum2){
                    DataSet temp = listOfDataSets.get(j);
                    listOfDataSets.set(j, listOfDataSets.get(j + 1));
                    listOfDataSets.set(j + 1, temp);
                }
            }
        }
        Long sum = 0L;
        for (Long a: listOfDataSets.get(listOfDataSets.size() - 1).KeyAndSizeOfDataSet.values()) {
            sum += a;
        }
        System.out.println("Data Set: " + listOfDataSets.get(listOfDataSets.size() - 1).NameOfDataSet + ", Total Size: " + sum);
        listOfDataSets.get(listOfDataSets.size() - 1).KeyAndSizeOfDataSet.forEach((k, v) -> System.out.println("$." + k));
    }
}
